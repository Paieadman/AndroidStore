/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.uikit.compose.elements.text

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.compose.theme.AndroidStoreTheme
import ru.bampernn.uikit.compose.theme.Palette

@Composable
fun TextArticle(
    header: String,
    content: List<String>,
) {
    Column {
        Text(
            text = header,
            color = Palette.text.tertiary,
            textAlign = TextAlign.Start,
        )
        when {
            content.size > 1 -> {
                content.forEach {
                    Text(
                        text = it,
                        color = Palette.text.primary,
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                        maxLines = 1,
                    )
                }
            }
            content.size == 1 -> {
                Text(
                    text = content.first(),
                    color = Palette.text.primary,
                    textAlign = TextAlign.Start,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = Int.MAX_VALUE,
                )
            }
            else -> {}
        }
    }
}

@Preview(
    showBackground = true,
    apiLevel = Build.VERSION_CODES.TIRAMISU,
)
@Composable
fun TextArticlePreview() {
    AndroidStoreTheme {
        Column {
            TextArticle(
                header = "ТЕЛЕФОН",
                content = listOf(
                    "+7(777)7777777",
                    "+7(777)7777777",
                    "+7(777)7777777",
                    "+7(777)7777777",
                )
            )
            Spacer(Modifier.height(12.dp))
            TextArticle(
                header = "ТЕЛЕФОН",
                content = listOf(
                    "Сервис проверки текста на уникальность и биржа копирайтинга",
                )
            )
        }
    }
}
