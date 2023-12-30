package com.example.artspace

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.artspace.ui.theme.ArtSpaceTheme

import org.junit.Test

import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ArtSpaceUiTest{

    /**
     * composeTestRule for setting up the testing environment by laying out the screen and then
     * interacting with ui element and doing assertion
     */
    @get:Rule
    val composeTestRule = createComposeRule()

    //button for next button navigation
    @Test
    fun nextButton(){
        
        //setting up the screen
        composeTestRule.setContent { 
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeApp()
                }
            }
        }

//      clicking and checking the next button
        composeTestRule.onNodeWithText("Next")
            .performClick()
        composeTestRule.onNodeWithText("Code Geass")
            .assertExists()
    }

    //button for previous button navigation
    @Test
    fun previousButton() {
        //setting up the screen
        composeTestRule.setContent {
            ArtSpaceTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AnimeApp()
                }
            }
        }

        //clicking and checking the previous button
        composeTestRule.onNodeWithText("Previous")
            .performClick()
        composeTestRule.onNodeWithText("Naruto")
            .assertExists()
    }
}