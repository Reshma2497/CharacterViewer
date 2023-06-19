package com.sample.characterviewer.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sample.characterviewer.R
import com.sample.characterviewer.databinding.FragmentCharacterBinding
import com.sample.characterviewer.model.CharacterViewerModel
import com.sample.characterviewer.model.RelatedTopicModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
@AndroidEntryPoint
class CharacterFragment : Fragment() {

    private var _binding: FragmentCharacterBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewerModel by viewModels<CharacterViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCharacterBinding.inflate(inflater, container, false)
        viewerModel.character.observe(viewLifecycleOwner){
            it.let{
                setupUI(it)
            }
        }
        val context: Context = requireContext()
        viewerModel.getCharacters(context)
        return binding.root

    }

    fun setupUI(characters:CharacterViewerModel){
        val view=binding.root
        val characterAdapter=CharacterAdapter(characters.relatedTopics as List<RelatedTopicModel>)
        binding.rvCharacters.apply {
            layoutManager=LinearLayoutManager(context)
            adapter=characterAdapter
        }

        characterAdapter.onItemClick = { character ->
            val bundle = Bundle().apply {
                putSerializable("CharacterItem", character)
            }

            val fragmentContainer = view.findViewById<FrameLayout>(R.id.fragmentContainer)

            if(fragmentContainer==null
            ) {
                findNavController().navigate(
                    R.id.action_CharacterFragment_to_characterDetailsFragment,
                    bundle
                )
            }
            else {


                val detailsFragment = CharacterDetailsFragment()
                detailsFragment.arguments = bundle

                val fragmentManager = requireActivity().supportFragmentManager
                val fragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.fragmentContainer, detailsFragment)
                //fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }
        binding.search.setOnQueryTextListener(object : SearchView.OnQueryTextListener
        {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                //TODO("Not yet implemented")
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {

                // to filter the data start with lastname given in a search bar
                val filteredList  = characters.relatedTopics.filter {
                    it.text?.contains(newText, ignoreCase = true)?:false
                }
                characterAdapter.updateData(filteredList)
                return true
            }
        })
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}