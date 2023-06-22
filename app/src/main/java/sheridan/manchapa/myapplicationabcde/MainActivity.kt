package sheridan.manchapa.myapplicationabcde



import PetList
import PetViewModel
import androidx.activity.compose.setContent

import androidx.compose.material3.MaterialTheme
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import android.os.Bundle




class MainActivity : ComponentActivity() {
    private val petViewModel: PetViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                PetList(petViewModel)
            }
        }
    }
}