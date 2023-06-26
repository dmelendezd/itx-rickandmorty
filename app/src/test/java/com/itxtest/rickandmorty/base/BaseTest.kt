package com.itxtest.rickandmorty.base

import android.content.SharedPreferences
import android.util.Log
import com.itxtest.rickandmorty.view.main.view.MainActivity
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.mockkStatic
import io.mockk.unmockkAll
import org.junit.After
import org.junit.Before

abstract class BaseTest {

    protected val sharedPreferences = mockk<SharedPreferences>(relaxed = true)
    protected val currentActivity = mockk<MainActivity>(relaxed = true)

    @Before
    open fun setUp() {
        every { currentActivity.getSharedPreferences(any(), any()) } returns sharedPreferences

        ApplicationClass.currentActivity = currentActivity

        mockkStatic(Log::class)
        every { Log.d(any(), any()) } returns 0
    }

    @After
    fun tearDown() {
        unmockkAll()
        clearAllMocks()
    }
}