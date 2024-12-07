package com.vegcale.forwantedly

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.vegcale.designsystem.theme.ForWantedlyTheme
import com.vegcale.forwantedly.ui.WantedlyApp
import com.vegcale.forwantedly.ui.rememberWantedlyAppState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val appState = rememberWantedlyAppState()

            ForWantedlyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WantedlyApp(
                        appState = appState,
                    )
                }
            }
        }
    }
}
