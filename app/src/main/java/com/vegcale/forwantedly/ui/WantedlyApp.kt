package com.vegcale.forwantedly.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vegcale.forwantedly.navigation.WantedlyNavHost

@Composable
internal fun WantedlyApp(
    appState: WantedlyAppState,
    modifier: Modifier = Modifier,
) {
    Scaffold { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            WantedlyNavHost(
                wantedlyAppState = appState
            )
        }
    }
}