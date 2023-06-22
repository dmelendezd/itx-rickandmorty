package com.itxtest.rickandmorty.platform.base.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.itxtest.rickandmorty.databinding.BaseOverlayBinding
import com.itxtest.rickandmorty.platform.app.ApplicationClass

abstract class BaseOverlay : BottomSheetDialogFragment(), BaseView {

    private var _binding: BaseOverlayBinding? = null
    private val binding get() = _binding!!
    private lateinit var customView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BaseOverlayBinding.inflate(inflater, container, false)
        customView = onCreateCustomView(inflater, container, savedInstanceState)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.customViewContainer.addView(customView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding
    }

    override fun showLoading() {
        binding.loadingView.show()
    }

    override fun hideLoading() {
        binding.loadingView.hide()
    }

    abstract fun onCreateCustomView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View

    fun show() {
        show(ApplicationClass.currentActivity.supportFragmentManager, this::class.java.simpleName)
    }
}
