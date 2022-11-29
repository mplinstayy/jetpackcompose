package com.bignerdranch.android.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcompose.ui.theme.Green
import com.bignerdranch.android.jetpackcompose.ui.theme.JetpackComposeTheme
import com.bignerdranch.android.jetpackcompose.ui.theme.Red
import com.bignerdranch.android.jetpackcompose.ui.theme.White

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitle(Title("Настройки"))
                    MySettings()
                    BottomPanel()
                }
            }
        }
    }
}

@Composable
fun MySettings(){
    Column(verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(100.dp))
        Row{
            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Профиль пользователя", fontSize = 24.sp, color = White)
            }
            Spacer(modifier = Modifier.width(70.dp))
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(R.drawable.arrow),
                    contentDescription = "arrow",
                    modifier = Modifier.size(18.dp, 18.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row{
            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Дата и время", fontSize = 24.sp, color = White)
            }
            Spacer(modifier = Modifier.width(182.dp))
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(R.drawable.arrow),
                    contentDescription = "arrow",
                    modifier = Modifier.size(18.dp, 18.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row{
            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Настройки звука", fontSize = 24.sp, color = White)
            }
            Spacer(modifier = Modifier.width(143.dp))
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(R.drawable.arrow),
                    contentDescription = "arrow",
                    modifier = Modifier.size(18.dp, 18.dp)
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))

        Row{
            Spacer(modifier = Modifier.width(15.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(text = "Проверить обновления", fontSize = 24.sp, color = White)
            }
            Spacer(modifier = Modifier.width(70.dp))
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(10.dp)) {
                Image(painter = painterResource(R.drawable.arrow),
                    contentDescription = "arrow",
                    modifier = Modifier.size(18.dp, 18.dp))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun BottomPanel(){
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Image(modifier = Modifier
            .width(370.dp)
            .height(80.dp),
            painter = painterResource(R.drawable.menurectangle),
            contentDescription = "menu_rect",
        )
    }
    Row (verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center) {
        IconButton(onClick = { context.startActivity(Intent(context, MainActivity::class.java)) },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.list),
                    contentDescription = "list",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Red)
                Text(text = "List", color = Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        IconButton(onClick = { context.startActivity(Intent(context, AlarmActivity::class.java)) },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.alarm),
                    contentDescription = "alarm",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Red)
                Text(text = "Alarm", color = Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        IconButton(onClick = { context.startActivity(Intent(context, CalendarActivity::class.java)) },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.calendar),
                    contentDescription = "calendar",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Red)
                Text(text = "Calendar", color = Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        IconButton(onClick = {  },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.settings),
                    contentDescription = "settings",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Green)
                Text(text = "Settings", color = Green, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
    JetpackComposeTheme {
       
    }
}