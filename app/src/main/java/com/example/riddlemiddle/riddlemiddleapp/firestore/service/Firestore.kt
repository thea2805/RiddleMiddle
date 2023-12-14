package com.example.riddlemiddle.riddlemiddleapp.firestore.service

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine
import android.util.Log

class Firestore(private val api: FirebaseFirestore, private val auth: FirebaseAuth) {
    companion object{
        const val TAG = "FIRE_STORE_SERVICE"
    }

    fun getCurrentUser(): String{
        return auth.currentUser?.email.toString()
    }

    suspend fun SignOut(){
        auth.signOut()
    }

    suspend fun signup(email: String, password: String){
        suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Log.d(TAG, "CreateUserWithEmail:Success")
                        val user = auth.currentUser ?: throw Exception("Something went wrong")
                        val signedInUser = user.email?.let { User(user.providerId, it) }
                            ?: throw Exception("CreateUserWithEmail:$email Failure")
                        continuation.resume(signedInUser)
                    }
                    else {
                        // Display message to the user that the sign up has failed

                        Log.w(TAG, "CreateUserWithEmail:Failure", task.exception)
                        throw Exception("CreateUserWithEmail:$email Failure", task.exception)
                    }
                }
        }
    }

    suspend fun login(email: String, password: String){
        suspendCoroutine { continuation ->
            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Log.d(TAG, "SignInUserWithEmail:Success")
                        val user = auth.currentUser ?: throw Exception("Something went wrong")
                        val signedInUser = user.email?.let {User(user.providerId, it)}
                            ?: throw Exception("SignInUserWithEmail:$email Failure")
                        continuation.resume(signedInUser)
                    }
                    else {
                        // Display message to the user that the login has failed
                        Log.w(TAG, "SignInUserWithEmail:Failure", task.exception)
                        throw Exception("SignInUserWithEmail:$email Failure", task.exception)
                    }
                }
        }
    }

    public fun addUserToFirebase(email: String, password: String) {
        val user = hashMapOf("Email" to email, "Password" to password)
        val uid = auth.currentUser!!.uid
        api.collection("users").document(uid).set(user)
        Log.d(TAG, "userID: $uid, added to database?")
    }

    suspend fun createShortRiddle(title: String, riddle: String, answer: String){
        val shortRiddle = hashMapOf(
            "Title" to title,
            "Riddle" to riddle,
            "Answer" to answer)

        suspendCoroutine { continuation ->
            api.collection("ShortRiddle")
                .add(shortRiddle)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    continuation.resume(documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                    throw e
                }
        }
    }

    suspend fun getRiddles(): List<Riddle> {
        return suspendCoroutine { continuation ->
            api.collection("ShortRiddle")
                .get()
                .addOnSuccessListener {
                    val shortRiddles =
                        it.documents.map { d -> Riddle(
                            d.id,
                            d.data?.get("Title").toString(),
                            d.data?.get("Riddle").toString(),
                            d.data?.get("Answer").toString()) }
                    continuation.resume(shortRiddles)
                }.addOnFailureListener {
                    Log.v(TAG, "We failed $it")
                    throw it
                }
        }
    }

    suspend fun getUserRiddles(): List<Riddle> {
        return suspendCoroutine { continuation ->
            val uid = auth.currentUser!!.uid

            api.collection("users").document(uid).collection("completedRiddles")
                .get()
                .addOnSuccessListener {
                    val completedRiddles =
                        it.documents.map { d ->
                            Riddle(
                                d.id,
                                d.data?.get("Title").toString(),
                                d.data?.get("Riddle").toString(),
                                d.data?.get("Answer").toString()
                            )
                        }
                    continuation.resume(completedRiddles)
                }.addOnFailureListener {
                    Log.v(TAG, "We failed $it")
                    throw it
                }
        }
    }

    suspend fun addCompletedRiddle(title: String, riddle: String, answer: String){
        val completedRiddle = hashMapOf(
            "Title" to title,
            "Riddle" to riddle,
            "Answer" to answer)
        val uid = auth.currentUser!!.uid

        suspendCoroutine { continuation ->
            api.collection("users").document(uid).collection("completedRiddles")
                .add(completedRiddle)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                    continuation.resume(documentReference.id)
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                    throw e
                }
        }
    }

}