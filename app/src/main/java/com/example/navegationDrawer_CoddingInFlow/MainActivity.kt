package com.example.navegationDrawer_CoddingInFlow

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_message -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container, MessageFragment()
                ).commit()
            }
            R.id.nav_chat -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container, ChatFragment()
                ).commit()
            }
            R.id.nav_profile -> {
                supportFragmentManager.beginTransaction().replace(
                    R.id.fragment_container, ProfileFragment()
                ).commit()
            }
            R.id.nav_share -> {
                Toast.makeText(this, "Its Share area", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_send -> {
                Toast.makeText(this, "Its Send area", Toast.LENGTH_SHORT).show()
            }
        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


    lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = drawer_layout

        setSupportActionBar(toolbar)

        nav_view.setNavigationItemSelectedListener(this)

        val toggle = ActionBarDrawerToggle(
            this, drawer, toolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container, MessageFragment()
            ).commit()
            nav_view.setCheckedItem(R.id.nav_message)
        }

    }

    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
