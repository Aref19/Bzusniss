package com.example.business.MainFunctions

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.business.Adpters.AdpterRow
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.Goods.GoodsCatch
import com.example.business.Goods.Goodssave
import com.example.business.Goods.Mvp
import com.example.business.Goods.RechnerKlass
import com.example.business.R
import com.example.business.Sale.Wins
import com.example.business.SaveShared.SaveShard

class Kasse : AppCompatActivity(), saleInterface,GoodsCatch {
    var listgoodssave = mutableListOf<Goodssave>()
    var lsiview: ListView? = null
    var nameg: TextView? = null
    var namekaufgoodk: EditText? = null
    var pricegoodskaufk: EditText? = null
    var countkaufk: EditText? = null
    var namegoodk: EditText? = null
    var pricegoodsk: EditText? = null
    var countk: EditText? = null
    var tooL: androidx.appcompat.widget.Toolbar? = null
    var win: ImageButton? = null
    var dabte: ImageButton? = null
    var goodsCatch:Mvp?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_sale_and_pay)
        lsiview = findViewById(R.id.userthingsk)
        nameg = findViewById(R.id.namegek)
        nameg!!.setText(SaveShard(this).getNameofBusniss())
        namekaufgoodk = findViewById(R.id.namegoodkaufk)
        pricegoodskaufk = findViewById(R.id.priceofGoodkaufk)
        countkaufk = findViewById(R.id.countofkaufk)
        namegoodk = findViewById(R.id.namegoodk)
        pricegoodsk = findViewById(R.id.priceofGoodk)
        countk = findViewById(R.id.countofcodk)
        win = findViewById(R.id.wins)
        dabte = findViewById(R.id.Debt)
        goodsCatch= Mvp(this,namekaufgoodk!!,pricegoodskaufk!!,countkaufk!!,namegoodk!!,this,countk!!)
        var inte: Intent
        win!!.setOnClickListener(View.OnClickListener {
            inte = Intent(application, Wins::class.java)
            startActivity(inte)
        })
        dabte!!.setOnClickListener({
            inte = Intent(application, Wins::class.java)
            startActivity(inte)


        })

        goodsCatch!!.fullTable()
        listview()
    }


    fun addNew(view: View) {
      addElement()
    }

    fun updatecount() {
        var dp = AppDataBase.getDateBase(this).goodssachDao()
        var item = dp.selectitem(namegoodk!!.text.toString())
        Log.i("counter", "udatecount: " + item.name)
        // if(RechnerKlass.priceColluction(item.pice.toString(),pricegoodsk!!.text.toString(),this)){
        if (RechnerKlass.newCount(item.count, countk!!.text.toString()).toInt() == 0) {
            dp.delete(item)
        } else if (RechnerKlass.newCount(item.count, countk!!.text.toString()).toInt() < 0) {
            Toast.makeText(this, "you dont have so much ", Toast.LENGTH_LONG).show()
        } else
            dp.updateitem(
                RechnerKlass.newCount(item.count, countk!!.text.toString()),
                namegoodk!!.text.toString()
            )

    }



    fun listConten(e: EditText): Boolean {
        var status: Boolean = false
        for (good in listgoodssave) {
            if (good.getwarenname().equals(e.text.toString())) {
                status = true
            }
        }
        return status
    }

    fun refreach(view: View) {
        goodsCatch!!.fullTable()
    }

    fun listview() {
        lsiview!!.setOnItemClickListener { parent, view, position, id ->
            var text1 = view.findViewById<TextView>(R.id.nameofgooda)
            var text2 = view.findViewById<TextView>(R.id.pricofgooda)
            var text3 = view.findViewById<TextView>(R.id.acountofgooda)
            var dp = AppDataBase.getDateBase(application).goodssachDao()
            val fragmentManager = supportFragmentManager.beginTransaction()
            val myuppop = Upop(text1.text.toString(), text2.text.toString(), text3.text.toString())
            myuppop.show(fragmentManager, null)
            Log.i("Yallah", "listview: " + dp.selectitem(text1.text.toString()))
        }
    }





    override fun fullTable(list: List<SaveGoodsDB.Goodssache>){listgoodssave.clear()
        for (good in list) {
            Log.i("fromdata", "saveDateinDatenBank: " + list.get(0).count)
            listgoodssave.add(Goodssave(good.name, good.count, good.pice))
        }
        var adp = AdpterRow(listgoodssave, this)
        lsiview!!.adapter = adp
    }

    override fun addElement() {
        goodsCatch!!.addElement(SaveGoodsDB.Goodssache(namekaufgoodk!!.text.toString(), pricegoodskaufk!!.text.toString()
            ,countkaufk!!.text.toString()))
    }

    override fun selaItem() {
        listgoodssave.clear()
        namegoodk!!.setText("")
        pricegoodsk!!.setText("")
        countk!!.setText("")
    }

    fun update(view: View) {
        if(!namegoodk!!.text.equals("")&&!!pricegoodsk!!.text.equals("")&&!countk!!.text.equals(""))
            goodsCatch!!.deleteItem(pricegoodsk!!)



    }


}