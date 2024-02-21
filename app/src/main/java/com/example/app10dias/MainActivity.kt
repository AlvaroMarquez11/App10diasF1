package com.example.app10dias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.app10dias.model.F1
import com.example.app10dias.model.F1Repository
import com.example.app10dias.ui.theme.App10DiasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App10DiasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    F1App(if (isSystemInDarkTheme()) R.drawable.logof1negro else R.drawable.logof1)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F1App(image: Int) {
    val f1Repository = F1Repository()
    val datesEquips: List<F1> = f1Repository.getEquipos()
    Scaffold(
        topBar = {
            F1TopBar(image)
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(datesEquips) {
                F1Item(
                    f1 = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SentenceLightPreview() {
    App10DiasTheme(darkTheme = false) {
        F1App(R.drawable.logof1)
    }
}

@Preview(showBackground = true)
@Composable
fun SentenceDarkPreview() {
    App10DiasTheme(darkTheme = true) {
        F1App(R.drawable.logof1negro)
    }
}