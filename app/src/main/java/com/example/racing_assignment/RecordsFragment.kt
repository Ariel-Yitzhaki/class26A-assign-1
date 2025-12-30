package com.example.racing_assignment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.core.content.edit

class RecordsFragment : Fragment() {

    val recordIds = listOf(
        R.id.record1, R.id.record2, R.id.record3, R.id.record4, R.id.record5,
        R.id.record6, R.id.record7, R.id.record8, R.id.record9, R.id.record10
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_records, container, false)

        val prefs = requireContext().getSharedPreferences("records", Context.MODE_PRIVATE)

        recordIds.forEachIndexed { index, id ->
            val score = prefs.getInt("record${index + 1}", 0)
            view.findViewById<TextView>(id).setOnClickListener {
                // TODO: handle record click
            }
        }

        view.findViewById<ImageButton>(R.id.return_menu).setOnClickListener {
            parentFragmentManager.popBackStack()
        }

        return view
    }
    fun saveScore(position: Int, score: Int) {
        val prefs = requireContext().getSharedPreferences("records", Context.MODE_PRIVATE)
        prefs.edit { putInt("record$position", score) }
    }
}