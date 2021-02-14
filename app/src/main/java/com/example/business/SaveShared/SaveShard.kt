package com.example.business.SaveShared

import android.content.Context
import com.example.business.Information
import kotlinx.android.synthetic.main.activity_main.*

class SaveShard {
        private var cons:Context? = null

   constructor(con:Context){
       this.cons=con
   }

    fun saveNameBusniss(usernamebus:String){
        val shared = cons?.getSharedPreferences(Information.key,Context.MODE_PRIVATE)
        if (shared != null) {
            with (shared.edit()) {
                putString(com.example.business.Information.nameg,usernamebus)
                apply()
            }
        }
    }
}