package com.itxtest.rickandmorty.characterslist.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.itxtest.rickandmorty.characterslist.presenter.CharactersListPresenter
import com.itxtest.rickandmorty.platform.base.view.BaseFragment
import com.itxtest.rickandmorty.databinding.FragmentCharactersListLandingBinding

class CharactersListLandingFragment : CharactersListView, BaseFragment() {

    private var _binding: FragmentCharactersListLandingBinding? = null
    private val binding get() = _binding!!
    private lateinit var presenter: CharactersListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CharactersListPresenter(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersListLandingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        presenter.onViewInitialized()
    }

    private fun initView() {

    }
}
