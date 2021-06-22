package com.juanleodev.marvelheroes.presentation.herodetail.fragment.description

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.juanleodev.marvelheroes.R
import com.juanleodev.marvelheroes.databinding.FragmentDescriptionBinding

class DescriptionFragment(
    private val description: String?
) : Fragment(R.layout.fragment_description) {

    private var binding: FragmentDescriptionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDescriptionBinding.bind(view)

        binding?.tvHeroDescription?.text = checkDescriptionContent(description)
    }

    private fun checkDescriptionContent(content: String?): String {
        return if (content.isNullOrEmpty()) {
            getString(R.string.no_description)
        } else content
    }

}