package com.example.business.Goods

import android.app.AlertDialog
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.GoodsInterface
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.MainFunctions.Kasse

class Mvp {
    var goods: GoodsCatch? = null
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
    }

    fun getInstanceFromDataBane(): GoodsInterface {
        return AppDataBase.getDateBase(context!!).goodssachDao()
    }

    fun getDataFromDatenBank(): List<SaveGoodsDB.Goodssache> {
        listOfGoods = getInstanceFromDataBane().getAll()
        return listOfGoods!!
    }

    fun addElement(goods: SaveGoodsDB.Goodssache) {
        if (!namekaufgoodk!!.text.toString().equals("") && !pricegoodskaufk!!.text.toString()
                .equals("") && !countkaufk!!.text.toString().equals("")
        ) {
            getInstanceFromDataBane().insertAll(goods)
            fullTable()
        } else
            Toast.makeText(context, "check your field", Toast.LENGTH_LONG).show()


    }

    fun fullTable() {
        goods!!.fullTable(getDataFromDatenBank())
    }

    fun deleteItem( newPrice: EditText) {
        var item = getInstanceFromDataBane().selectitem(namegoodk!!.text.toString())
        if(item.pice.toInt()< newPrice!!.text.toString().toInt()){
                checkProces()
           }else{
            if(checkProces()){
                var alert=AlertDialog.Builder(context)
                alert.setTitle("Worrong")
                alert.setMessage("the price should be changed  press No to skip or Yes to reject")
                alert.setPositiveButton("yes") { dialog, which ->
                    Toast.makeText(context, "its rejected", Toast.LENGTH_LONG).show()
                }
                alert.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(context, "It well countinu", Toast.LENGTH_SHORT).show()

                }
                alert.show()
            }

        }
        goods!!.selaItem()
}
    fun checkProces():Boolean{
        var item = getInstanceFromDataBane().selectitem(namegoodk!!.text.toString())
        if (RechnerKlass.newCount(item.count, countk!!.text.toString()).toInt() == 0) {
            getInstanceFromDataBane().delete(item)
            return true
        } else if (RechnerKlass.newCount(item.count, countk!!.text.toString()).toInt() < 0) {
            Toast.makeText(context, "you dont have so much ", Toast.LENGTH_LONG).show()
            return false
        } else{
            getInstanceFromDataBane().updateitem(
                RechnerKlass.newCount(item.count, countk!!.text.toString()),
                namegoodk!!.text.toString()
            )
            return true
        }


    }

}