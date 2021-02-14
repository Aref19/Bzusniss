
package com.example.business

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast

import androidx.core.widget.doOnTextChanged
import com.example.business.Goods.SaveGoods
import com.example.business.SaveShared.SaveShard
import com.example.business.User.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var user = User()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        user.setbus(username.text.toString())
        user.setbus(userpass.text.toString())
        user.setbus(usernamebus.text.toString())
        textChang()

    }

    fun textChang() {
        usernamebus.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                textshowr.setText(p0)
            }


        })

    }

    fun registieren(view: View) {
        if (checkpass()) {
            val int = Intent(this, SaveGoods::class.java)
            startActivity(int)
        } else
            Toast.makeText(this, "things it wrong ", Toast.LENGTH_LONG).show()

    }

    fun checkpass(): Boolean {
        if (userpass.text.toString().equals(userpass2.text.toString())) {
            SaveShard.context(this).saveNameBusniss(usernamebus.text.toString())
            SaveShard.context(this).saveNameperson(username.text.toString())
            SaveShard.context(this).savepass(userpass2.text.toString())
            return true;
        } else {
            return false;
        }


    }


}

class Information {
    companion object {
        val key: String? = "com.android.application.shared_prefs"
        val nameg: String? = "name_Geschäft"
        val nameb: String? = "name_user"
        val passg: String? = "pass_user"
    }

}

