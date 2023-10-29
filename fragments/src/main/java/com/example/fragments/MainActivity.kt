package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragments.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.firstFragment.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.containerView,FirstFragment())  //orniga joylash
                    .addToBackStack(null) //steckga saqlaydi
                    .commit()  //bajar
            }
        }
        binding.secondFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerView,SecondFragment())
                .addToBackStack(null)
                .commit()
        }

    }
}