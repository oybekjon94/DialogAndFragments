package com.example.timepickerdialog

import android.app.TimePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.timepickerdialog.databinding.ActivityMainBinding
import java.sql.Time

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var selectedHour = 0  // 1
    private var selectedMinute = 0

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val calendar = Calendar.getInstance()  //2
        selectedHour = calendar.get(Calendar.HOUR)
        selectedMinute = calendar.get(Calendar.MINUTE)

        binding.showTimePickerBtn.setOnClickListener {

            val timePickerDialog = TimePickerDialog(
                this,
                TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                    //ozimiz tanlab olsak
                    selectedHour = hourOfDay
                    selectedMinute = minute
                    binding.tv.text = "$selectedHour : $selectedMinute"
                },
                selectedHour,  // 3 -> default
                selectedMinute,
                true
            )
            timePickerDialog.show()
        }
    }
}