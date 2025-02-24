package com.example.composetest

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.composetest.nav.AppNavigation
import com.example.composetest.ui.HomeScreen
import com.example.composetest.ui.theme.ComposeTestTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTestTheme {
                val navController = rememberNavController()

                AppNavigation(navController = navController)
//                Button(onClick = {
//                    val intent = Intent()
//                    intent.setComponent(
//                        ComponentName(
//                            "com.example.arvr",
//                            "com.example.arvr.MainActivity"
//                        )
//                    )
//                    startActivity(intent)
//                }) {
//                    Text(text = "start arvr")
//                }
            }

//                Image(painter = painterResource(id = R.drawable.img), contentDescription =null,
//                    modifier= Modifier
//                        .fillMaxSize(), contentScale = ContentScale.FillBounds )


       /*         var name by remember {
                    mutableStateOf("")
                }
                var names by remember {
                    mutableStateOf(listOf<String>())
                }
                // A surface container using the 'background' color from the theme
                Column(modifier= Modifier
                    .fillMaxSize()
                    .padding(16.dp)){
                    Row(modifier=Modifier.fillMaxWidth()){
                        OutlinedTextField(
                            value=name,
                            onValueChange = {text->
                                name=text
                            },
                            modifier= Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Button(onClick = {
                            if(name.isNotBlank()) {
                                names = names + name
                                name=""
                            }
                        }
                        ) {
//                            Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription =null )
//                            Icon(Icons.Default.Add, contentDescription =null )
                            Text(text = "add")
                        }
                    }
                    LazyColumn{
                        items(names){currentName->
                            Text(text=currentName,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                            Divider()

                        }
                    }
                }
            }*/
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTestTheme {
        var navController=rememberNavController()
        HomeScreen(navController)
    }
}