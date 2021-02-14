package com.example.business.DatenBank

import android.content.Context
import androidx.room.*

class SaveGoodsDB {


    @Entity(tableName = "goods")
    data class Goodssache(
        @PrimaryKey(autoGenerate = true) var id: Int,
        var name: String?,
        var pice: String,
        var count:String
    )





}
