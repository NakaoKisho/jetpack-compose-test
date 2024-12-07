package com.vegcale.forwantedly.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vegcale.designsystem.component.WantedlyTopAppBar
import com.vegcale.forwantedly.navigation.WantedlyNavHost

@Composable
internal fun WantedlyApp(
    appState: WantedlyAppState,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        topBar = { WantedlyTopAppBar() }
    ) { paddingValues ->
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
