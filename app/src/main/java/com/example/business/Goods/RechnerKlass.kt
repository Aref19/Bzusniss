package com.example.business.Goods

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import com.example.business.DatenBank.AppDataBase
import com.example.business.MainFunctions.Kasse

class RechnerKlass {
    companion object {
        fun newCount(oldcount: String, saleCount: String): String {
            Log.i("counter", "newCount: " + oldcount + saleCount)
            var newcount = oldcount.toInt() - saleCount.toInt()
            return newcount.toString()
        }


    }

}