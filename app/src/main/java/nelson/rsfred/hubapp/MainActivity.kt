package nelson.rsfred.hubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import nelson.rsfred.hubapp.ui.composable.approot.AppRoot
import nelson.rsfred.hubapp.ui.theme.NOFHPAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NOFHPAppTheme {
                AppRoot()
            }
        }
    }
}