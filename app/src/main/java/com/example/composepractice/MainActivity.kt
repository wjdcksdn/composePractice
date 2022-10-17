package com.example.composepractice

import android.os.Bundle
import android.util.Log
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Scaffold(
        topBar = { TopAppBar(title = {Text("Wow this is compose")},
        backgroundColor = Color(0xFF1976D2))  },
        floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = { FloatingActionButton(onClick = {}){
            Text("X")
        } },

        ) {
//        Text(text = "Hello $name!")
        MyComposableView()
    }
}

@Composable
fun MyRowItem(){
    Log.d("TAG", "MyRowItem: ")
    // 호리젠탈 리니어 레이아웃
    Row(
        Modifier
            .padding(10.dp)
            .background(Color(0xffeaffd0))
            .fillMaxWidth(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(text = "Hello!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow))
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Hello!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "Hello!")
    }
}

@Composable
fun MyComposableView(){
    Log.d("TAG", "MyComposableView: ")

    // 버티컬 리니어 레이아웃
    Column(
        Modifier
            .background(Color.LightGray)
            .verticalScroll(rememberScrollState())
    ) {
        for(i in 0..4){
            MyRowItem()
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposePracticeTheme {
        Greeting("Android")
    }
}