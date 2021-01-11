package com.example.dog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.core.view.GravityCompat
import com.example.dog.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        binding.nvBtn.setOnClickListener {
            binding.draw.openDrawer(GravityCompat.START)
        }
        binding.nvMenu.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if(item.itemId==R.id.story)
            startActivity(Intent(this,story::class.java))
        else if(item.itemId==R.id.list)
            startActivity(Intent(this,List::class.java))
        else if(item.itemId==R.id.contact)
            startActivity(Intent(this,Contact::class.java))
        binding.draw.closeDrawers()
        return false
    }

    override fun onBackPressed() {
        if(binding.draw.isDrawerOpen(GravityCompat.START))
            binding.draw.closeDrawers()
        else
            super.onBackPressed()
    }
}