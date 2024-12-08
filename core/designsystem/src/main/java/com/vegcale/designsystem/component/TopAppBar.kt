package com.vegcale.designsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vegcale.core.designsystem.R
import com.vegcale.designsystem.theme.ForWantedlyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WantedlyTopAppBar(
    modifier: Modifier = Modifier,
    currentQuery: String,
    onSearch: (String) -> Unit,
) {
    TopAppBar(
        title = {
            var value by rememberSaveable { mutableStateOf(currentQuery) }

            TextField(
                value = value,
                onValueChange = {
                    value = it
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        end = 16.dp,
                    ),
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = stringResource(
                            id = R.string.top_app_bar_content_description
                        )
                    )
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Search,
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(value) },
                ),
                singleLine = true,
                shape = RoundedCornerShape(
                    size = 16.dp
                ),
                colors = TextFieldDefaults.colors()
                    .copy(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        errorIndicatorColor = Color.Transparent,
                    )
            )
        },
        modifier = modifier,
    )
}


@Preview(showBackground = true)
@Composable
private fun WantedlyTopAppBarPreview() {
    ForWantedlyTheme {
        WantedlyTopAppBar(
            currentQuery = "",
            onSearch = {}
        )
    }
}
