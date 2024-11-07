/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.uikit.compose.elements.appbar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.compose.theme.AndroidStoreTheme
import ru.bampernn.uikit.resources.R as Res

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NTopAppBar(
    text: String = "",
) {
    Column {
        Spacer(
            modifier = Modifier.height(15.dp)
        )
        TopAppBar(
            title = {
                TopAppBarContent(
                    text = text,
                )
            },
            navigationIcon = {
                NavigationIcon()
            }
        )
    }
}

@Composable
fun TopAppBarContent(
    text: String = "",
) {
    Row {
        Spacer(modifier = Modifier.weight(1f))
        Text(text = text)
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun NavigationIcon() {
    Image(
        painter = painterResource(
            id = Res.mipmap.logo_bamper_nn,
        ),
        contentDescription = null,
    )
}

@Preview(showBackground = true)
@Composable
fun NavigationIconPreview() {
    AndroidStoreTheme {
        NavigationIcon()
    }
}

@Preview(showBackground = true)
@Composable
fun NTopAppBarPreview() {
    AndroidStoreTheme {
        NTopAppBar(
            text = "Store"
        )
    }
}
