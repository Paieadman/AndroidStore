package ru.bampernn.uikit.compose.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.bampernn.uikit.resources.R as Res

@Preview(showBackground = true)
@Composable
internal fun ColorsPreview() {
    val colorsList = listOf(
        Res.color.brand,
        Res.color.surface_primary,
        Res.color.container_primary,
        Res.color.container_secondary,
        Res.color.text_primary,
        Res.color.text_secondary,
    )
    AndroidStoreTheme {
        Column {
            colorsList.forEach {
                ColoredBox(it)
            }
        }
    }
}

@Composable
fun ColoredBox(
    id: Int,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = LocalContext.current.resources.getResourceEntryName(id),
        )
        Box(
            modifier = Modifier
                .size(
                    size = 80.dp
                )
                .background(
                    color = colorResource(id = id),
                )
        )
    }
}
