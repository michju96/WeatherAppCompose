package com.example.weatherappcompose

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherappcompose.dto.Forecast
import com.example.weatherappcompose.dto.Hourly
import com.example.weatherappcompose.dto.HourlyUnits
//import com.example.weatherappcompose.dto.huj
import com.example.weatherappcompose.ui.theme.WeatherAppComposeApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class ForecastItemsViewModel(private val api: WeatherAppComposeApi) : ViewModel() {

    val state = MutableStateFlow(Hourly(emptyList(), emptyList()))

    init {
        viewModelScope.launch(Dispatchers.Default) {
            Timber.d("dguwnow")

            val temperatures = api.showAll(53.13,23.16,"temperature_2m")

            state.value = temperatures.hourly

            Timber.d("temperatures : $temperatures")
        }

    }
}
