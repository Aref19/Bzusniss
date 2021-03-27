package com.example.business.DatenBank

import android.content.Context
import androidx.annotation.NonNull
import androidx.room.*
import java.util.*

class SaveGoodsDB {


    @Entity(tableName = "goods")
    data class Goodssache(
        @PrimaryKey(autoGenerate = false)
        @NonNull
        var name: String,
        var pice: String,
        var count:String
    )

    @Entity(tableName = "saledGoods")
    class SaledGoods(
        @PrimaryKey(autoGenerate = false)
        var date:Date,
        var name: String?,
        var pice: String,
        var count:String
    )





}
