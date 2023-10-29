package com.example.alertdialoglistitem

import android.content.DialogInterface
import android.content.DialogInterface.OnMultiChoiceClickListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.alertdialoglistitem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var checkedItemPosition = 0
    private val checkedList = BooleanArray(3) //3 ta item

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn.setOnClickListener {
            //arraydan malumot beramiz
            val list = arrayOf<String>("First","Second","Third")
            val dialog = AlertDialog.Builder(this)
                .setTitle("Choose")
                .setCancelable(false) //bunda faqat ok, yoki cancel btn orqali dismiss boladi

                    //BooleanArray / checkedlist(0) -> hech qaysi checked bolmagan
                .setMultiChoiceItems(list, checkedList
                ) { dialog, which, isChecked -> checkedList[which] = isChecked }
                .setPositiveButton("ok"){_,_ ->}  //boganimizda dismiss boladi
                .setNegativeButton("cancel"){_,_ ->}  //bu xam
                .create()

            dialog.show()
        }
    }
}