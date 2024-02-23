package com.example.mynotes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mynotes.databinding.ActivityAddNoteBinding
import com.example.mynotes.databinding.FragmentAddnoteBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/*class AddNoteFragment : Fragment() {
    private lateinit var binding : FragmentAddnoteBinding
    private lateinit var db : NotesDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_first, container, false)

        binding = FragmentAddnoteBinding.inflate(inflater, container, false)
       // setContentView(binding.root)

        if (container != null) {
            db = NotesDatabaseHelper(binding.root.context)
        }

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            activity?.finish()
            Toast.makeText(context,"Note Saved", Toast.LENGTH_SHORT).show()
        }
        return binding.root
    }
}*/

/*class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddnoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: NotesDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddnoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        db = NotesDatabaseHelper(requireContext())

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            Toast.makeText(requireContext(), "Note Saved", Toast.LENGTH_SHORT).show()
            // Assuming you want to navigate back to previous fragment or activity
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/

class AddNoteFragment : Fragment() {

    private var _binding: FragmentAddnoteBinding? = null
    private val binding get() = _binding!!
    private lateinit var db: NotesDatabaseHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddnoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = NotesDatabaseHelper(requireContext())

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0, title, content)
            db.insertNote(note)
            Toast.makeText(requireContext(), "Note Saved", Toast.LENGTH_SHORT).show()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}