package com.example.business.Sale

import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anychart.anychart.*
import com.example.business.Adpters.AdpterForrecs
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.R


class Wins : AppCompatActivity() {
    val winsViewModel: WinsViewModel = WinsViewModel()
    var list: List<SaveGoodsDB.SaledGoods>? = null
    var adpter: AdpterForrecs? = null
    var mListRecyclerView: RecyclerView? = null
    val pie = AnyChart.pie()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        winsViewModel.getsaled(this)

        setContentView(R.layout.activity_wins)
        mListRecyclerView = findViewById(R.id.recofgoods)
        val nameObserver = Observer<List<SaveGoodsDB.SaledGoods>> { newName ->
            // Update the UI, in this case, a TextView.
            list = newName
        }
        mListRecyclerView!!.layoutManager = LinearLayoutManager(this)
        winsViewModel.multi!!.observe(this, nameObserver)


    }

    fun get(view: View) {
        Log.i("falsch", "onCreate: " + list!!.get(0).name)




    }

    override fun onResume() {
        super.onResume()
        mListRecyclerView!!.adapter = AdpterForrecs(list!!)
        crice(pie)


    }
    fun crice(a:Pie) {

        val data: MutableList<DataEntry> = ArrayList()
        for (y in Digramme.rechnen(list!!)){
            data.add(ValueDataEntry(y.name, y.bereic))
            Log.i("bere", "crice: "+y.bereic)
        }
        a.setData(data)
        val anyChartView = findViewById<View>(R.id.any_chart_view) as AnyChartView
       anyChartView.setChart(a)

    }

}