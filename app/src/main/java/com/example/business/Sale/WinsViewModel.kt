package com.example.business.Sale

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.business.DatenBank.AppDataBase
import com.example.business.DatenBank.GoodsInterface
import com.example.business.DatenBank.SaveGoodsDB
import java.lang.invoke.CallSite

//  1-die aufgabe sache from data base 2-mitteilen dass er sache from database hat
class WinsViewModel : ViewModel() {
    var multi:MutableLiveData<List<SaveGoodsDB.SaledGoods>>?=MutableLiveData()
   // Methode holt sache from datatbase
    private fun saledSache(c : Context):List< SaveGoodsDB.SaledGoods >{
      return  getInstanceFromDataBane(c).getAllSaled()
   }
    fun getsaled(c : Context){

              multi!!.value=saledSache(c)


    }
   private fun getInstanceFromDataBane(c : Context): GoodsInterface {
        return AppDataBase.getDateBase(c!!).goodssachDao()
    }





}