package com.example.mobileapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mobileapp.fragments.CourseFragment
import com.example.mobileapp.fragments.GradesFragment
import com.example.mobileapp.fragments.PlanFragment
import com.example.mobileapp.fragments.PlusFragment
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gradesFragment = GradesFragment()
        val plusFragment = PlusFragment()
        val planFragment = PlanFragment()
        val courseFragment = CourseFragment()

        makeCurrentFragment(gradesFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.ic_oceny -> makeCurrentFragment(gradesFragment)
                R.id.ic_plan -> makeCurrentFragment(planFragment)
                R.id.ic_plus -> makeCurrentFragment(plusFragment)
                R.id.ic_przedmioty -> makeCurrentFragment(courseFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
    }
}