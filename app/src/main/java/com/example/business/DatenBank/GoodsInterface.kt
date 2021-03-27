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
    @Query("update goods set  count =  :countnew, name = :name1, pice= :price where name = :nameurs ")
    fun updatecomp(countnew:String,name1:String,price:String,nameurs:String)

    @Insert
    fun insertinSaled(goodssache: SaveGoodsDB.SaledGoods)
/*   @Delete
    fun deletefromsaled(goodssache: SaveGoodsDB.SaledGoods)
    @Query("select * from goods where name=  :name")
    fun selectitem(name : String):SaveGoodsDB.SaledGoods

     */



}