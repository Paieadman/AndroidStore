/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.contactus

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.compose.elements.text.TextArticle
import ru.bampernn.uikit.compose.theme.AndroidStoreTheme
import ru.bampernn.uikit.compose.theme.Palette
import ru.bampernn.uikit.resources.R as Res


@Composable
fun ContactUsRoute() {
    ContactUsScreenContent()
}

@Composable
fun ContactUsScreen() {

}

@Composable
fun ContactUsScreenContent() {
    Column(
        modifier = Modifier
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp,
            )
            .background(
                color = Palette.container.secondary,
            )
    ) {
        TextArticle(
            header = stringResource(
                id = Res.string.main_office,
            ),
            content = listOf(
                stringResource(
                    id = Res.string.main_office_value,
                ),
            )
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ContactUsScreenContentPreview() {
    AndroidStoreTheme {
        ContactUsScreenContent()
    }
}