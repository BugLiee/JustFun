package com.bugli.justfun.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bugli.justfun.R
import kotlinx.android.synthetic.main.fragment_bookshelf.view.*

class BookShelfFragment : Fragment(R.layout.fragment_bookshelf) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookshelf, null, false)
        view.f_bookshelf.setOnClickListener { findNavController().navigate(R.id.settingsFragment) }
        return view
    }
}