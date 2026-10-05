package com.example.lettrip.splashscreen

interface SplashContract {

    interface View{
        fun showLoading()
        fun showError(message: String)
        fun navigateToHome()
        fun navigateToLogin()
    }
    interface Presenter{
        fun attach(view: View)
        fun detach()
        fun onViewReady()
        fun onRetryClicked()
    }
}
