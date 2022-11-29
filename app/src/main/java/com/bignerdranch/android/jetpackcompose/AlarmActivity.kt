package com.bignerdranch.android.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcompose.ui.theme.*

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitle(Title("Будильник"))
                    MyAlarms()
                    MyButtons()
                }
            }
        }
    }
}

@Composable
fun MyAlarms(){
    val context = LocalContext.current
    val switchState = remember { mutableStateOf(false) }
    val switchState2 = remember { mutableStateOf(true) }

    Column(verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start) {
        Spacer(modifier = Modifier.height(100.dp))
        Row(horizontalArrangement = Arrangement.Start) {
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(onClick = { context.startActivity(Intent(context, EditAlarmActivity::class.java)) }) {
                Text(text = "07:30", fontSize = 58.sp,
                    fontWeight = FontWeight.Light, color = White,
                    textAlign = TextAlign.Start
                )
            }
            Spacer(modifier = Modifier.width(100.dp))

            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(18.dp)) {
                Switch(checked = switchState.value, onCheckedChange = { switchState.value = it },
                    modifier = Modifier.size(100.dp, 50.dp)
                        .background(
                            color = (if (switchState.value){
                        Color(0xFFAAF683)
                    }else {
                        Color(0xFFFF9B85)
                    }), shape = RoundedCornerShape(25.dp)),
                    colors = SwitchDefaults.colors(uncheckedThumbColor = White,
                    uncheckedTrackColor = Salmon, checkedTrackColor = LimeGreen,
                    checkedThumbColor = White)
                )
            }
        }
        Row(horizontalArrangement = Arrangement.Start) {
            Spacer(modifier = Modifier.width(10.dp))
            TextButton(onClick = { context.startActivity(Intent(context, EditAlarmActivity::class.java)) }) {
                Text(text = "08:00", fontSize = 58.sp,
                    fontWeight = FontWeight.Light , color = White,
                    textAlign = TextAlign.Start
                )
            }

            Spacer(modifier = Modifier.width(100.dp))
            Box(contentAlignment = Alignment.TopEnd, modifier = Modifier.padding(18.dp)) {
                Switch(checked = switchState2.value, onCheckedChange = { switchState2.value = it },
                    modifier = Modifier.size(100.dp, 50.dp)
                        .background(
                            color = (if (switchState2.value){
                                Color(0xFFAAF683)
                            }else {
                                Color(0xFFFF9B85)
                            }), shape = RoundedCornerShape(25.dp)),
                    colors = SwitchDefaults.colors(uncheckedThumbColor = White,
                        uncheckedTrackColor = Salmon, checkedTrackColor = LimeGreen,
                        checkedThumbColor = White)
                )
            }
        }
    }
}


@Composable
fun MyButtons(){
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Bottom, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { context.startActivity(Intent(context, CreateAlarmActivity::class.java)) },
            Modifier
                .width(390.dp)
                .height(70.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.textButtonColors(backgroundColor = LimeGreen, contentColor = White)
        ){
            Text(text = "Добавить будильник", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(100.dp))
    }

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

        IconButton(onClick = {  },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.alarm),
                    contentDescription = "alarm",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Green)
                Text(text = "Alarm", color = Green, fontSize = 14.sp)
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
fun DefaultPreview2() {
    JetpackComposeTheme {
    }
}