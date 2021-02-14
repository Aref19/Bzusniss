package com.example.business.Adpters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.business.Goods.Goods
import com.example.business.Goods.Goodssave
import com.example.business.R

class AdpterRow : BaseAdapter {
    var waren:List<Goodssave>?=null
    var con:Context?=null
    constructor(waren:List<Goodssave>,con:Context){
        this.waren=waren
        this.con=con
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var v:View?=null
        v = LayoutInflater.from(con).inflate(R.layout.table_adpter, p2, false)
        var e1 = v.findViewById<TextView>(R.id.nameofgooda)
        var e2 = v.findViewById<TextView>(R.id.pricofgooda)
        var e3 = v.findViewById<TextView>(R.id.acountofgooda)
        e1.setText(waren!!.get(p0).getwarenname())
        e2.setText(waren!!.get(p0).getPreic())
        e3.setText(waren!!.get(p0).getCount())
        return v!!
    }

    override fun getItem(p0: Int): Any {
      return  waren!!.get(p0).getwarenname()
    }

    override fun getItemId(p0: Int): Long {
      return   p0.toLong()
    }

    override fun getCount(): Int {
        return waren!!.size
    }
}