package com.rizky92.latihanlistview

import androidx.appcompat.app.AppCompatActivity

import android.content.res.TypedArray
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    private var dataName: Array<String>? = null
    private var dataDesc: Array<String>? = null
    private var dataFoto: TypedArray? = null
    private var heroAdapter: HeroAdapter? = null
    private var heroes: ArrayList<Hero>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.list_view)
        heroAdapter = HeroAdapter(this)
        listView.adapter = heroAdapter

        prepare()
        addItem()

        listView.onItemClickListener = AdapterView.OnItemClickListener {
            adapterView, view, i, l -> Toast.makeText(this@MainActivity, heroes!![i].name, Toast.LENGTH_SHORT).show()
        }
    }

    private fun prepare() {
        dataName = resources.getStringArray(R.array.data_name)
        dataDesc = resources.getStringArray(R.array.data_description)
        dataFoto = resources.obtainTypedArray(R.array.data_photo)
    }

    private fun addItem() {
        heroes = ArrayList()

        for (i in dataName!!.indices) {
            val hero = Hero()

            hero.foto = dataFoto!!.getResourceId(i, -1)
            hero.name = dataName!![i]
            hero.desc = dataDesc!![i]

            heroes!!.add(hero)
        }
        heroAdapter!!.setHeroes(heroes)
    }
}
