import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*


@Composable
fun PetList(petViewModel: PetViewModel) {
    val viewModel: PetViewModel = viewModel()
    var pets by remember(viewModel.pets) { viewModel.pets }

    LaunchedEffect(viewModel.pets) {
        snapshotFlow { viewModel.pets.value }
            .collect { newPets ->
                pets = newPets
            }
    }
    LazyColumn(
        modifier = Modifier.padding(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 0.dp)
    ) {
        items(pets) { pet ->
            PetRow(pet = pet)
        }
    }

}
@Composable
fun viewModel(): PetViewModel {
    return remember { PetViewModel() }
}

@Composable
fun PetRow(pet: Pet) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = pet.name,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Vaccination: ${pet.vaccinated}",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = "Age: ${pet.age}",
                modifier = Modifier.weight(1f)
            )
            Text(
                text = pet.kind.name,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
