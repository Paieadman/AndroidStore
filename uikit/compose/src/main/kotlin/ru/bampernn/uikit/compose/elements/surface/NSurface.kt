/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this 
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.uikit.compose.elements.surface

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import ru.bampernn.uikit.compose.theme.Palette

@Composable
fun NSurface(
    content: @Composable ()->Unit,
) {
    Surface(
        color = Palette.surface.primary,
        content = content,
    )
}