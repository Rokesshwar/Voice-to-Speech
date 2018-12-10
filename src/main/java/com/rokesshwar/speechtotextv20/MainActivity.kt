package com.rokesshwar.speechtotextv20

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.toolbar
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {
    var langCheck = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        tamil.setOnClickListener {
            langCheck=1
            intent()
        }
        telugu.setOnClickListener {
            langCheck=2
            intent()
        }
            malayalam.setOnClickListener {
            langCheck=3
            intent()
        }
        english.setOnClickListener {
            langCheck=4
            intent()
        }
        hindi.setOnClickListener {
            langCheck=5
            intent()
        }
        kannada.setOnClickListener {
            langCheck=6
            intent()
        }
        marathi.setOnClickListener {
            langCheck=7
            intent()
        }

    }


    private fun intent() {
        val intent = Intent(this, Main2Activity::class.java)
        val bundle=Bundle()
        bundle.putInt("check",langCheck)
       intent.putExtra("bundle",bundle)
        startActivity(intent)
    }
    override fun onBackPressed() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure!")
        builder.setMessage("Do you want to close the app?")
        builder.setPositiveButton("Yes") { dialogInterface: DialogInterface, i: Int ->
            finish()
        }
        builder.setNegativeButton("No") { dialogInterface: DialogInterface, i: Int -> }
        builder.show()
    }

}