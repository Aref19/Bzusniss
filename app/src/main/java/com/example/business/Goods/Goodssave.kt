package com.example.business.Goods

class Goodssave {
    private var warname:String?=null
    private var preic:String?=null
    private var count:String?=null


    constructor(warname: String?, warAnzahl: String?, payPreis: String?) {
        this.warname = warname
        this.count = warAnzahl
        this.preic = payPreis

    }
    fun getwarenname():String{
        return warname!!
    }
    fun getPreic():String{
        return preic!!
    }
    fun getCount():String{
        return count!!
    }
     constructor(){

     }

    fun setwarname(name:String?){
        this.warname=name
    }
    fun setprice(price:String){
        this.preic=preic
    }
    fun setacount(acount:String){
        this.count=acount
    }
}