import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import database.DreamDao
import database.Dream
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun App(dreamDao: DreamDao) {
    MaterialTheme {
        val dreams by dreamDao.getAllDreams().collectAsState(initial = emptyList())
        val scope = rememberCoroutineScope()

        LaunchedEffect(true) {
            val dreamsList = listOf(
                Dream(name = "Gianluca"),
                Dream(name = "Alice"),
                Dream(name = "Philipp"),
            )
            dreamsList.forEach {
                dreamDao.upsert(it)
            }
        }

        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
        ) {
            items(dreams) { dream ->
                Text(
                    text = dream.name,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            scope.launch {
                                dreamDao.delete(dream)
                            }
                        }
                        .padding(16.dp)
                )
            }
        }
    }
}