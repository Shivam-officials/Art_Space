package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeApp()
                }
            }
        }
    }
}

@Composable
fun AnimeApp() {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally, content = function()
    )


}

@Composable
private fun function(): @Composable() (ColumnScope.() -> Unit) =
    {

        val animeImage by remember {
            mutableStateOf(R.drawable.kira_death_note_2006_2007)
        }

        val animeTitle by remember { mutableStateOf(R.string.death_note_title) }
        val animeStudio by remember { mutableStateOf(R.string.death_note_studio) }
        val animeAirTime by remember { mutableStateOf(R.string.death_note_airing_time) }

        ImageCard(animeImage)

        Spacer(modifier = Modifier.height(30.dp))

        AnimeDescreptor(animeTitle, animeStudio, animeAirTime)



    }

@Composable
private fun AnimeDescreptor(animeTitle: Int, animeStudio: Int, animeAirTime: Int) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            Color(0xffCCCCCC)
        ),

        ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {

            //anime Name
            Text(
                text = stringResource(id = animeTitle),
                style = TextStyle.Default.copy(
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                )
            )

            //Row for studio and airTime
            Row {

                //Anime studio name
                Text(
                    text = stringResource(id = animeStudio),
                    style = TextStyle.Default.copy(
                        fontWeight = FontWeight.ExtraBold
                    )
                )

                //anime airing time
                Text(
                    text = " (${stringResource(id = animeAirTime)})"
                )
            }

        }
    }
}

//image card to show the image of the anime
@Composable
private fun ImageCard(animeImage: Int) {
    OutlinedCard(
        colors = CardDefaults.cardColors(),
        elevation = CardDefaults.cardElevation(),
    ) {
        Image(
            painter = painterResource(animeImage),
            contentDescription = null,
            modifier = Modifier
                .padding(10.dp)
        )
    }
}

@Preview
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AnimeApp()
        }
    }
}