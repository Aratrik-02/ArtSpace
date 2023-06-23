package com.example.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
                    ArtDisplayPreview()
                }
            }
        }
    }
}

@Composable
fun ArtDisplay(modifier: Modifier = Modifier) {
    var ind by remember {
        mutableStateOf(0)
    }
    val images = listOf(
        R.drawable.a_sunday_afternoon_on_the_island_of_la_grande_jatte,
        R.drawable.guernica,
        R.drawable.monalisa,
        R.drawable.starry_night,
        R.drawable.girl_with_a_pearl_earring,
        R.drawable.portrait_de_l_artiste_sans_barbe,
        R.drawable.the_persistence_of_memory,
        R.drawable.the_scream,
        R.drawable.whistler_s_mother
    )
    val imageNames = listOf(
        stringResource(R.string.A_Sunday_Afternoon_on_the_Island_of_La_Grande_Jatte),
        stringResource(R.string.Guernica),
        stringResource(R.string.monalisa),
        stringResource(R.string.starry_night),
        stringResource(R.string.girl_with_a_pearl_earring),
        stringResource(R.string.portrait_de_l_artiste_sans_barbe),
        stringResource(R.string.the_persistence_of_memory),
        stringResource(R.string.the_scream),
        stringResource(R.string.Whistler_Mother)
    )
    val painterNames = listOf(
        stringResource(R.string.Georges_Seurat),
        stringResource(R.string.Pablo_Picasso),
        stringResource(R.string.Leonardo_da_Vinci),
        stringResource(R.string.Van_Gogh),
        stringResource(R.string.Johannes_Vermeer),
        stringResource(R.string.Van_Gogh),
        stringResource(R.string.Salvador_Dali),
        stringResource(R.string.Edvard_Munch),
        stringResource(R.string.James_McNeill_Whistler)
    )
    val totalImages = images.size
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState()),
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .fillMaxWidth()
        ) {
            Image(
                painterResource(id = images[ind]),
                contentDescription = imageNames[ind],
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 150.dp)
                    .widthIn(350.dp)
                    .heightIn(50.dp,380.dp)
                    .border(BorderStroke(20.dp, Color.White))
                    .shadow(elevation = 25.dp)
            )
        }
        Spacer(modifier = Modifier.height(height = 150.dp))
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(start = 40.dp, end = 40.dp)
                .background(Color.LightGray)
        ){
            Text(
                text = imageNames[ind],
                fontSize = 20.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier
                    .padding(top = 15.dp,start = 15.dp, end = 15.dp)
            )
            Text(
                text = painterNames[ind],
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Left,
                modifier = Modifier
                    .padding(top = 5.dp,bottom = 15.dp,start = 15.dp, end = 15.dp)
            )
        }
        Spacer(modifier = Modifier.height(height = 20.dp))
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = modifier
        ){
            Button(
                onClick = {
                      ind = (ind - 1)%totalImages
                      if(ind == -1)ind = totalImages - 1
                },
                modifier = Modifier
                    .width(150.dp)
            ){
                Text(text = "Previous")
            }
            Spacer(modifier = Modifier.width(width = 50.dp))
            Button(
                onClick = {
                    ind = (ind + 1)%totalImages
                },
                modifier = Modifier
                    .width(150.dp)
            ){
                Text(text = "Next")
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun ArtDisplayPreview() {
    ArtSpaceTheme {
        ArtDisplay()
    }
}