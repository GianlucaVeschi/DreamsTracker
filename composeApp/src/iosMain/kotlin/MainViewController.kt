import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import database.getDreamDatabase

fun MainViewController() = ComposeUIViewController {
    val dao = remember {
        getDreamDatabase().dreamDao()
    }
    App(dao)
}