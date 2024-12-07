package com.vegcale.recruitment

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.vegcale.designsystem.theme.ForWantedlyTheme

@Composable
internal fun RecruitmentScreen(
    viewModel: ProjectsViewModel = hiltViewModel(),
) {
    viewModel.getProjects()
    RecruitmentScreenRoute()
}

@Composable
private fun RecruitmentScreenRoute(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
        contentPadding = PaddingValues(
            horizontal = 10.dp
        ),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        items(
            count = 10
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                border = BorderStroke(
                    width = 1.dp,
                    color = Color.LightGray
                ),
            ) {
                Box {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(
                                all = 8.dp
                            )
                    ) {
                        Image(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                        Text(text = "title")
                        Text(text = "company name")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RecruitmentScreenPreview() {
    ForWantedlyTheme {
        RecruitmentScreenRoute()
    }
}
