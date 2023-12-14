package com.example.riddlemiddle.SelectionActivity


import android.os.Bundle
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.riddlemiddle.R


data class Item(val buttonText: String, val isIndicatorOn: Boolean)






class ActiveRiddleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.riddle_selection_activity)

        // Assuming you have a ListView with ID "myListView" in your activity layout
        val listView = findViewById<ListView>(R.id.myListView)

        // Example list of items
        val itemList = listOf(
            Item("Button 1", true),
            Item("Button 2", false),
            // Add more items as needed
        )

        // Create and set the adapter
        val customAdapter = CustomAdapter(this, itemList)
        listView.adapter = customAdapter
    }

}







class CustomAdapter(private val context: Context, private val itemList: List<Item>) : BaseAdapter() {

    override fun getCount(): Int {               return itemList.size }
    override fun getItem(position: Int): Any {    return itemList[position] }
    override fun getItemId(position: Int): Long { return position.toLong() }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val itemView = inflater.inflate(R.layout.item_layout, null)

        val currentItem = getItem(position) as Item

        // Now, you can use currentItem to set up the UI for this item
        val button = itemView.findViewById<Button>(R.id.myButton)
        currentItem.buttonText.also { button.text = it }

        val indicator = itemView.findViewById<ImageView>(R.id.myIndicator)
        if (currentItem.isIndicatorOn) {
            // Set indicator on
        } else {
            // Set indicator off
        }
        return itemView
    }
}








