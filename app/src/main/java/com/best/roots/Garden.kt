package com.best.roots

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@Composable
fun Garden(vm: GardenViewmodel = viewModel()) {

    val model by vm.model.collectAsState()

    val nav = rememberNavController()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { RootsTopAppBar("Garden") },
        bottomBar = { RootsBottomAppBar() },
        floatingActionButton = {
            FloatingActionButton(onClick = { vm.addPlantProject() }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            PlantProjectList(plantProjects = model.plantProjects)

            if (model.showingAddPlantProjectForm) {
                Dialog(onDismissRequest = { /*TODO*/ }) {
                    AddPlantProjectForm()
                }
            }
        }
    }
}

@Preview
@Composable
fun GardenPreview() {

    val viewmodel = GardenViewmodel().apply {
        model.value.plantProjects.add(PlantProject("Chilis"))
        model.value.plantProjects.add(PlantProject("Spider Plant"))
        model.value.plantProjects.add(PlantProject("Peace Lily"))
    }

    Garden(viewmodel)
}

@Composable
fun PlantProjectList(plantProjects: List<PlantProject>) {

    LazyColumn(
        Modifier
            .padding(10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(plantProjects) { p ->
            PlantProjectCard(plantProject = p)
        }
    }
}

@Composable
fun PlantProjectCard(plantProject: PlantProject) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        elevation = CardDefaults.cardElevation(5.dp),
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Box(
            modifier = Modifier.padding(10.dp)
        ) {
            Text(plantProject.name)
        }
    }
}

@Composable
fun AddPlantProjectForm() {
    Text("Form")
}

data class PlantProject(val name: String = "PlantProject")

class GardenModel {

    val plantProjects = mutableListOf<PlantProject>()

    var showingAddPlantProjectForm = false
}

@HiltViewModel
class GardenViewmodel @Inject constructor() : ViewModel() {

    private val _model = MutableStateFlow(GardenModel())

    val model = _model.asStateFlow()

    fun addPlantProject() {

        // TODO: Show AddPlantProjectForm.
    }
}