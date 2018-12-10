package com.rokesshwar.speechtotextv20

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.content_main2.*

import android.os.Bundle
import android.speech.RecognizerIntent
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*
import android.R.attr.label
import android.content.ClipData
import android.net.Uri
import android.view.MenuItem
import androidx.appcompat.widget.PopupMenu




class Main2Activity : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        info.setOnClickListener {
            val intent = Intent(this, DeveloperDetails::class.java)
            startActivity(intent)
        }
        clear.setOnClickListener {
            textView.text = ""
        }
        copy.setOnClickListener {
            val clipboard = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText(label.toString(), textView.text.toString())
            clipboard.primaryClip = clip
            Toast.makeText(this, "Copied to Clipboard", Toast.LENGTH_SHORT).show()
        }

        share.setOnClickListener {


                val popup: PopupMenu?
            popup = PopupMenu(this, share)
                popup.inflate(R.menu.popup_menu)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

                    when (item!!.itemId) {
                        R.id.watsapp -> {
                            val whatsappIntent = Intent(Intent.ACTION_SEND)
                            whatsappIntent.type = "text/plain"
                            whatsappIntent.setPackage("com.whatsapp")
                            whatsappIntent.putExtra(Intent.EXTRA_TEXT, textView!!.text.toString())
                            try {
                                startActivity(whatsappIntent)
                            } catch (ex: android.content.ActivityNotFoundException) {

                                val url = "https://play.google.com/store/apps/details?id=com.whatsapp&hl=en"
                                val i = Intent(Intent.ACTION_VIEW)
                                i.data = Uri.parse(url)
                                startActivity(i)                            }
                        }
                        R.id.fbook -> {
                            val facebook = Intent(Intent.ACTION_SEND)
                    facebook.type = "text/plain"
                    facebook.setPackage("com.facebook.katana")
                    facebook.putExtra(Intent.EXTRA_TEXT,  textView!!.text.toString())
                    try {
                        startActivity(facebook)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Wait to load", Toast.LENGTH_SHORT).show()

                        val url = "https://www.facebook.com"
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }
                        }
                        R.id.insram -> {
                            val instagram = Intent(Intent.ACTION_SEND)
                    instagram.type = "text/plain"
                    instagram.setPackage("com.instagram.android")
                    instagram.putExtra(Intent.EXTRA_TEXT,  textView!!.text.toString())
                    try {
                        startActivity(instagram)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Wait to load", Toast.LENGTH_SHORT).show()

                        val url = "https://www.instagram.com"
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }                        }
                        R.id.snap-> {
                            val snapcht = Intent(Intent.ACTION_SEND)
                            snapcht.type = "text/plain"
                            snapcht.setPackage("com.snapchat.android")
                            snapcht.putExtra(Intent.EXTRA_TEXT, textView!!.text.toString())
                            try {
                                startActivity(snapcht)
                            } catch (ex: android.content.ActivityNotFoundException) {
                                Toast.makeText(this, "Wait to load", Toast.LENGTH_SHORT).show()

                                val url = "https://play.google.com/store/apps/details?id=com.snapchat.android"
                                val i = Intent(Intent.ACTION_VIEW)
                                i.data = Uri.parse(url)
                                startActivity(i)
                            }
                        }
                        R.id.twtr-> {
                            val twitter = Intent(Intent.ACTION_SEND)
                            twitter.type = "text/plain"
                            twitter.setPackage("com.twitter.android.PostActivity")
                            twitter.putExtra(Intent.EXTRA_TEXT, textView!!.text.toString())
                            try {
                                startActivity(twitter)
                            } catch (ex: android.content.ActivityNotFoundException) {
                                Toast.makeText(this, "Wait to load", Toast.LENGTH_SHORT).show()

                                val url = "https://www.twitter.com"
                                val i = Intent(Intent.ACTION_VIEW)
                                i.data = Uri.parse(url)
                                startActivity(i)
                            }

                        }
                        R.id.clq-> {
                            val cliq = Intent(Intent.ACTION_SEND)
                    cliq.type = "text/plain"
                    cliq.setPackage("com.zoho.chat")
                    cliq.putExtra(Intent.EXTRA_TEXT,  textView!!.text.toString())
                    try {
                        startActivity(cliq)
                    } catch (ex: android.content.ActivityNotFoundException) {
                        Toast.makeText(this, "Wait to load", Toast.LENGTH_SHORT).show()

                        val url = "https://play.google.com/store/apps/details?id=com.zoho.chat"
                        val i = Intent(Intent.ACTION_VIEW)
                        i.data = Uri.parse(url)
                        startActivity(i)
                    }
                        }



                    }

                    true
                })

                popup.show()
            }

