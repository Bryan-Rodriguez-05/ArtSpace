package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.artspace.ui.theme.ArtSpaceTheme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge() // Commented out
        setContent {
            ArtSpaceTheme {
                ArtApp()
            }
        }
    }
}

@Composable
fun ArtApp() {
    var currentStep by remember { mutableStateOf(1) }
    when (currentStep) {
        1 -> {
            ArtAppWithArgs(
                name = "Android",
                imageIdRes = R.drawable.la_gioconda,
                tittleIdRes = R.string.title1,
                artistIdRes = R.string.artist1,
                yearIdRes = R.string.year1,
                onNextClick = {
                    currentStep++
                },
                currentStep = currentStep
            )
        }
        2 -> {
            ArtAppWithArgs(
                name = "Android",
                imageIdRes = R.drawable.la_noche_estrellada,
                tittleIdRes = R.string.title2,
                artistIdRes = R.string.artist2,
                yearIdRes = R.string.year2,
                onNextClick = {
                    currentStep++
                },
                onPreviousClick = {
                    currentStep--
                },
                currentStep = currentStep
            )
        }
        3 -> {
            ArtAppWithArgs(
                name = "Android",
                imageIdRes = R.drawable.la_ultima_cena,
                tittleIdRes = R.string.title3,
                artistIdRes = R.string.artist1,
                yearIdRes = R.string.year3,
                onPreviousClick = {
                    currentStep--
                },
                currentStep = currentStep
            )
        }
    }
}

@Composable
fun ArtAppWithArgs(name: String, modifier: Modifier = Modifier
                   ,imageIdRes  : Int = 0, tittleIdRes : Int = 0, artistIdRes : Int = 0,yearIdRes : Int = 0,
                   onNextClick: () -> Unit = {},onPreviousClick : () ->Unit = {},
                   currentStep : Int = 1) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )

    Box(

    ){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        )
        {
            Image(painter = painterResource(id = imageIdRes ) , contentDescription ="" )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = stringResource(id = tittleIdRes))
            Spacer(modifier = Modifier.height(20.dp))
            Row {
                Text(text = stringResource(id = artistIdRes))
                Spacer(modifier = Modifier.width(11.dp))
                Text(text = stringResource(id = yearIdRes))
            }

            Spacer(modifier = Modifier.height(40.dp))
            Row(){
                Button(onClick = onPreviousClick) {
                    Text(text = "Previous")
                }
                Spacer(modifier = Modifier.width(25.dp))
                Button(onClick = onNextClick) {
                    Text(text = "Next")
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceTheme {
        ArtApp()
    }
}