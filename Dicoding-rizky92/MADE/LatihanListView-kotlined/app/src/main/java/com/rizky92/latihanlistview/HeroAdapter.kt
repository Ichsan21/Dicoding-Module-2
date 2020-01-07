package com.rizky92.latihanlistview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

import java.util.ArrayList

class HeroAdapter(private val context: Context) : BaseAdapter() {
    private var heroes = ArrayList<Hero>()

    fun setHeroes(heroes: ArrayList<Hero>) {
        this.heroes = heroes
    }

    override fun getCount(): Int {
        return heroes.size
    }

    override fun getItem(i: Int): Any {
        return heroes[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getView(i: Int, view: View, viewGroup: ViewGroup): View {
        var itemView: View? = view
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item, viewGroup, false)
        }
        val viewHolder = ViewHolder(itemView!!)

        val hero = getItem(i) as Hero
        viewHolder.bind(hero)

        return itemView
    }

    private inner class ViewHolder internal constructor(view: View) {
        private val tvName: TextView
        private val tvDesc: TextView
        private val imgFoto: ImageView

        init {
            tvName = view.findViewById(R.id.tv_name)
            tvDesc = view.findViewById(R.id.tv_desc)
            imgFoto = view.findViewById(R.id.img_foto)
        }

        internal fun bind(hero: Hero) {
            tvName.text = hero.name
            tvDesc.text = hero.desc
            imgFoto.setImageResource(hero.foto)
        }
    }
}
