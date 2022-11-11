package com.example.projectshub

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
                R.id.settings-> {
                    supportFragmentManager.beginTransaction().apply {
                        setCustomAnimations(R.anim.slide_to_top,R.anim.slide_to_top)
                        replace(R.id.flFragment,settingsFragment)
                        commit()
                    }
                }
            }
            true // ye likhne se icon change hote hue dikega but false likhne se frag change hoga but icon nhi
        }
        val addProj=findViewById<FloatingActionButton>(R.id.fab)
        addProj.setOnClickListener{
            findViewById<BottomAppBar>(R.id.bottomAppBar).visibility= View.GONE
            addProj.visibility=View.GONE
            supportFragmentManager.beginTransaction().apply {
                setCustomAnimations(R.anim.slide_to_top,R.anim.slide_to_top)
                replace(R.id.flFragment,AddProjectFragment())
                commit()
            }
        }
    }
    private fun setCurrentFragment(fragment: Fragment)=
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment,fragment)
            commit()
        }
}