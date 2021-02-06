package com.example.business.Adpters

import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.business.Goods.Goods

class AdpterRow : BaseAdapter {
    var waren:ArrayList<Goods>?=null
    constructor(waren:ArrayList<Goods>){
        this.waren=waren
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var v:View?=null


        return v!!
    }

    override fun getItem(p0: Int): Any {
      return  waren!!.get(p0).getwarenname()
    }

    override fun getItemId(p0: Int): Long {
      return   p0 as Long
    }

    override fun getCount(): Int {
        return waren!!.size
    }
}