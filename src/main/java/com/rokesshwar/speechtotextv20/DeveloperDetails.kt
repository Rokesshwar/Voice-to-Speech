package com.rokesshwar.speechtotextv20

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_developer_details.*
import kotlinx.android.synthetic.main.content_main3.*


class DeveloperDetails : AppCompatActivity() {
    private val mobNumber = 7010874153

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_details)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
        call.setOnClickListener {
            onCall()
        }
//        Sms.setOnClickListener {
//
//            onSms()
//        }
        whats.setOnClickListener {
            onWhatsapp()
        }
    }

    private fun onCall() {
        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CALL_PHONE), "123".toInt()
            )
        } else {
            val intent = Intent(Intent.ACTION_CALL)
            intent.data = Uri.parse("tel:$mobNumber")
            startActivity(intent)
        }
    }

//    private fun onSms() {
////        val permissionCheck = ContextCompat.checkSelfPermission(this, android.Manifest.permission.SEND_SMS)
////        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
////            ActivityCompat.requestPermissions(
////                this, arrayOf(android.Manifest.permission.SEND_SMS), "123".toInt()
////            )
////
////        } else {
////            val uri = Uri.parse("smsto:$mobNumber")
////            val it = Intent(Intent.ACTION_SENDTO, uri)
////            startActivity(it)
////        }
//        val uri = Uri.parse("smsto:$mobNumber")
//        val i = Intent(Intent.ACTION_SENDTO, uri)
//        i.putExtra("sms_body", "")
//        i.setPackage("com.whatsapp")
//        startActivity(i)
//
//    }


    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    private fun onWhatsapp(){
        val url = "https://api.whatsapp.com/send?phone= ${7010874153}"
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        startActivity(i)
    }

}