//    val whatsappIntent = Intent(Intent.ACTION_SEND)
//    whatsappIntent.type = "text/plain"
//    whatsappIntent.setPackage("com.whatsapp")
//    whatsappIntent.putExtra(Intent.EXTRA_TEXT, textView!!.toString())
//    try {
//        startActivity(whatsappIntent)
//    } catch (ex: android.content.ActivityNotFoundException) {
//        Toast.makeText(this,"https://www.web.whatsapp.com",Toast.LENGTH_SHORT).show()
//    }
//
//                facebook.setOnClickListener {
//                    val facebook = Intent(Intent.ACTION_SEND)
//                    facebook.type = "text/plain"
//                    facebook.setPackage("com.facebook.katana")
//                    facebook.putExtra(Intent.EXTRA_TEXT,  textView!!.toString())
//                    try {
//                        startActivity(facebook)
//                    } catch (ex: android.content.ActivityNotFoundException) {
//                        val url = "https://www.facebook.com"
//                        val i = Intent(Intent.ACTION_VIEW)
//                        i.data = Uri.parse(url)
//                        startActivity(i)
//                    }
//                }
//                cliq.setOnClickListener {
//
//                }
//                twitter.setOnClickListener {

//                }
//                snapchat.setOnClickListener {
//
//                }
//                instagram.setOnClickListener {
//                    val instagram = Intent(Intent.ACTION_SEND)
//                    instagram.type = "text/plain"
//                    instagram.setPackage("com.instagram.android")
//                    instagram.putExtra(Intent.EXTRA_TEXT,  textView!!.toString())
//                    try {
//                        startActivity(instagram)
//                    } catch (ex: android.content.ActivityNotFoundException) {
//                        val url = "https://www.instagram.com"
//                        val i = Intent(Intent.ACTION_VIEW)
//                        i.data = Uri.parse(url)
//                        startActivity(i)
//                    }
//                }
//               true
//            }
//            popup.show()



        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(true)
//        supportActionBar!!.setLogo(R.drawable.info)
//        supportActionBar!!.setDisplayUseLogoEnabled(true)


        val bundle = intent!!.extras?.getBundle("bundle")
        val langCheck = bundle!!.getInt("check")

        when (langCheck) {
            1 -> {
                val toast = Toast.makeText(this, "பேச மைக்கைத் தட்டவும்", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()

                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ta-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            2 -> {
                mic.setOnClickListener {
                    val toast = Toast.makeText(this, "మాట్లాడటానికి మైక్ను నొక్కండి", Toast.LENGTH_SHORT)
                    toast.setGravity(Gravity.CENTER, 0, 0)
                    toast.show()
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "te-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            5 -> {
                val toast = Toast.makeText(this, "बोलने के लिए माइक टैप करें", Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "hi-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            3 -> {
                val toast = Toast.makeText(this, "സംസാരിക്കാൻ മൈക്ക് ടാപ്പുചെയ്യുക", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "ml-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            4 -> {
                val toast = Toast.makeText(this, "Tap the mic to speak", Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.ENGLISH)

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            6 -> {
                val toast = Toast.makeText(this, "बोलने के लिए माइक टैप करें", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "kn-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)
                }
            }

            7 -> {
                val toast = Toast.makeText(this, "बोलण्यासाठी माइक टॅप करा", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.CENTER, 0, 0)
                toast.show()
                mic.setOnClickListener {
                    val i = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "mr-IN")

                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

                    startActivityForResult(i, 10)

                }
            }

        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            10 -> {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    val results = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    textView.text = results[0]
                }
            }
        }
        clear.isEnabled = textView.length() > 0
        clear.setOnClickListener {
            textView.text = ""
        }

    }




    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }




}




