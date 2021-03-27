package com.example.business.Goods

import android.app.Activity
import android.app.AlertDialog
import android.app.Application
import android.content.Context
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.GoodsInterface
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.MainFunctions.Kasse
import com.example.business.MainFunctions.saleInterface
import java.util.*

class Mvp  :saleInterface{
    var goods: GoodsCatch? = null
    var saleInterface: saleInterface? = null
    var listOfGoods: List<SaveGoodsDB.Goodssache>? = null
    var context: Context? = null
    var namekaufgoodk: EditText? = null
    var pricegoodskaufk: EditText? = null
    var countkaufk: EditText? = null
    var namegoodk: EditText? = null

    var countk: EditText? = null

    constructor(
        context: Context,
        name: EditText,
        price: EditText,
        count: EditText,
        namegoodk: EditText,
        goods: GoodsCatch,
        countk: EditText?

    ) {
        this.context = context
        this.namekaufgoodk = name
        this.pricegoodskaufk = price
        this.countkaufk = count
        this.goods = goods
        this.namegoodk = namegoodk
        this.countk = countk

        namesSpeicher()
    }

    fun getInstanceFromDataBane(c :Context): GoodsInterface {
        return AppDataBase.getDateBase(c!!).goodssachDao()
    }


    fun getDataFromDatenBank(): List<SaveGoodsDB.Goodssache> {
        listOfGoods = getInstanceFromDataBane(context!!).getAll()
        return listOfGoods!!
    }

    fun addElement(goods: SaveGoodsDB.Goodssache) {
        if (!namekaufgoodk!!.text.toString().equals("") && !pricegoodskaufk!!.text.toString()
                .equals("") && !countkaufk!!.text.toString().equals("")
        ) {
            getInstanceFromDataBane(context!!).insertAll(goods)
            fullTable()
        } else
            Toast.makeText(context, "check your field", Toast.LENGTH_LONG).show()


    }

    fun fullTable() {
        goods!!.fullTable(getDataFromDatenBank())
    }

    fun deleteItem( newPrice: EditText) {
        val namegs:String?=namegoodk!!.text.toString()
        val counts:String?=countk!!.text.toString()
        val price:String?=newPrice!!.text.toString()
        var item = getInstanceFromDataBane(context!!).selectitem(namegoodk!!.text.toString())
        if(item.pice.toInt()< newPrice!!.text.toString().toInt()){
                checkProces(context!!,namegs!!,counts!!,price!!)
           }else{

            var alert=AlertDialog.Builder(context)
            alert.setTitle("Worrong")
            alert.setMessage("the price should be changed  press No to skip or Yes to reject")
            alert.setPositiveButton("yes") { dialog, which ->
                Toast.makeText(context, "its rejected", Toast.LENGTH_LONG).show()
            }
            alert.setNegativeButton("No") { dialog, which ->
                Toast.makeText(context, "It well countinu", Toast.LENGTH_SHORT).show()
                checkProces(context!!,namegs!!,counts!!,price!!)


            }
            alert.show()

        }
        goods!!.selaItem()
}
    fun checkProces(c:Context,name:String,count:String,price: String):Boolean{

        var item = getInstanceFromDataBane(c!!).selectitem(name!!)
        Log.i("item", "checkProces: "+item)
        if (RechnerKlass.newCount(item.count, count!!).toInt() == 0) {
            getInstanceFromDataBane(c!!).delete(item)
            return true
        } else if (RechnerKlass.newCount(item.count,count!!).toInt() < 0) {
            Toast.makeText(context, "you dont have so much ", Toast.LENGTH_LONG).show()
            return false
        } else{

            getInstanceFromDataBane(c!!).updateitem(
                RechnerKlass.newCount(item.count, count),
                name!!
            )
            var data=Calendar.getInstance()
            var datum:String=""+data.get(Calendar.DAY_OF_MONTH)+"/"+data.get(Calendar.MONTH)+"/"+data.get(Calendar.YEAR)
            Log.i("datum", "checkProces: "+datum)
            var saledsGoods=SaledsGoods(name,count,price)
             saledsGoods.setdata(datum)
            Log.i("datum", "checkProces: "+datum)
        //    getInstanceFromDataBane(c).insertinSaled()


            return true
        }


    }
    fun namesSpeicher(){
        val namegs=namegoodk!!.text.toString()
        val counts=countk!!.text.toString()

    }

    override fun nameAndCount() {


    }


}