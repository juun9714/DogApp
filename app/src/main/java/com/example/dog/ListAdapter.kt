package com.example.dog

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class ListAdapter (val context :Context, val array:ArrayList<center>):BaseAdapter(){
    override fun getCount(): Int {
        return array.size
    }

    override fun getItem(position: Int): Any {
        return array[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view : View = LayoutInflater.from(context).inflate(R.layout.center_list,null)
        var profile = view.findViewById<ImageView>(R.id.iv_profile)
        var name = view.findViewById<TextView>(R.id.tv_name)
        var owner = view.findViewById<TextView>(R.id.tv_owner)
        var location = view.findViewById<TextView>(R.id.tv_location)
        var sns = view.findViewById<TextView>(R.id.tv_sns)

        var center=array[position]

        profile.setImageResource(center.profile)
        name.text=center.name
        owner.text=center.owner
        location.text=center.location
        sns.text=center.sns

        return view
    }

}