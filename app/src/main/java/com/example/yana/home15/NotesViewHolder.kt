package com.example.yana.home15

import android.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.yana.home15.databinding.ItemNotesBinding

class NotesViewHolder(private val binding: ItemNotesBinding, private val listener: UserListener):
    RecyclerView.ViewHolder(binding.root) {

    init {
    }
    fun bind(notesModel: NotesModel) {
        binding.title.text = notesModel.title
        binding.content.text = notesModel.content
        binding.dataTv.text = notesModel.dataTv

        binding.edit.setOnClickListener{
            listener.update(notesModel)}

        binding.root.setOnClickListener{
            listener.openDetails(notesModel)
        }

        binding.korzina.setOnClickListener {
            AlertDialog.Builder(itemView.context)
                .setTitle("Вы уверены что хотите удалить запись?")
                .setPositiveButton("да") { _, _ -> listener.deleteItem(notesModel) }
                .setNegativeButton("нет") { _, _ -> }
                .show()


        }


    }
}