package com.best.roots

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.best.roots.ui.theme.RootsTheme

@Composable
fun RootsAppLayout(content: @Composable () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { RootsTopAppBar() },
        bottomBar = { RootsBottomAppBar() },
        floatingActionButton = { RootsFab() }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            content()
        }
    }
}

@Preview
@Composable
fun RootsScaffoldPreview() {
    RootsTheme {
        RootsAppLayout {
            Text("Content")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootsTopAppBar() {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = { Text("Roots") }
    )
}

@Composable
fun RootsFab() {
   FloatingActionButton(onClick = { println("FAB clicked") }) {
       Icon(Icons.Default.Add, contentDescription = "Add")
   } 
}

@Composable
fun RootsBottomAppBar() {
    BottomAppBar {
        // TODO: BottomAppBar()
    }
}