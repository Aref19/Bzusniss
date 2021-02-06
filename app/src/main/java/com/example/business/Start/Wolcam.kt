package com.example.business.Start

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.business.Goods.SaveGoods
import com.example.business.MainActivity
import com.example.business.MainFunctions.Kasse
import com.example.business.R
import com.example.business.SaveShared.SaveShard

class Wolcam : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wolcam)
      // thered()
        Thread({
            Thread.sleep(2000)
            var intent:Intent
            if (!SaveShard.context(application).getNameofBusniss().equals("")) {
                intent = Intent(application, Kasse::class.java)
            } else
                intent = Intent(application, Start::class.java)

            startActivity(intent)
        }).start()
/*
        Thread().run() {
            var intent: Intent? = null
            try {
                Thread.sleep(2000)
                if (!SaveShard.context(application).getNameofBusniss().equals("")) {
                    intent = Intent(application, SaveGoods::class.java)
                } else
                    intent = Intent(application, Start::class.java)

                startActivity(intent)
                finish()
            } catch (e: Exception) {
            }


        }

 */
    }

    fun thered() {
        var intent: Intent? = null
        var thared =object : Thread() {

            override fun run(){
                try {

                    if (!SaveShard.context(application).getNameofBusniss().equals("")) {
                        intent = Intent(application, SaveGoods::class.java)
                    } else
                        intent = Intent(application, Start::class.java)

                    startActivity(intent)
                    finish()
                } catch (e: Exception) {
                }
            }
        }
        thared.start()
        Thread.sleep(2000)
    }


}
