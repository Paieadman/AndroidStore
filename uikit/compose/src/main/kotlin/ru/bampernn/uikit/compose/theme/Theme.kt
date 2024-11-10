package ru.bampernn.uikit.compose.theme

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.compose.elements.text.TextArticle
import ru.bampernn.uikit.compose.theme.model.ContainerColors
import ru.bampernn.uikit.compose.theme.model.SurfaceColors
import ru.bampernn.uikit.compose.theme.model.TextColors

@Composable
fun AndroidStoreTheme(
//    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
//    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val surface: SurfaceColors = readSurfaceColors()
    val container: ContainerColors = readContainerColors()
    val text: TextColors = readTextColors()

    CompositionLocalProvider(
        LocalColorsSurface provides surface,
        LocalColorsContainer provides container,
        LocalColorsText provides text,
    ) {
        content()
    }
}

@Preview(
    showBackground = true
)
@Composable
internal fun TextArticlePreview() {
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
