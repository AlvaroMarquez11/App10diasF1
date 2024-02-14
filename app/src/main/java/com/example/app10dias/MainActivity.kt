package com.example.app10dias

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.app10dias.model.F1
import com.example.app10dias.model.F1Repository.sentences
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
                    FutbolApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FutbolApp() {
    Scaffold(
        topBar = {
            FutbolTopBar()
        }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(sentences) {
                SentenceItem(
                    f1 = it,
                    modifier = Modifier.padding(dimensionResource(id = R.dimen.padding_small))
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FutbolTopBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))

                /*Icon(
                    painterResource(R.drawable.balonfutbol),
                    contentDescription = null,
                    modifier = modifier.size(dimensionResource(R.dimen.image_size3))
                )*/

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.weight(1f))

                /*Icon(
                    painterResource(R.drawable.balonfutbol),
                    contentDescription = null,
                    modifier = modifier.size(dimensionResource(R.dimen.image_size3))
                )*/
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        modifier = modifier
    )
}

@Composable
fun SentenceItem(
    f1: F1,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(f1.colorFondoCarta))
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                ClubInformation(
                    f1.equipo,
                    f1.piloto1,
                    f1.piloto2,
                    f1.jefeEquipo,
                    f1.escudo,
                    f1.coche,
                    f1.link,
                    f1.numeroCampeonatosConstructores,
                    f1.numeroVictoriasPiloto1,
                    f1.numeroVictoriasPiloto2
                    //f1.colorFuente
                )
            }
        }
    }
}

@Composable
fun ClubInformation(
    @StringRes equipo: Int,
    @StringRes piloto1: Int,
    @StringRes piloto2: Int,
    @StringRes jefeEquipo: Int,
    @DrawableRes escuderia: Int,
    @DrawableRes coche: Int,
    @StringRes link: Int,
    numeroCampeonatosConstructores: Int,
    numeroCampeonatosPiloto1: Int,
    numeroCampeonatosPiloto2: Int,
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row {
            Column {
                NombreEquipo(equipo)
                Spacer(modifier = Modifier.weight(1f))
                Row {
                    repeat(numeroCampeonatosConstructores){
                        Image(
                            painter = painterResource(R.drawable.trofeo),
                            contentDescription = null,
                            modifier = modifier.size(18.dp)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Escudo(escuderia, modifier)
        }
        Column {
            Row {

                NombreJefeDeEquipo(jefeEquipo)
                Spacer(modifier = Modifier.weight(1f))
                IconBoton(expanded, onClick = { expanded = !expanded })
            }
            Row {
                if (expanded) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            painter = painterResource(coche),
                            contentDescription = null,
                            modifier = Modifier
                                .size(dimensionResource(R.dimen.image_size)),
                        )
                        Text(
                            text = stringResource(piloto1) + " " + numeroCampeonatosPiloto1 + " victoria(s)",
                            color = Color.White,
                        )
                        Text(
                            text = stringResource(piloto2) + " " + numeroCampeonatosPiloto2 + " victoria(s)",
                            color = Color.White,
                        )
                        EnlaceWeb(link)
                    }
                }
            }
        }
    }
}

@Composable
private fun NombreJefeDeEquipo(estadio: Int) {
    Text(
        text = "Jefe de equipo: " + stringResource(estadio),
        style = MaterialTheme.typography.titleLarge,
        color = Color.White,
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
        fontStyle = FontStyle.Italic,
    )
}

@Composable
private fun NombreEquipo(nombre: Int) {
    Text(
        text = stringResource(nombre),
        style = MaterialTheme.typography.titleLarge,
        color = Color.White,
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)),
        fontWeight = FontWeight.Bold,
    )
}

@Composable
private fun Escudo(escudo: Int, modifier: Modifier) {
    Image(
        painter = painterResource(escudo),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size2)),
        contentScale = ContentScale.Crop,
    )
}

@Composable
fun EnlaceWeb(@StringRes f1Link: Int) {
    val link = stringResource(f1Link)
    val localContext = LocalContext.current
    val linkSubrayado = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(link)
        }
    }
    TextButton(onClick = {
        val intentWeb = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        ContextCompat.startActivity(localContext, intentWeb, null)
    }) {
        Text(
            text = linkSubrayado,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Serif,
            fontSize = 15.sp,
            color = Color.White
        )
    }
}

@Composable
private fun IconBoton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SentenceLightPreview() {
    App10DiasTheme(darkTheme = false) {
        FutbolApp()
    }
}

@Preview(showBackground = true)
@Composable
fun SentenceDarkPreview() {
    App10DiasTheme(darkTheme = true) {
        FutbolApp()
    }
}