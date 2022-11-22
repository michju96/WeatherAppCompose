package com.example.weatherappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weatherappcompose.ui.theme.NetworkMod
import com.example.weatherappcompose.ui.theme.WeatherAppComposeTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeatherAppComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ForecastItem()
                }
            }
        }
        Timber.plant(Timber.DebugTree())
        Timber.d("guwienko")
    }
}

@Composable
private fun ForecastItem() {

    val viewModel = remember {
        ForecastItemsViewModel(api = NetworkMod().api)
    }

    val state = viewModel.state.collectAsState()

    LazyColumn {
        items(count = state.value.temperature2m.size, itemContent = {

            val temperature = state.value.temperature2m[it]
            val date = state.value.time[it]
            ForecastListItem(temperature = temperature, date = date)
        })
    }
}
    @Composable
    fun ForecastListItem(temperature:String,date:String){
        Text(text = temperature)
        Text(text = date)
    }


    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun DefaultPreview() {
        WeatherAppComposeTheme {
        }
        ForecastItem()
    }
