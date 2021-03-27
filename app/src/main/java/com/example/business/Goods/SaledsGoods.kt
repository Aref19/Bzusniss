package com.example.business.Goods


class SaledsGoods (warenname:String,anzahl:String,preis:String): Goodssave(warenname,anzahl,preis) {

    var data:String?=null
    fun setdata(data:String){

    }
    fun getdata(): String{
        return data!!
    }

}