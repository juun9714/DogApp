package com.example.dog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.example.dog.databinding.ActivityListBinding
import com.google.android.material.navigation.NavigationView

class List : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityListBinding
    var centerList = arrayListOf<center>(
        //val name:String, val profile:Int, val owner:String, val location:String, val sns: String
        center("보호소1",R.drawable.center,"소장님1","경기도 성남시","@gone_june"),
        center("보호소2",R.drawable.center,"소장님2","경기도 용인시","@allcurvesandedges"),
        center("보호소3",R.drawable.center,"소장님3","경기도 수원시","@youumppa"),
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nvBtnList.setOnClickListener {
            binding.drawList.openDrawer(GravityCompat.START)
        }
        binding.nvMenuList.setNavigationItemSelectedListener(this)

        val adapter=ListAdapter(this,centerList)
        binding.listView.adapter=adapter
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.home)
            startActivity(Intent(this,MainActivity::class.java))
        else if(item.itemId==R.id.story)
            startActivity(Intent(this,story::class.java))
        else if(item.itemId==R.id.contact)
            startActivity(Intent(this,Contact::class.java))
        binding.drawList.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.drawList.isDrawerOpen(GravityCompat.START))
            binding.drawList.closeDrawers()
        else
            super.onBackPressed()
    }
}