package com.example.datepickerdialog

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.datepickerdialog.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.showDatePickerBtn.setOnClickListener {

            val calendar = Calendar.getInstance() //bu bugungi kunni olib beradi // 1
            val datePickerDialog = DatePickerDialog(
                this,
                0,
                DatePickerDialog.OnDateSetListener { _, year, month, dayOfMonth ->

                    //biz tanlaganlarni olish
                    binding.selectDateTv.text = "$dayOfMonth/${month+1}/$year"
                },
                calendar.get(Calendar.YEAR),// buyerdagilar default bolgan sanalar  // 2
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
            )
            //malum bir kunlargina calendardan olish kere bolganda
            //yani oyni 10 kunigacha bolsa
            calendar.set(Calendar.DAY_OF_MONTH,10)
            datePickerDialog.datePicker.maxDate = calendar.timeInMillis

            datePickerDialog.show()  //datePickerni korsatish

            //btnlarni ozgartirish showdan keyin quyish kere
            datePickerDialog.getButton(DatePickerDialog.BUTTON_POSITIVE).text = "Tanla"

        }
    }
}