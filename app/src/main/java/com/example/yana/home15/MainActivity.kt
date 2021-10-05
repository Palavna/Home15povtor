package com.example.yana.home15

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.example.yana.home15.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), UserListener {
    private lateinit var recView: RecyclerView
    private val adapter by lazy { DataListAdapter(this) }

    private var userEdited: NotesModel? = null

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val toolBar = findViewById<Toolbar>(R.id.toolbar)
        val list = RoomApp.DB?.getUserDao()?.getAllUsers()

        RoomApp.DB?.getUserDao()?.getAllUsersObserve()?.observe(this, {
            adapter.submitList(it)
        })

        fun setupListeners() {
            binding.delete.setOnClickListener {
                val list = RoomApp.DB?.getUserDao()?.getAllUsers()
                adapter.submitList(list)
            }
            binding.plus.setOnClickListener {
                val intent = Intent(this, SecondActivity::class.java)
                startActivity(intent)
            }
            binding.delete.setOnClickListener {
                AlertDialog.Builder(this)
                    .setTitle("Вы уверены что хотите удалить все записи?")
                    .setPositiveButton("да") { _, _ -> adapter.submitList(list) }
                    .setNegativeButton("нет") { _, _ -> }
                    .show()
            }
        }
        setupListeners()
        setSupportActionBar(toolBar)
        setupViews()
        setupRecycler()
    }

    private fun setupViews() {
        recView = findViewById(R.id.recView)
    }

    private fun setupRecycler() {
        binding.recView.adapter = adapter
    }

    override fun deleteItem(user: NotesModel) {
        RoomApp.DB?.getUserDao()?.deleteUser(user)
    }

    override fun update(user: NotesModel) {
//        binding.id.setText(user.id)
//        binding.title.setText(user.title)
//        binding.content.setText(user.content)
//        binding.dataTv.setText(user.dataTv)
//        userEdited = NotesModel(
//            id = user.id,
//            title = user.title,
//            content = user.content,
//            dataTv = user.dataTv
//        )
    }

    override fun openDetails(user: NotesModel) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.TV_ID, user.id)

        startActivity(intent)
    }

    companion object {
        const val ZAGOLOVOK = "zagolovok"
        const val KONTENT = "kontent"
        const val DATA = "data"
        const val KORZINA = "korzina"
    }
}