package com.example.business.Goods

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.example.business.Information
import com.example.business.R
import com.example.business.SaveShared.SaveShard
import kotlinx.android.synthetic.main.activity_save_goods.*

class SaveGoods : AppCompatActivity() {
    var table: TableLayout? = null
    var nameBusniss: TextView? = null
    var waren: ListView? = null
    var things = mutableListOf<Goodssave>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_goods)
        nameBusniss = findViewById(R.id.namege) as TextView
        nameBusniss!!.setText(SaveShard.context(this).getNameofBusniss())
        table = findViewById(R.id.tableofgoods)
        waren = findViewById(R.id.userthings)

    }

    fun fullTabel() {
        var sache = Goodssave(
            namegood.text.toString(),
            priceofGoods.text.toString(),
            countofcods.text.toString()
        )

        things!!.add(sache)
        Log.i("Bus", "fullTabel: " + namegood.text.toString())
        var adpter = AdpterOfGood(things ,this)
        waren!!.adapter = adpter

    }

    fun insert(view: View) {
        fullTabel()
    }

    class AdpterOfGood : BaseAdapter {
        var waren = mutableListOf<Goodssave>()
        var cont: Context? = null

        constructor(waren: MutableList<Goodssave>, cont: Context) {
            this.waren = waren
            this.cont = cont

        }

        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            var v: View? = null
            v = LayoutInflater.from(cont).inflate(R.layout.table_adpter, p2, false)
            var e1= v.findViewById<EditText>(R.id.nameofgooda)
            var e2= v.findViewById<EditText>(R.id.pricofgooda)
            var e3= v.findViewById<EditText>(R.id.acountofgooda)

            e1.setText(waren!!.get(p0).getwarenname())
            e2.setText(waren!!.get(p0).getPreic())
            e3.setText(waren!!.get(p0).getCount())


            return v!!
        }

        override fun getItem(p0: Int): Any {
            return waren!!.get(p0).getwarenname()
        }

        override fun getItemId(p0: Int): Long {
            return p0 as Long
        }

        override fun getCount(): Int {
            return waren!!.size
        }

    }
}

