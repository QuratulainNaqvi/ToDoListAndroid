package com.pakitech.todolistandroid.ui.theme

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pakitech.todolistandroid.R

class MainFragment : Fragment() {

    @Deprecated("Deprecated in Java",
        ReplaceWith("super.onCreate(savedInstanceState)", "android.app.Fragment")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}