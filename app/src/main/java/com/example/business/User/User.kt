package com.example.business.User

class User {

    private var name: String? = null
    private var pass: String? = null
    private var busniss:String?=null

    constructor(name: String, pass: String,b:String?) {
        this.name = name
        this.pass = pass
        this.busniss=b
    }
    constructor(){

    }


    fun setname(naem: String) {
       this. name =naem
    }
    fun getname(): String? {
        return name;
    }

    fun setbus(naem: String) {
       this. busniss =naem
    }
    fun getbus(): String? {
        return busniss;
    }
    fun setpass(pass: String) {
    this.pass =pass
    }
    fun getpass(): String? {
        return pass;
    }

}