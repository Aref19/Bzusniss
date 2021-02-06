package com.example.business.DatenBank

import androidx.room.*

@Dao
interface GoodsInterface {


    @Query("select * From goods")
    fun getAll():List<SaveGoodsDB.Goodssache>
    @Insert
    fun insertAll(goodssache: SaveGoodsDB.Goodssache)
    @Delete
    fun delete(goodssache: SaveGoodsDB.Goodssache)
    @Query("update goods set  count =  :countnew where name = :name ")
    fun updateitem(countnew:String,name:String)
    @Query("select * from goods where name=  :name")
    fun selectitem(name : String):SaveGoodsDB.Goodssache


}