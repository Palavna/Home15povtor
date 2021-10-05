package com.example.yana.home15

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.yana.home15.databinding.ItemNotesBinding
//
//class NotesAdapter(private val listener: NotesAdapterListeners) :
//    RecyclerView.Adapter<NotesViewHolder>() {
//
//    private val list = arrayListOf<NotesModel>()
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
//        val binding = ItemNotesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        return NotesViewHolder(binding, listener)
//    }
//
//    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
//        holder.bind(list[position])
//    }
//
//    override fun getItemCount() = list.size
//
//    fun add(user: NotesModel) {
//        list.add(user)
//        notifyDataSetChanged()
//    }
//
//    fun addAll(user: List<NotesModel>?) {
//        if (user != null) {
//            list.clear()
//            list.addAll(user)
//            notifyDataSetChanged()
//        }
//    }
//
//    fun deleteAll() {
//        list.clear()
//        notifyDataSetChanged()
//    }
//
//    fun addNewItem(zagolovok: String?, kontent: String?, data: String?) {
//        val item = NotesModel(title = zagolovok, content = kontent, dataTv = data)
//        list.add(item)
//        notifyDataSetChanged()
//    }
//
//    fun deleteItem(position: Int) {
//        notifyItemRemoved(position)
//        list.removeAt(position)
//    }
//}
//
//interface NotesAdapterListeners {
//    fun deleteItem(position: Int)
//}
//
