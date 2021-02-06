package com.example.business.Start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.business.Goods.SaveGoods
import com.example.business.MainActivity
import com.example.business.R
import com.example.business.SaveShared.SaveShard

class Start : AppCompatActivity() {
    var sign: EditText? = null
    var sigp: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        sign = findViewById(R.id.signname)
        sigp = findViewById(R.id.signpass)
    }

    fun check() {
        if (SaveShard.context(this).getname().equals(sign!!.text.toString()) &&
            SaveShard.context(this).getpass().equals(sigp!!.text.toString())
        ) {
            val int = Intent(this, SaveGoods::class.java)
            startActivity(int)
        } else {
            Toast.makeText(this, "plase check your pass or name", Toast.LENGTH_LONG).show()
        }
    }

    fun anmelden(view: View) {
        check()

    }

    fun rgsti(view: View) {
        val int = Intent(this, MainActivity::class.java)
        startActivity(int)

    }
}