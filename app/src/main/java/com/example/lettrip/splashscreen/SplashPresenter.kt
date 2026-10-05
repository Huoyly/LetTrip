package com.example.lettrip.splashscreen

import com.example.lettrip.data.SessionRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class SplashPresenter(
    private val repository: SessionRepository,
    private val minSplashMillis: Long = 1500L,
    mainDispatcher: CoroutineDispatcher = Dispatchers.Main
) : SplashContract.Presenter {

    private var view: SplashContract.View? = null
    private var job: Job? = null
    private val scope = CoroutineScope(SupervisorJob() + mainDispatcher)


    override fun attach(view: SplashContract.View) {
        this.view = view
    }

    override fun detach() {
        job?.cancel()
        scope.cancel()
        view = null
    }

    override fun onViewReady() = startFlow()

    override fun onRetryClicked() = startFlow()


    private fun startFlow(){
        job?.cancel()
        view?.showLoading()
        job = scope.launch {
            try {
                val loggedIn = coroutineScope{
                    val minTime = async { delay(minSplashMillis.milliseconds) }
                    val session = async { repository.isLoggedIn() }
                    minTime.await()
                    session.await()
                }
                if (loggedIn) view?.navigateToHome() else view?.navigateToLogin()
            } catch (e: CancellationException){
                throw e
            } catch (e: Exception){
                view?.showError(e.message ?: "Something Went Wrong")
            }
        }
    }

}
