package com.example.android_please.adapters

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast
import com.example.android_please.ToDoItem

val DATABASE_NAME = "TodoDB"
val TABLE_NAME = "Todos"
val COL_DATE = "date"
val COL_TODO = "todo"
val COL_ID = "id"
val COL_FIN = "fin"

class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +" (" +
                COL_ID +" INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_DATE + " TEXT," +
                COL_TODO + " TEXT," +
                COL_FIN + " INTEGER);"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(todoItem: ToDoItem){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_DATE, todoItem.date)
        cv.put(COL_TODO, todoItem.todo)
        cv.put(COL_FIN, todoItem.finished)
        var result = db.insert(TABLE_NAME, null, cv)
        if(result == -1.toLong()) {
            Toast.makeText(context, "FAILED", Toast.LENGTH_LONG).show()
            System.out.println("Failed")
        }
        else {
            Toast.makeText(context, "INSERTED", Toast.LENGTH_LONG).show()
            System.out.println("Inserted")
        }
    }

    fun dateList(): ArrayList<ArrayList<Any>> {
        var dateCountArray = arrayListOf<ArrayList<Any>>()
        val db = this.writableDatabase
        var query = "SELECT ${COL_DATE}, COUNT(${COL_DATE}) FROM ${TABLE_NAME} GROUP BY ${COL_DATE} ORDER BY ${
            COL_ID};"
        var c = db.rawQuery(query, null)
        while(c.moveToNext()){
            dateCountArray.add(arrayListOf(c.getString(c.getColumnIndex(COL_DATE)), c.getInt(c.getColumnIndex("COUNT(${COL_DATE})"))))
        }
        return dateCountArray
    }

    fun todoList(date: String?): ArrayList<ArrayList<Any>> {
        var date = date

        var dateTodos = arrayListOf<ArrayList<Any>>()
        val db = this.writableDatabase
        var query = "SELECT * FROM ${TABLE_NAME} WHERE ${COL_DATE} LIKE '%${date}%';"
        var c = db.rawQuery(query, null)
        while(c.moveToNext()){
            dateTodos.add(arrayListOf(c.getString(c.getColumnIndex(COL_TODO)), c.getInt(c.getColumnIndex(
                COL_FIN)), c.getInt(c.getColumnIndex(COL_ID))))
        }
        return dateTodos
    }

    fun getFinCount(date: String?): Int {
        var count:Int = 0
        var date = date
        val db = this.writableDatabase
        var query = "SELECT * FROM ${TABLE_NAME} WHERE ${COL_DATE} LIKE '%${date}%' AND ${
            COL_FIN} = 1;"
        var c = db.rawQuery(query, null)
        while(c.moveToNext()){
            count++
        }
        return count
    }

    fun changeChecked(id:Int, checked: Int){
        var id = id
        var checked = checked
        val db = this.writableDatabase
        var query ="UPDATE ${TABLE_NAME} SET ${COL_FIN} = ${checked} WHERE ${COL_ID} = ${id};"
        var c = db.rawQuery(query, null)
        while(c.moveToNext());
        return
    }

    fun deleteDate(date:String){
        var date = date
        val db = this.writableDatabase
        var query = "DELETE FROM ${TABLE_NAME} WHERE ${COL_DATE} LIKE '%${date}%';"
        var c = db.rawQuery(query, null)
        while(c.moveToNext());
        return
    }
}