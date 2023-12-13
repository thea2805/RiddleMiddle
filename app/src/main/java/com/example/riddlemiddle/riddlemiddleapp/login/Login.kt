package com.example.riddlemiddle.riddlemiddleapp.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.riddlemiddle.riddlemiddleapp.firestore.service.Firestore
import kotlinx.coroutines.launch

@Composable
fun LoginForm(service: Firestore, nav: NavController) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()



    Surface(color = MaterialTheme.colorScheme.primary){
        Box(){
            Row (modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 50.dp))
            {
                Text(text = "R",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.tertiary)
                Text(text = "i",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.secondary)
                Text(text = "ddle M",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.tertiary)
                Text(text = "i",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.secondary)
                Text(text = "ddle",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.tertiary)
            }

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)
            )
            {
                Spacer(modifier = Modifier.height(50.dp))
                LoginField(
                    value = email.value,
                    onChange = { newText -> email.value = newText },
                    modifier = Modifier.fillMaxWidth())

                PasswordField(
                    value = password.value,
                    onChange = {newText -> password.value = newText },
                    modifier = Modifier.fillMaxWidth() )

                Spacer(modifier = Modifier.height(50.dp))

                Button(onClick = {
                    scope.launch {
                        service.login(email.value, password.value)
                        nav.navigate("StartScreen")
                    }
                },
                    modifier = Modifier.width(150.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)) {
                    Text(text = "Login")
                }
                Button(onClick = {
                    scope.launch {
                        val user = service.signup(email.value,password.value)
                        service.createUser(email.value, password.value)
                }},
                    modifier = Modifier.width(150.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)) {
                    Text(text = "Sign up")
                }
                TextButton(
                    onClick = { }
                ) {
                    Text("Forgot Password?", color = MaterialTheme.colorScheme.secondary)
                }


            }
        }

    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Email",
    placeholder: String = "Enter your Email")
{
    val focusManager = LocalFocusManager.current
    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Person,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
        keyboardActions = KeyboardActions(onNext = {focusManager.moveFocus(FocusDirection.Down)}),
        placeholder = { Text(text = placeholder)},
        label = { Text(text = label)},
        singleLine = true,
        visualTransformation = VisualTransformation.None
        )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PasswordField(
    value: String,
    onChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Password",
    placeholder: String = "Enter your Password")
{
    //val focusManager = LocalFocusManager.current
    //var isPasswordVisible by remember {mutableStateOf(false)}

    val leadingIcon = @Composable {
        Icon(
            Icons.Default.Lock,
            contentDescription = "",
            tint = MaterialTheme.colorScheme.tertiary
        )
    }
/*
    val trailingIcon = @Composable {
        IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
            Icon(
                if(isPasswordVisible) Icons.Default.VisibilityOff else Icons.Default.Visibility,
                contentDescription = "",
                tint = MaterialTheme.colorScheme.tertiary
            )
        }
    }

 */

    TextField(
        value = value,
        onValueChange = onChange,
        modifier = modifier,
        leadingIcon = leadingIcon,
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Password),
        keyboardActions = KeyboardActions(onDone = {submit()}),
        placeholder = { Text(text = placeholder)},
        label = { Text(text = label)},
        singleLine = true,
        visualTransformation = VisualTransformation.None
    )
}

fun submit() {
    TODO("Not yet implemented")
}


/*
@Preview
@Composable
fun LoginPreview(){
    RiddleMiddleTheme(darkTheme = true) {
        LoginForm()
    }
}*/
