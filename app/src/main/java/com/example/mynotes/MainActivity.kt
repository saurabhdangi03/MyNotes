package com.example.mynotes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mynotes.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var db : NotesDatabaseHelper
    private lateinit var notesAdapter: NotesAdapter
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.signOutBtn).setOnClickListener {
            auth.signOut()
            startActivity(Intent(this , LoginWithGoogle::class.java))
        }


        db = NotesDatabaseHelper(this)
        notesAdapter = NotesAdapter(db.getAllNotes(),this)

        binding.notesRecyclerView.layoutManager =LinearLayoutManager(this)
        binding.notesRecyclerView.adapter = notesAdapter

        binding.addButton.setOnClickListener {
          /*  val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.MainView, AddNoteFragment())
            fragmentTransaction.addToBackStack(null)  // Optional, to add the transaction to the back stack
            fragmentTransaction.commit()*/
            val intent = Intent(this,AddNoteActivity::class.java) // commnet this line
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.e("refreshData",db.getAllNotes().size.toString())
        Log.e("refreshData",db.getAllNotes().toString())
        notesAdapter.refreshData(db.getAllNotes())

    }
}