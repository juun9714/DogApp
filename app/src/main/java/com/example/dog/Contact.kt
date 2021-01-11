package com.example.dog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import com.example.dog.databinding.ActivityContactBinding
import com.google.android.material.navigation.NavigationView
import kotlin.collections.List

class Contact : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityContactBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityContactBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.nvBtnContact.setOnClickListener {
            binding.drawContact.openDrawer(GravityCompat.START)
        }
        binding.nvMenuContact.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.home)
            startActivity(Intent(this,MainActivity::class.java))
        else if(item.itemId==R.id.list)
            startActivity(Intent(this, List::class.java))
        else if(item.itemId==R.id.story)
            startActivity(Intent(this,story::class.java))
        binding.drawContact.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.drawContact.isDrawerOpen(GravityCompat.START))
            binding.drawContact.closeDrawers()
        else
            super.onBackPressed()
    }
}