import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PetViewModel : ViewModel() {
    val pets: MutableState<List<Pet>> = mutableStateOf(
        listOf(
            Pet("i7-11800H", true, 4.6f, Kind.DOG),
            Pet("Ryzen 9 5900HX", false, 4.6f, Kind.DOG),
            Pet("M1 Pro", true, 3.2f, Kind.CAT),
            Pet("i5-11300H", false, 4.4f, Kind.RABBIT)
        )
    )
}
