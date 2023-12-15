import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun mainScreen() {
    var squaresCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                squaresCount++
            },
            colors = ButtonDefaults.buttonColors(Color.DarkGray)
        ) {
            Text("Add Square")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier.padding(start = 16.dp)
        ) {
            items((0 until squaresCount).chunked(4)) { chunkedSquares ->
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    chunkedSquares.forEach { _ ->
                        squaresMS()
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun squaresMS() {
    Box(
        modifier = Modifier
            .size(50.dp)
            .background(Color.Blue)
    )
}
