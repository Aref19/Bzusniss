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

        fun priceColluction(price: String, newprice: String, con: Context,e:EditText,e1:EditText,e2:EditText): Boolean {
            var usernotic: Boolean = true
            if (newprice.toInt() < price.toInt()) {
                var alert = AlertDialog.Builder(con)
                alert.setTitle("Worrong")
                alert.setMessage("the price should be changed  press No to skip or Yes to reject")
                alert.setPositiveButton("yes") { dialog, which ->
                    var k=Kasse()
                    k.userbescheid(false,con,e,e1,e2)
                }
                alert.setNegativeButton("No") { dialog, which ->
                    Toast.makeText(con, "It well countinu", Toast.LENGTH_SHORT).show()
                    var k=Kasse()
                    k.userbescheid(true,con,e,e1,e2)

                }
                alert.show()
            }
            return usernotic
        }

    }

}