package ru.bampernn.uikit.compose.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.compose.elements.text.TextArticle
import ru.bampernn.uikit.compose.theme.model.ContainerColors
import ru.bampernn.uikit.compose.theme.model.SurfaceColors
import ru.bampernn.uikit.compose.theme.model.TextColors

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun AndroidStoreTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val surface: SurfaceColors = readSurfaceColors()
    val container: ContainerColors = readContainerColors()
    val text: TextColors = readTextColors()



    CompositionLocalProvider(
        LocalColorsSurface provides surface,
        LocalColorsContainer provides container,
        LocalColorsText provides text,
    ) {
        content()
//        MaterialTheme(
////            colorScheme = colorScheme,
//            typography = Typography,
//            content = content,
//        )
    }
}

@Preview
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
