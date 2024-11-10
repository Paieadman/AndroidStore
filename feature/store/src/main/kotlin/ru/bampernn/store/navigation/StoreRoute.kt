/*
 * ------------------------------------------------------------
 * "THE BEERWARE LICENSE" (Revision 42):
 * Nikolay Reshetnikov wrote this code. As long as you retain this
 * notice, you can do whatever you want with this stuff. If we
 * meet someday, and you think this stuff is worth it, you can
 * buy me a beer in return.
 * ------------------------------------------------------------
 */

package ru.bampernn.store.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import ru.bampernn.store.StoreMainRoute

@Serializable
object StoreRoute

fun NavController.navigateToStore(navOptions: NavOptions) = navigate(
    route = StoreRoute,
    navOptions = navOptions,
)

fun NavGraphBuilder.storeScreen() {
    composable<StoreRoute> {
        StoreMainRoute()
    }
}
