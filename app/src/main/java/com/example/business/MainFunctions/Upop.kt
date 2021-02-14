package com.example.business.MainFunctions

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.DialogFragment
import com.example.business.DatenBank.AppDataBase
import com.example.business.R


class Upop : DialogFragment,View.OnClickListener {
    var name:String?=null
    var price:String?=null
    var count:String?=null
    var e1:EditText?=null
    var e2:EditText?=null
    var e3:EditText?=null
    var update:ImageButton?=null

   constructor(name:String,pric:String,count:String){
       this.name=name
       this.price=pric
       this.count=count
   }
    var v: View? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.upopview, container, false)
        e1=v!!.findViewById(R.id.nameofgoodp)
        e2=v!!.findViewById(R.id.pricofgoodp)
        e3=v!!.findViewById(R.id.acountofgoodp)
        Log.i("check1", "onCreateView: "+name+price+count)
          e1!!.setText(name)
          e2!!.setText(price)
          e3!!.setText(count)
          update=v!!.findViewById(R.id.updatep)
        update!!.setOnClickListener(this)

        return v


    }

    override fun onClick(p0: View?) {
        var dp = AppDataBase.getDateBase(v!!.context).goodssachDao()
        dp.updatecomp(e3!!.text.toString(),e1!!.text.toString(),e2!!.text.toString(),name!!)
        this.dismiss()

    }
}