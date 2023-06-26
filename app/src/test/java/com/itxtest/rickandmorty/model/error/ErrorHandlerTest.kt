package com.itxtest.rickandmorty.model.error

import com.itxtest.rickandmorty.base.BaseTest
import com.itxtest.rickandmorty.view.platform.app.ApplicationClass
import io.mockk.mockk
import io.mockk.verify
import org.junit.Test

class ErrorHandlerTest : BaseTest() {

    @Test
    fun `test onServiceError`() {
        ErrorHandler.getInstance().onServiceError(Throwable(message = "message"))
        verify(exactly = 1) { currentActivity.showErrorOverlay() }
    }

    @Test
    fun `test onServiceError null throwable`() {
        ErrorHandler.getInstance().onServiceError(null)
        verify(exactly = 1) { currentActivity.showErrorOverlay() }
    }

    @Test
    fun `test onServiceError currentActivity not MainActivity`() {
        ApplicationClass.currentActivity = mockk()

        ErrorHandler.getInstance().onServiceError(Throwable(message = "message"))

        verify(exactly = 0) { currentActivity.showErrorOverlay() }
    }
}