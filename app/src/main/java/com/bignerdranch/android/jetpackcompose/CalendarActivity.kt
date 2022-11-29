package com.bignerdranch.android.jetpackcompose

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.widget.CalendarView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.bignerdranch.android.jetpackcompose.ui.theme.*

class CalendarActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitle(Title("Календарь"))
                    MyCalendar()
                    MyBottomPanel()
                }
            }
        }
    }
}

@SuppressLint("ResourceType")
@Composable
fun MyCalendar(){
    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(70.dp))
        Row(modifier = Modifier
            .padding(6.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center){

            AndroidView(factory = {CalendarView((it))},
                modifier = Modifier
                    .wrapContentWidth()
                    .padding(10.dp)
                    .height(410.dp)
                    .width(400.dp),
                update = {
                    it.setOnDateChangeListener { calendarView, year, month, day ->
                        calendarView.dateTextAppearance = R.style.CalenderViewDateCustomText
                    }
                },
            )
        }
    }
}

@Composable
fun MyBottomPanel(){
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

        IconButton(onClick = {  },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.calendar),
                    contentDescription = "calendar",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Green)
                Text(text = "Calendar", color = Green, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
        Spacer(modifier = Modifier.width(16.dp))

        IconButton(onClick = { context.startActivity(Intent(context, SettingsActivity::class.java)) },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.settings),
                    contentDescription = "settings",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Red)
                Text(text = "Settings", color = Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(6.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
    JetpackComposeTheme {

    }
}