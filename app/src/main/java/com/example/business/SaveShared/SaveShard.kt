package com.example.business.SaveShared

import android.content.Context
import com.example.business.Information
import kotlinx.android.synthetic.main.activity_main.*

class SaveShard {
        private var cons:Context? = null

   constructor(con:Context){
       this.cons=con
   }

    fun  context(con: Context):SaveShard {
        return SaveShard(con)
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
    fun saveNameperson(usernamebus:String){
        val shared = cons?.getSharedPreferences(Information.key,Context.MODE_PRIVATE)
        if (shared != null) {
            with (shared.edit()) {
                putString(com.example.business.Information.nameb,usernamebus)
                apply()
            }
        }
    }
    fun savepass(usernamebus:String){
        val shared = cons?.getSharedPreferences(Information.key,Context.MODE_PRIVATE)
        if (shared != null) {
            with (shared.edit()) {
                putString(com.example.business.Information.passg,usernamebus)
                apply()
            }
        }
    }

       fun getNameofBusniss() : String? {
           val shared = cons?.getSharedPreferences(Information.key, Context.MODE_PRIVATE)
           var name:String?=null
           if (shared != null) {
               name =shared.getString(Information.nameg, "")
           };
           return name
    }
      companion object{
          fun  context(con: Context):SaveShard {
              return SaveShard(con)
          }
      }
    fun getname() : String? {
        val shared = cons?.getSharedPreferences(Information.key, Context.MODE_PRIVATE)
        var name:String?=null
        if (shared != null) {
            name =shared.getString(Information.nameb, "")
        };
        return name
    }
    fun getpass() : String? {
        val shared = cons?.getSharedPreferences(Information.key, Context.MODE_PRIVATE)
        var name:String?=null
        if (shared != null) {
            name =shared.getString(Information.passg, "")
        };
        return name
    }

         }

