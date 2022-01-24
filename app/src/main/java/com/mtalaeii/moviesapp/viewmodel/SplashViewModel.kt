package com.mtalaeii.moviesapp.viewmodel

import com.mtalaeii.core.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.runBlocking
@HiltViewModel
open class SplashViewModel:BaseViewModel() {
}