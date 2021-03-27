
package com.example.business.Goods

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.room.Room
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.Information
import com.example.business.MainFunctions.Kasse
import com.example.business.R
import com.example.business.SaveShared.SaveShard
import kotlinx.android.synthetic.main.activity_save_goods.*

open class SaveGoods : AppCompatActivity() {
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
        if(!namegood.text.toString().equals("")&&!priceofGoods.text.toString().equals("")&&!countofcods.text.toString().equals("")){
            var sache = Goodssave(
                namegood.text.toString(),
                priceofGoods.text.toString(),
                countofcods.text.toString()
            )
            things!!.add(sache)
            Log.i("Bus", "fullTabel: " + namegood.text.toString())
            var adpter = AdpterOfGood(things, this)
            waren!!.adapter = adpter

            namegood.setText("")
            priceofGoods.setText("")
            countofcods.setText("")
        }else
            Toast.makeText(this,"Plase insert Data",Toast.LENGTH_LONG).show()





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
            var e1 = v.findViewById<TextView>(R.id.nameofgooda)
            var e2 = v.findViewById<TextView>(R.id.pricofgooda)
            var e3 = v.findViewById<TextView>(R.id.acountofgooda)

            e1.setText(waren!!.get(p0).getwarenname())
            e2.setText(waren!!.get(p0).getPreic())
            e3.setText(waren!!.get(p0).getCount())


            return v!!
        }

        override fun getItem(p0: Int): Any {
            return waren!!.get(p0).getwarenname()
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()

        }

        override fun getCount(): Int {
            return waren!!.size
        }

    }

    fun saveData(view: View) {
        saveDateinDatenBank(things)
        val int = Intent(this, Kasse::class.java)
        startActivity(int)

    }

    fun saveDateinDatenBank(goods: MutableList<Goodssave>) {
        var dp = AppDataBase.getDateBase(this).goodssachDao()
        for (good in goods) {
            dp.insertAll(
                SaveGoodsDB.Goodssache(

                    good.getwarenname(),
                    good.getPreic(),
                    good.getCount()
                )
            )
        }
        var lsit = dp.getAll()
        Log.i("fromdata", "saveDateinDatenBank: " + lsit.get(0).name)


    }
}


