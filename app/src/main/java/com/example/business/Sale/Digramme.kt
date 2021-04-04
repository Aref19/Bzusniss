package com.example.business.Sale

import android.app.Activity
import android.content.Context
import android.os.Build
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import com.anychart.anychart.*
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.R

class Digramme(context: Context) {
    var con: Context = context




companion object{



    fun rechnen(saledGoods: List<SaveGoodsDB.SaledGoods>): List<Zumrechenn> {
        var lis: List<SaveGoodsDB.SaledGoods> = saledGoods
        var liszusa: MutableList<Zumrechenn> = arrayListOf()
        var name: String = ""
        var name1: String = ""
        var mals: Double = 0.0
        var map = hashMapOf<String, Double>()
        for (i in 0..lis.size - 1) {
            Log.i("ff", "rechnen: " + i)
            name = lis[i].name.toString()
            if (!name1.contains(name)) {
                for (y in 0..lis.size - 1) {
                    if (lis[y].name.equals(name)) {
                        mals += 1
                    }
                    if (y == lis.size - 1) {
                        map.put(name, mals)
                        liszusa.add(Zumrechenn(name,(((mals/lis.size)*1000.0)/100.0)))
                        Log.i("size", "rechnen: "+(((mals/lis.size)*1000.0))/100.0)
                        name1 += name
                        mals=0.0




                    }

                }
            }


        }
        Log.i(
            "versuch",
            "rechnen: " + "key :" + map.keys + "naem :" + map.get("Z")+map.get("G"))

        return liszusa
    }
}


    class Zumrechenn(name: String, bereich: Double) {
        var name: String = name
        var bereic: Double = bereich
    }
}