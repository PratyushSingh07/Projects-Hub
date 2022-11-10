package com.example.projectshub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class DashboardActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash)
        supportActionBar?.hide()
        val btn =findViewById<BottomNavigationView>(R.id.bottomNavView)
        btn.background=null
        btn.menu.getItem(2).isEnabled=false

        val homeFragment=HomeFragment()
        val searchFragment=SearchFragment()
        val bookmarkFragment=BookmarkFragment()
        val settingsFragment=SettingsFragment()

        setCurrentFragment(homeFragment)//default fragment when the screen loads

        btn.setOnItemSelectedListener{
            when(it.itemId){
                R.id.home->setCurrentFragment(homeFragment)
                R.id.searchBar->setCurrentFragment(searchFragment)
                R.id.Bookmark->setCurrentFragment(bookmarkFragment)
                R.id.settings->setCurrentFragment(settingsFragment)
            }
            false
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}