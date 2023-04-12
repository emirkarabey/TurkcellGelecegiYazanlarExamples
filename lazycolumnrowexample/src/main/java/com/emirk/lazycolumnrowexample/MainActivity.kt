package com.emirk.lazycolumnrowexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.emirk.lazycolumnrowexample.ui.theme.TurkcellGelecegiYazanlarExamplesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TurkcellGelecegiYazanlarExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LazyExample()
                }
            }
        }
    }
}

@Composable
fun LazyExample() {

    Column(Modifier.fillMaxSize()) {

        Text(text = "LazyColumn", fontWeight = FontWeight.Bold)

        LazyColumn {
            items(5) { index ->
                Text(
                    text = "${index + 1}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
            }
        }

        Text(text = "LazyRow", fontWeight = FontWeight.Bold)

        LazyRow {
            items(5) { index ->
                Text(
                    text = "${index + 1}",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(16.dp)
                        .width(20.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TurkcellGelecegiYazanlarExamplesTheme {
        LazyExample()
    }
}