package com.best.roots

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.best.roots.ui.theme.RootsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RootsApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun RootsAppPreview() {
    RootsApp()
}

@Composable
fun RootsApp() {
    RootsTheme {
        Garden()
    }
}

@Composable
fun Garden() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { RootsTopAppBar() },
        bottomBar = { RootsBottomAppBar() },
        floatingActionButton = { RootsFab() }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Garden")
        }
    }
}

@Preview
@Composable
fun GardenPreview() {
    Garden()
}