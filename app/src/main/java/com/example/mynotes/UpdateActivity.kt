package com.example.mynotes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mynotes.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding : ActivityUpdateBinding
    private lateinit var db : NotesDatabaseHelper
    private var noteId: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)


   db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id",-1)
        println("Shshsbjkjd $noteId")
          if(noteId == -1)
     {
         finish()
         return
     }

     val note = db.getNoteByID(noteId)
        println("Shshsbjkjqvfsdd $note")

         binding.updateTitleEditText.setText(note.title)
         binding.updateContentEditText.setText(note.content)

          binding.updateSaveButton.setOnClickListener {
              val newTitle = binding.updateTitleEditText.text.toString()
              val newContent = binding.updateContentEditText.text.toString()

              val updatedNote = Note(noteId,newTitle,newContent)
              db.updateNote(updatedNote)
              finish()
              Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
          }

    }
}