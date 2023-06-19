package com.sample.characterviewer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.sample.characterviewer.R
import com.sample.characterviewer.databinding.FragmentCharacterDetailsBinding
import com.sample.characterviewer.model.RelatedTopicModel


class CharacterDetailsFragment : Fragment(){

    private var _binding: FragmentCharacterDetailsBinding? = null
    private val viewModel by viewModels<CharacterViewModel>()
    private val binding get() = _binding!!
    private var details:RelatedTopicModel?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)

        val characterItem = arguments?.getSerializable("CharacterItem") as RelatedTopicModel

        setupUI(characterItem)
        return binding.root

    }

    fun setupUI(details: RelatedTopicModel){
        val view=binding.root
        view?.let {
            Glide.with(it).load("https://duckduckgo.com"+details?.icon?.uRL).placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.characterIcon)
        }
        binding.characterTitle.text= details?.text?.split(" - ")?.get(0) !!
        binding.characterDescription.text= details?.text?.split(" - ")?.get(1) !!
    }
}