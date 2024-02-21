package com.example.app10dias

import android.content.Intent
import android.net.Uri
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.app10dias.model.F1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun F1TopBar(image: Int, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f))
                LogoF1(image, modifier)
                Spacer(modifier = Modifier.weight(1f))
                Titulo()
                Spacer(modifier = Modifier.weight(1f))
                LogoF1(image, modifier)
                Spacer(modifier = Modifier.weight(1f))
            }
        },
        modifier = modifier
    )
}

@Composable
private fun LogoF1(image: Int, modifier: Modifier) {
    Image(
        painterResource(image),
        contentDescription = null,
        modifier = modifier.size(dimensionResource(R.dimen.image_size2))
    )
}

@Composable
private fun Titulo() {
    Text(
        text = stringResource(R.string.topBar),
        style = MaterialTheme.typography.displayLarge,
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun F1Item(
    f1: F1,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .clip(
                MaterialTheme.shapes.medium.copy(
                    topStart = CornerSize(0.dp),
                    bottomEnd = CornerSize(0.dp)
                )
            )
    ) {
        Column(
            modifier = Modifier
                .background(colorResource(f1.colorFondoCarta))
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessMediumLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.padding_small))
            ) {
                TeamInformation(
                    f1.equipo,
                    f1.piloto1,
                    f1.piloto2,
                    f1.jefeEquipo,
                    f1.escudo,
                    f1.coche,
                    f1.colorFuente,
                    f1.link,
                    f1.linkPresentation,
                    f1.numeroCampeonatosConstructores,
                    f1.numeroVictoriasPiloto1,
                    f1.numeroVictoriasPiloto2
                )
            }
        }
    }
}

@Composable
fun TeamInformation(
    @StringRes equipo: Int,
    @StringRes piloto1: Int,
    @StringRes piloto2: Int,
    @StringRes jefeEquipo: Int,
    @DrawableRes escuderia: Int,
    @DrawableRes coche: Int,
    @ColorRes colorFuente: Int,
    @StringRes link: Int,
    @StringRes linkPresentacion: Int,
    numeroCampeonatosConstructores: Int,
    numeroCampeonatosPiloto1: Int,
    numeroCampeonatosPiloto2: Int,
    modifier: Modifier = Modifier
) {
    var rotationState by remember { mutableStateOf(0f) }
    var expanded by remember { mutableStateOf(false) }
    Column {
        Row {
            Column {
                NombreEquipo(equipo, colorFuente)
                Spacer(modifier = Modifier.weight(1f))
                Row(modifier = modifier.padding(start = 15.dp)) {
                    Trofeos(numeroCampeonatosConstructores, modifier)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Escudo(escuderia, rotationState, modifier)
        }
        Column {
            Row {

                NombreJefeDeEquipo(jefeEquipo, colorFuente)
                Spacer(modifier = Modifier.weight(1f))
                IconBoton(expanded, onClick = {
                    expanded = !expanded
                    rotationState += 360f
                })
            }
            Row {
                if (expanded) {
                    Column(
                        modifier = modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        ImagenCoche(linkPresentacion, coche)
                        TextoInformativo(colorFuente)
                        TextoPiloto(piloto1, numeroCampeonatosPiloto1, colorFuente)
                        TextoPiloto(piloto2, numeroCampeonatosPiloto2, colorFuente)
                        EnlaceWeb(link, colorFuente)
                    }
                }
            }
        }
    }
}

@Composable
private fun Trofeos(
    numeroCampeonatosConstructores: Int,
    modifier: Modifier
) {
    repeat(numeroCampeonatosConstructores) {
        Image(
            painter = painterResource(R.drawable.trofeo),
            contentDescription = null,
            modifier = modifier
                .size(18.dp)
        )
    }
}

@Composable
private fun TextoPiloto(piloto: Int, numeroCampeonatosPiloto: Int, @ColorRes colorFuente: Int) {
    Text(
        text = stringResource(piloto) + " " + numeroCampeonatosPiloto + " " + stringResource(R.string.victorias),
        color = colorResource(colorFuente),
    )
}

@Composable
private fun TextoInformativo(@ColorRes colorFuente: Int) {
    val subrayado = buildAnnotatedString {
        withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
            append(stringResource(R.string.clickImagen))
        }
    }
    Text(
        text = subrayado,
        color = colorResource(colorFuente),
        modifier = Modifier
            .padding(
                top = dimensionResource(R.dimen.padding_small),
                bottom = dimensionResource(R.dimen.padding_medium)
            )
    )
}

@Composable
private fun ImagenCoche(linkPresentacion: Int, coche: Int) {
    val context = LocalContext.current
    val linkPres = stringResource(linkPresentacion)

    Image(
        painter = painterResource(coche),
        contentDescription = null,
        modifier = Modifier
            .clip(
                MaterialTheme.shapes.large.copy(
                    topStart = CornerSize(0.dp)
                )
            )
            .clickable {
                val intent = Intent(
                    Intent.ACTION_VIEW, Uri.parse(linkPres)
                )
                context.startActivity(intent)
            }
    )
}

@Composable
private fun NombreJefeDeEquipo(estadio: Int, @ColorRes colorFuente: Int) {
    Text(
        text = stringResource(R.string.jefeEquipo) + "  " + stringResource(estadio),
        style = MaterialTheme.typography.titleLarge,
        color = colorResource(colorFuente),
        modifier = Modifier.padding(dimensionResource(R.dimen.padding_small)),
        fontStyle = FontStyle.Italic
    )
}

@Composable
private fun NombreEquipo(nombre: Int, @ColorRes colorFuente: Int) {
    Text(
        text = stringResource(nombre),
        style = MaterialTheme.typography.displayLarge,
        color = colorResource(colorFuente),
        modifier = Modifier
            .padding(dimensionResource(R.dimen.padding_medium)),
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun Escudo(escudo: Int, rotation: Float, modifier: Modifier) {
    val animatedRotation by animateFloatAsState(
        targetValue = rotation,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    Image(
        painter = painterResource(escudo),
        contentDescription = null,
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .rotate(animatedRotation),
        contentScale = ContentScale.Crop
    )
}

@Composable
fun EnlaceWeb(@StringRes f1Link: Int, @ColorRes colorFuente: Int) {
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
            color = colorResource(colorFuente)
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
