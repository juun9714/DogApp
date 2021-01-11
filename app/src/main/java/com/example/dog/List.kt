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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nvBtnList.setOnClickListener {
            binding.drawList.openDrawer(GravityCompat.START)
        }
        binding.nvMenuList.setNavigationItemSelectedListener(this)
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