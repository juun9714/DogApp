package com.example.dog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.example.dog.databinding.ActivityMainBinding
import com.example.dog.databinding.ActivityStoryBinding
import com.google.android.material.navigation.NavigationView

class story : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityStoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.nvBtnStory.setOnClickListener {
            binding.drawStory.openDrawer(GravityCompat.START)
        }
        binding.nvMenuStory.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.home)
            startActivity(Intent(this,MainActivity::class.java))
        else if(item.itemId==R.id.list)
            startActivity(Intent(this,List::class.java))
        else if(item.itemId==R.id.contact)
            startActivity(Intent(this,Contact::class.java))
        binding.drawStory.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.drawStory.isDrawerOpen(GravityCompat.START))
            binding.drawStory.closeDrawers()
        else
            super.onBackPressed()
    }


}