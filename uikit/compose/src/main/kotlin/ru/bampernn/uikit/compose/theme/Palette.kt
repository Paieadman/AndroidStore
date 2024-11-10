/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.uikit.compose.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.res.colorResource
import ru.bampernn.uikit.compose.theme.model.ContainerColors
import ru.bampernn.uikit.compose.theme.model.SurfaceColors
import ru.bampernn.uikit.compose.theme.model.TextColors
import ru.bampernn.uikit.resources.R

@Immutable
@Stable
object Palette {
    val surface: SurfaceColors
        @Composable get() = LocalColorsSurface.current
    val container: ContainerColors
        @Composable get() = LocalColorsContainer.current
    val text: TextColors
        @Composable get() = LocalColorsText.current
}

val LocalColorsSurface = staticCompositionLocalOf<SurfaceColors> {
    SurfaceColors()
}
val LocalColorsContainer = staticCompositionLocalOf<ContainerColors> {
    ContainerColors()
}
val LocalColorsText = staticCompositionLocalOf<TextColors> { TextColors() }

@Composable
fun readSurfaceColors(): SurfaceColors =
    SurfaceColors(
        primary = colorResource(
            R.color.surface_primary,
        )
    )

@Composable
fun readContainerColors(): ContainerColors =
    ContainerColors(
        primary = colorResource(
            R.color.container_primary,
        ),
        secondary = colorResource(
            R.color.container_secondary,
        )
    )

@Composable
fun readTextColors(): TextColors =
    TextColors(
        primary = colorResource(
            R.color.text_primary,
        ),
        secondary = colorResource(
            R.color.text_secondary,
        ),
        tertiary = colorResource(
            R.color.text_tertiary,
        )
    )
