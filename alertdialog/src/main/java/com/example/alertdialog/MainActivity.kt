package com.example.alertdialog

import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDialog.setOnClickListener {
            val dialog = AlertDialog.Builder(this)
                .setTitle("Exit")
                .setIcon(com.google.android.material.R.drawable.ic_clock_black_24dp)
                .setMessage("Ilovadan chiqishni xoxlaysizmi")
                .setPositiveButton("OK",object :DialogInterface.OnClickListener{ //setPositiveni sezadigan objecti bor
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        //appdan chiqib ketish
                        finish()
                    }
                })
                .setNegativeButton("Cancel",object:DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity,"Cancel button clicked",Toast.LENGTH_SHORT).show()
                    }
                })
                .create() //shu dialogni yasa

            dialog.show() //userga korsat
        }
    }
}