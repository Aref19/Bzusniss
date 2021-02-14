package com.example.business.DatenBank

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SaveGoodsDB.Goodssache::class), version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun goodssachDao(): GoodsInterface

    companion object {
        @Volatile
        private var Intanc: AppDataBase? = null

        fun getDateBase(con: Context): AppDataBase {
            val temins = Intanc
            if (temins != null) {
                return temins
            }
            synchronized(this) {
                val insta = Room.databaseBuilder(
                    con.applicationContext,
                    AppDataBase::class.java, "GoodsData"
                ).allowMainThreadQueries().build()
                return insta
            }


        }

    }


}