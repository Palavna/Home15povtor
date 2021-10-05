package com.example.yana.home15

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.widget.DatePicker
import com.example.yana.home15.databinding.ActivitySecondBinding
import java.text.SimpleDateFormat
import java.util.*
import com.example.yana.home15.NotesModel as NotesModel1

class SecondActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private var userEdited: NotesModel1? = null

    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupListeners()
//        update()
    }

//    private fun update(user: NotesModel1) {
//        binding.zagolovok.setText(user.title)
//        binding.kontent.setText(user.content)
//        binding.data.setText(user.dataTv)
//        userEdited = NotesModel1(
//            id = user.id,
//            title = user.title,
//            content = user.content,
//            dataTv = user.dataTv
//        )
//    }

    private fun setupListeners() {
        binding.save.setOnClickListener {
            RoomApp.DB?.getUserDao()?.saveUser(
                NotesModel1(
                    title = binding.zagolovok.text.toString(),
                    content = binding.kontent.text.toString(),
                    dataTv = binding.data.text.toString()
                )
            )
            finish()
        }
        binding.btnUpdate.setOnClickListener{
            userEdited?.title = binding.zagolovok.text.toString()
            userEdited?.content = binding.kontent.text.toString()
            userEdited?.dataTv = binding.kontent.text.toString()
            RoomApp.DB?.getUserDao()?.update(userEdited)
        }

        binding.data.setOnClickListener {
            val calendar = Calendar.getInstance()
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val month = calendar.get(Calendar.MONTH)
            val year = calendar.get(Calendar.YEAR)
            DatePickerDialog(this, this, year, month, day).show()
            val data = "$day/${month + 1}/$year"
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
            val sdfNew = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
            val newData = sdf.parse(data)
            binding.data.text = sdfNew.format(newData)
        }
    }

    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {
        val data = "$day/${month + 1}/$year"
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
        val sdfNew = SimpleDateFormat("dd MMMM yyyy", Locale.getDefault())
        val newData = sdf.parse(data)
        binding.data.text = sdfNew.format(newData)
    }


    companion object {
        const val ZAGOLOVOK = "zagolovok"
        const val KONTENT = "kontent"
        const val DATA = "data"
        const val KORZINA = "korzina"
    }

}