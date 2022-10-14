package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import java.io.InputStream

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layoutlist = findViewById<RecyclerView>(R.id.listmedal)
        setContentView(R.layout.activity_main)
        val datastream: InputStream = resources.openRawResource(R.raw.medallists)
        val reader = datastream.bufferedReader()
        reader.readLine()
        var line = reader.readLine()
        while (line!=null){
            val coll:List<String> = line.split(",")
            val itemlist = Medallist(coll[0],
            coll[1],
            coll[2].toInt(),
            coll[3].toInt(),
            coll[4].toInt(),
            coll[5].toInt())

        }

    }
}
data class Medallist(
    var name:String = "",
    var ioc:String = "",
    var times:Int = 0,
    var gold:Int = 0,
    var silver:Int = 0,
    var bronze:Int =0
){
    fun totalmed():Int{
        return this.gold+this.silver+this.bronze
    }
}
data class Total(
    var ioc:String="",
    var total:Int=0
)