package com.example.android_please

class ToDoItem {
    var id:Int = 0
    var date:String = ""
    var todo:String = ""
    var finished:Boolean = false

    constructor(date:String, todo:String, finished:Boolean){
        this.date = date
        this.todo = todo
        this.finished = finished
    }
}