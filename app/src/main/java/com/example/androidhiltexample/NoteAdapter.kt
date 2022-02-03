package com.example.androidhiltexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NoteAdapter(private var notes: List<Note>) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {

    class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(note: Note) {
            val tv_note_title = itemView.findViewById(R.id.tv_note_title) as TextView
            val tv_note_details = itemView.findViewById(R.id.tv_note_details) as TextView
            val tv_time = itemView.findViewById(R.id.tv_time) as TextView
            tv_note_title.text = note.title
            tv_note_details.text = note.details
            tv_time.text = note.time
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bindItems(notes[position])
    }

    fun setNotes(notes: List<Note>) {
        this.notes = notes
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return notes.size;
    }
}