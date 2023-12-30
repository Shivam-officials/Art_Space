package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
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


        var animeImage by remember { mutableIntStateOf(R.drawable.kira_death_note_2006_2007) }

        var animeTitle by remember { mutableIntStateOf(R.string.death_note_title) }
        var animeStudio by remember { mutableIntStateOf(R.string.death_note_studio) }
        var animeAirTime by remember { mutableIntStateOf(R.string.death_note_airing_time) }

        var step by remember { mutableIntStateOf(1) }

        when (step) {
            1 -> {
                animeImage = R.drawable.kira_death_note_2006_2007
                animeTitle = R.string.death_note_title
                animeStudio = R.string.death_note_studio
                animeAirTime = R.string.death_note_airing_time
            }

            2 -> {
                animeImage = R.drawable.code_geass_lelouch_2006_2008
                animeTitle = R.string.code_geass_title
                animeStudio = R.string.code_geass_studio
                animeAirTime = R.string.code_geass_airing_time
            }

            3 -> {
                animeImage = R.drawable.aot_2013_2023
                animeTitle = R.string.attack_on_titan_title
                animeStudio = R.string.attack_on_titan_studio
                animeAirTime = R.string.attack_on_titan_airing_time
            }

            4 -> {
                animeImage = R.drawable.parasyte_2014_2015
                animeTitle = R.string.parasyte_title
                animeStudio = R.string.parasyte_studio
                animeAirTime = R.string.parasyte_airing_time
            }

            else -> {
                animeImage = R.drawable.naruto_2002_2007
                animeTitle = R.string.naruto_title
                animeStudio = R.string.naruto_studio
                animeAirTime = R.string.naruto_airing_time
            }
        }

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {

            ImageCard(animeImage)

        Spacer(modifier = Modifier.height(200.dp))



            AnimeDescriptor(animeTitle, animeStudio, animeAirTime)

//            Spacer(modifier = Modifier.height(25.dp))
            //controller
            AnimeController(
                previous = {

                    when (step) {
                        1 -> {
                            step = 5
                        }

                        else -> {
                            step--
                        }
                    }

                }
            ) {

                when (step) {
                    5 -> {
                        step = 1
                    }

                    else -> step++
                }

            }
        }


    }

// TODO: create the testing (UI[Instrument] and Logic[Unit]) code for app
    @Composable
    private fun AnimeController(
    previous: () -> Unit,
    next: () -> Unit
) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Absolute.SpaceAround
        ) {
            Button(
                onClick = { previous() },
//            onClick = previous,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Previous")
            }

            Button(
                onClick = next,
                modifier = Modifier.width(120.dp)
            ) {
                Text(text = "Next")
            }
        }
    }

    @Composable
    private fun AnimeDescriptor(animeTitle: Int, animeStudio: Int, animeAirTime: Int) {
        Card(
            colors = CardDefaults.cardColors(),
            modifier = Modifier.padding(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {

                //anime Name

                Text(
                    text = stringResource(id = animeTitle),
//                    modifier = Modifier.fillMaxWidth(),
                    fontSize = 40.sp,
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
        Card(
//            colors = CardDefaults.cardColors(Color(0x000000)),
            elevation = CardDefaults.cardElevation(100.dp),
//            border = BorderStroke(4.dp, Color.Green),
        ) {
            Image(
                painter = painterResource(animeImage),
                contentDescription = null,
                modifier = Modifier
                    .size(380.dp)
                    .padding(20.dp)
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
