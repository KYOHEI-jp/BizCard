package com.example.bizcard

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bizcard.ui.theme.BizCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}

@Composable
fun CreateBizCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Card(
            modifier = Modifier
                .width(200.dp)
                .height(390.dp)
                .padding(12.dp),
            shape = RoundedCornerShape(corner = CornerSize(15.dp)),
            elevation = 4.dp
        ) {
            Column(
                modifier = Modifier.height(300.dp), verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CreateImageProfile()
                Divider()
                CreateInfo()
                Button(onClick = {
                    
                }) {
                    Text("ポートフォリオ", style = MaterialTheme.typography.button)
                }
            }
        }

    }
}

@Preview
@Composable
fun Content() {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Surface(
            modifier = Modifier
                .padding(3.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 2.dp, color = LightGray)
        ) {
            Portfolio(
                data = listOf(
                    "Project 1", "Project 2", "Project 3",
                    "Project 3",
                    "Project 3",
                )
            )
        }
    }
}

@Composable
fun Portfolio(data: List<String>) {
    Text("プロジェクトはここ！")
    LazyColumn {
        items(data) { item ->
            Text(item)
        }
    }
}

@Composable
private fun CreateInfo() {
    Column(
        Modifier.padding(5.dp)
    ) {
        Text(
            text = "KYOHEI WATANABE",
            style = MaterialTheme.typography.h4,
            color = MaterialTheme.colors.primaryVariant
        )
        Text(text = "Android Developer", modifier = Modifier.padding(3.dp))
        Text(
            text = "kingdomhearts510@gmail.com",
            modifier = Modifier.padding(3.dp),
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.subtitle1
        )
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(
        modifier = Modifier
            .size(150.dp)
            .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, LightGray),
        elevation = 4.dp,
        color = MaterialTheme.colors.onSurface.copy(alpha = 0.5f)

    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_image),
            contentDescription = "profile image",
            modifier = Modifier.size(135.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

// @Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BizCardTheme {
        CreateBizCard()
    }
}