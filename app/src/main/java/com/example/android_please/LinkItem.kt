package com.example.android_please

class LinkItem {
    var id: Int = 0
    var date:String? = ""
    var link:String = ""
    constructor(date:String?, link:String){
        this.date = date
        this.link = link
    }
}