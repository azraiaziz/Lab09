package com.example.lab09

import android.content.ClipData.Item
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab09.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    //bila menu dibuat, this function will be called
    //initialize the menu, point the activity to the right menu file
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //dapatkan file menu.xml di dalam folder menu
        //keluarkan (inflate) menu di sini
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //bila menu item dipilih
    //create a when (switch) statement to perform the execution for the menu
    //override panggil function dari parent, in addition to what you are doing i want to do something else
    //start type from "onOption"
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.about_us -> {
                //buka chrome atau internet dan tunjukkan website tertentu: peoplelogy
                //try "val intent" OR ""
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://peoplelogy.com/our-story/"))
                startActivity(intent)
            }
            R.id.email_us -> {
                //buka email dan set email title : App Feedback and to: "contact@peoplelogy.com.my"
                val intent = Intent(Intent.ACTION_SEND).apply {
                    type = "message/rfc822"
                    putExtra(Intent.EXTRA_EMAIL, arrayOf("contact@peoplelogy.com.my"))
                    putExtra(Intent.EXTRA_SUBJECT, "App Feedback")
                }
                startActivity(Intent.createChooser(intent, "Send Email"))
            }
            R.id.call_us -> {
                //add second option to call directly the number
                //request functionality from other android component
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel: 0123456789")
                startActivity(intent)
            }
            R.id.exit -> finish()
        }
        return super.onOptionsItemSelected(item)
    }
}