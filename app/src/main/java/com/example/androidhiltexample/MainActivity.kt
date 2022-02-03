package com.example.androidhiltexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var testString: String

    private lateinit var rcv_notes: RecyclerView
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val notes = ArrayList<Note>()

        for (i in 1..60){
            notes.add(Note("Note title $i", "This is note details $i. This is note details $i. This is note details. This is note details. $i", "12-12-2022 12.12.12 PM"))
        }
        adapter = NoteAdapter(notes)
        rcv_notes = findViewById(R.id.rcv_notes)
        rcv_notes.layoutManager = LinearLayoutManager(this)
        rcv_notes.adapter = adapter

        findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener{
            startActivity(Intent(this, AddEditNoteActivity::class.java))
        }

    }
}