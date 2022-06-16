package com.ltbth.datepickerdialog

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val c = Calendar.getInstance()
        var prevDay = c.get(Calendar.DAY_OF_MONTH)
        var prevMonth = c.get(Calendar.MONTH)
        var prevYear = c.get(Calendar.YEAR)


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editText: EditText = findViewById(R.id.et_date)
        val button: Button = findViewById(R.id.btn)


        var datePickerDialog = DatePickerDialog(this)
        datePickerDialog.updateDate(prevYear,prevMonth,prevDay)
        datePickerDialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            editText.setText("$dayOfMonth/${month + 1}/$year")
            prevDay = dayOfMonth
            prevMonth = month
            prevYear = year
        }

        button.setOnClickListener {
            datePickerDialog.show()
        }
    }
}