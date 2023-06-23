package com.itxtest.rickandmorty.view.main.view.dialog

import android.os.Bundle
import android.view.View
import com.itxtest.rickandmorty.databinding.HelpDialogBinding
import com.itxtest.rickandmorty.view.platform.base.view.BaseDialog

class HelpDialog : BaseDialog() {

    private lateinit var binding: HelpDialogBinding

    override fun getCustomDialogView(): View {
        binding = HelpDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
    }

    private fun initView() {
        binding.okAction.setOnClickListener { dismiss() }
    }
}