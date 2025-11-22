package org.example.project.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable (() -> Unit)? = null,
    bottomBar: @Composable (() -> Unit)? = null,
    floatingActionButton: @Composable (() -> Unit)? = null,
    snackbarHost: @Composable (() -> Unit)? = null,
    content: @Composable (PaddingValues) -> Unit
) {
    val colors = MaterialTheme.colorScheme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = colors.background,
        contentColor = colors.onBackground
    ) {
        Scaffold(
            modifier = modifier,
            containerColor = colors.background,
            contentColor = colors.onBackground,
            topBar = { topBar?.invoke() },
            bottomBar = { bottomBar?.invoke() },
            floatingActionButton = { floatingActionButton?.invoke() },
            snackbarHost = { snackbarHost?.invoke() },
            content = content
        )
    }
}
