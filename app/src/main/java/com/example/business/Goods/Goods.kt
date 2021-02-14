
package com.example.business.Goods

class Goods {
    private var warname:String?=null
    private var warAnzahl:Int?=null
    private var payPreis:Double?=null


    constructor(warname: String?, warAnzahl: Int?, payPreis: Double?) {
        this.warname = warname
        this.warAnzahl = warAnzahl
        this.payPreis = payPreis

    }
    fun getwarenname():String{
        return warname!!
    }




}