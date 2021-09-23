package com.example.yana.home15

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter(private val listener: NotesAdapterListeners): RecyclerView.Adapter<NotesViewHolder>(){

    private val list = arrayListOf<NotesModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_notes,parent,false)
        return NotesViewHolder(view, listener)
    }
    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        holder.bind(list[position], position)
    }
    override fun getItemCount(): Int {
        return list.size
    }
    fun add(user: NotesModel) {
        list.add(user)
        notifyDataSetChanged()
    }

    fun addAll(user: List<NotesModel>?) {
        if (user!= null){
            list.clear()
        list.addAll(user)
        notifyDataSetChanged()}
    }

    fun deleteAll() {
        list.clear()
        notifyDataSetChanged()
    }

    fun addNewItem(zagolovok: String?, kontent: String?, data: String?){
        val item = NotesModel(title = zagolovok, content = kontent, dataTv = data)
        list.add(item)
        notifyDataSetChanged()
    }
    fun deleteItem(position: Int) {
        notifyItemRemoved(position)
        list.removeAt(position)
    }
}
class NotesViewHolder(view: View, private val listener: NotesAdapterListeners): RecyclerView.ViewHolder(view){

    private val title = itemView.findViewById<TextView>(R.id.title)
    private val content = itemView.findViewById<TextView>(R.id.content)
    private val dataTv = itemView.findViewById<TextView>(R.id.dataTv)
    private val korzina = itemView.findViewById<ImageView>(R.id.korzina)

    fun bind(notesModel: NotesModel, position: Int) {
        title.text = notesModel.title
        content.text = notesModel.content
        dataTv.text = notesModel.dataTv
        korzina.setOnClickListener{
            AlertDialog.Builder(itemView.context)
                .setTitle("Вы уверены что хотите удалить запись?")
                .setPositiveButton("да") { _, _ -> listener.deleteItem(position)}
                .setNegativeButton("нет"){ _, _ -> }
                .show()
        }
    }
}
interface NotesAdapterListeners {
    fun deleteItem(position: Int)
}

