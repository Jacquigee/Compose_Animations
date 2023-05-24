package com.example.composeanimations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composeanimations.ui.theme.ComposeAnimationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAnimationsTheme {
                //Columns are use to place items vertically on the screen
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    /*
                    * remember is a composable function in jetpack compose that allows you to save
                    * and retrieve a value that persists during recomposition.
                    * Can be used to store mutable and immutable objects.
                    * N:B -> remember stores objects in the composition and forgets the object when
                    * the composable that called remember is removed from the composition.
                    */
//                    var isVisible by remember {
//                        mutableStateOf(false)
//                    }
//                    Button(onClick = {
//                        isVisible = !isVisible
//                    }) {
//                        Text(text = "Click Here")
//                    }
                    /*
                    AnimatedVisibility animates the appearance and disappearance of its content.
                     */
//                    AnimatedVisibility(
//                        visible = isVisible,
//                        enter = slideInHorizontally() + fadeIn(),
//                        exit = slideOutHorizontally() + fadeOut(),
//                        modifier = Modifier
//                            .fillMaxWidth()
//                            .weight(1f)
//                    ) {
//                        Box(
//                            modifier = Modifier
//                                .size(10.dp)
//                                .background(androidx.compose.ui.graphics.Color.Green)
//                        )
//
//                    }

                    /*
                    * Fading in and expanding, fading out and shrinking.
                     */

//                    var visible by remember {
//                        mutableStateOf(true)
//                    }
//                    val density = LocalDensity.current
//                    Button(onClick = {
//                        visible = !visible
//                    }) {
//                        Text(text = "click here")
//                    }
//                    AnimatedVisibility(visible = visible,
//                    enter = slideInVertically {
//                        with(density) {-40.dp.roundToPx()}
//                    } + expandVertically(
//                        expandFrom = Alignment.Top
//                    ) + fadeIn(initialAlpha = 0.3f),
//                    exit = slideOutVertically() + shrinkVertically() + fadeOut()) {
//                        Box(modifier = Modifier
//                            .fillMaxWidth()
//                            .fillMaxHeight()
//                            .background(color = Color.Blue)){
//                            Text("Hello")
//                        }
//
//                    }

                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.Gray)
                            .animateContentSize()
                    ) {

                        var isExpanded by remember {
                            mutableStateOf(false)
                        }

                        Row(modifier = Modifier
                            .padding(16.dp)
                            .clickable { isExpanded = !isExpanded }) {

                            Icon(
                                imageVector = Icons.Default.Info,
                                contentDescription = "",
                                tint = Color.White
                            )
                            Text(
                                text = if (isExpanded)
                                    "Hide information"
                                else
                                    "Click to see more information ...",
                                color = Color.White,
                                modifier = Modifier.padding(16.dp, 0.dp, 0.dp, 0.dp)
                            )

                        }
                        if (isExpanded) {
                            Text(
                                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras placerat tincidunt massa. Proin pretium aliquam bibendum. Fusce ut metus hendrerit, placerat dolor vitae, feugiat mi. Integer pretium magna ut dolor lobortis mollis. Aliquam in nulla congue, rhoncus nunc a, dignissim sapien. Nunc porta mauris ligula. Nullam quis aliquam erat.",
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}
