package com.example.business.Adpters

import android.util.Log
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.business.DatenBank.SaveGoodsDB
import com.example.business.R


class AdpterForrecs(private val dataSet: List<SaveGoodsDB.SaledGoods>) :RecyclerView.Adapter<AdpterForrecs.ViewHolder>() {

    var lsit=dataSet

    class ViewHolder(view:View): RecyclerView.ViewHolder(view) {
        var date:TextView=view.findViewById(R.id.dateofsaled)
        var name:TextView=view.findViewById(R.id.nameofsaled)
        var acount:TextView=view.findViewById(R.id.acountofsaled)
        var prise:TextView=view.findViewById(R.id.priseOfsaled)




    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return  ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.saled_adpter,parent,false))



    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text=lsit.get(position).date
        holder.name.text=lsit.get(position).name
        Log.i("bitte", "onBindViewHolder: "+lsit.get(position).name)
        holder.acount.text=lsit.get(position).count
        holder.prise.text=lsit.get(position).pice



    }

    override fun getItemCount(): Int {
        return lsit.size
    }


}