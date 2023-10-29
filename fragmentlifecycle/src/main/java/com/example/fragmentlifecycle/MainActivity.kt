package com.example.fragmentlifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.os.bundleOf
import com.example.fragmentlifecycle.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(),FirstFragmentInterface {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val firstFragment =FirstFragment().apply {
            //fragmentdan fragmentga Bundle orqali yuboriladi
            arguments = Bundle().apply {
                putString("key","Assalomu aleykum")
            }
        }
        val secondFragment =SecondFragment().apply {
            arguments = Bundle().apply {
                putString("key","Va aleykum Assalom")
            }
        }



        binding.firstFragment.setOnClickListener {
            supportFragmentManager.apply {
                beginTransaction().replace(R.id.containerView,firstFragment)  //orniga joylash
                    .addToBackStack(null) //steckga saqlaydi
                    .commit()  //bajar
            }
        }
        binding.secondFragment.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.containerView,secondFragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onClickBtn(text: String) {
        val secondFragment = SecondFragment().apply {
            arguments =Bundle().apply {
                putString("key",text)
            }
        }
        supportFragmentManager.beginTransaction()
            .replace(R.id.containerView,secondFragment)
            .addToBackStack(null)
            .commit()
    }
}