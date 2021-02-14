package com.example.business.MainFunctions

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast



import com.example.business.Adpters.AdpterRow
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.Goods.Goodssave
import com.example.business.Goods.RechnerKlass
import com.example.business.Goods.saleInterface
import com.example.business.R
import com.example.business.SaveShared.SaveShard

class Kasse : AppCompatActivity() ,saleInterface {
    var list = mutableListOf<Goodssave>()
    var lsiview: ListView? = null
    var nameg: TextView? = null
    var namekaufgoodk: EditText? = null
    var pricegoodskaufk: EditText? = null
    var countkaufk: EditText? = null
    var namegoodk: EditText? = null
    var pricegoodsk: EditText? = null
    var countk: EditText? = null

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


        fuultable(this)
    }

    private fun fuultable(con :Context) {
        list.clear()
        var listofgoods = AppDataBase.getDateBase(con).goodssachDao().getAll()
        for (good in listofgoods) {
            Log.i("fromdata", "saveDateinDatenBank: " + listofgoods.get(0).count)
            list.add(Goodssave(good.name, good.count, good.pice))
        }
        var adp = AdpterRow(list, this)
        lsiview!!.adapter = adp

    }

    fun addNew(view: View) {
        addNewElemnet()


    }

    fun addNewElemnet() {
        if (!namekaufgoodk!!.text.toString().equals("") && !pricegoodskaufk!!.text.toString()
                .equals("") && !countkaufk!!.text.toString().equals("")
        ) {
            var dp = AppDataBase.getDateBase(this).goodssachDao()
            dp.insertAll(
                SaveGoodsDB.Goodssache(
                    0,
                    namekaufgoodk!!.text.toString(),
                    pricegoodskaufk!!.text.toString(),
                    countkaufk!!.text.toString()
                )
            )
            list.clear()
            fuultable(this)
            namekaufgoodk!!.setText("")
            pricegoodskaufk!!.setText("")
            countkaufk!!.setText("")
        } else
            Toast.makeText(this, "plase check your insert", Toast.LENGTH_LONG).show()
    }

    fun updatecount() {
        var dp = AppDataBase.getDateBase(this).goodssachDao()
        var item = dp.selectitem(namegoodk!!.text.toString())
        Log.i("counter", "udatecount: "+item.name)
       // if(RechnerKlass.priceColluction(item.pice.toString(),pricegoodsk!!.text.toString(),this)){
            if(RechnerKlass.newCount(item.count,countk!!.text.toString()).toInt()==0){
                dp.delete(item)
            }else if(RechnerKlass.newCount(item.count,countk!!.text.toString()).toInt()<0){
                Toast.makeText(this,"you dont have so much ",Toast.LENGTH_LONG).show()
            }else
                dp.updateitem( RechnerKlass.newCount(item.count,countk!!.text.toString()),namegoodk!!.text.toString())
            list.clear()
            namegoodk!!.setText("")
            pricegoodsk!!.setText("")
            countk!!.setText("")
            fuultable(this)
     //   }


    }

    fun update(view: View) {
      if(listConten(namegoodk!!))  {
          var dp = AppDataBase.getDateBase(this).goodssachDao()
          var item = dp.selectitem(namegoodk!!.text.toString())
          if(pricegoodsk!!.text.toString().toInt()>item.pice.toString().toInt()){
              updatecount()
          }else
              RechnerKlass.priceColluction(item.pice,pricegoodsk!!.text.toString(),this,
                  namegoodk!!,countk!!,pricegoodsk!!)
      }else
          Toast.makeText(this,"you dont have such goods",Toast.LENGTH_LONG).show()

    }

    override fun userbescheid(t: Boolean,con:Context,e:EditText,e1:EditText,e2:EditText) {
        var dp = AppDataBase.getDateBase(con).goodssachDao()
        var item = dp.selectitem(e!!.text.toString())
        Log.i("counter", "udatecount: "+item.name)
        if(t){
            if(RechnerKlass.newCount(item.count,e1!!.text.toString()).toInt()==0){
                dp.delete(item)
            }else if(RechnerKlass.newCount(item.count,e1!!.text.toString()).toInt()<0){
                Toast.makeText(this,"you dont have so much ",Toast.LENGTH_LONG).show()
            }else
                dp.updateitem( RechnerKlass.newCount(item.count,e1!!.text.toString()),e!!.text.toString())
            list.clear()
            e!!.setText("")
            e2!!.setText("")
            e1!!.setText("")

        }else
            Toast.makeText(con,"its rejected",Toast.LENGTH_LONG).show()
    }
    fun listConten(e:EditText):Boolean{
        var status:Boolean=false
        for (good in list){
            if(good.getwarenname().equals(e.text.toString())){
                status=true
            }
        }
        return status
    }

    fun refreach(view: View) {
        fuultable(this)
    }
}