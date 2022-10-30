package mhk.app.anime_compose_clean_arch_mvvm_flow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dagger.hilt.android.AndroidEntryPoint
import mhk.app.anime_compose_clean_arch_mvvm_flow.ui.presentation.AnimeListScreen
import mhk.app.anime_compose_clean_arch_mvvm_flow.ui.theme.AnimeComposeCleanArchMVVMFlowTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimeComposeCleanArchMVVMFlowTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    AnimeListScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnimeComposeCleanArchMVVMFlowTheme {
        Greeting("Android")
    }
}