package com.example.yana.home15

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.yana.home15.databinding.ItemNotesBinding

class DataListAdapter(private val listener: UserListener): ListAdapter<NotesModel, NotesViewHolder>(USER_COMPARATOR) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val binding = ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NotesViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
    companion object{
        private val USER_COMPARATOR = object : DiffUtil.ItemCallback<NotesModel>(){
            override fun areItemsTheSame(oldItem: NotesModel, newItem: NotesModel): Boolean {
               return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: NotesModel, newItem: NotesModel): Boolean {
                return oldItem.id == newItem.id &&
                        oldItem.title == newItem.title &&
                        oldItem.content == newItem.content &&
                        oldItem.dataTv == newItem.dataTv
            }

        }
    }
}