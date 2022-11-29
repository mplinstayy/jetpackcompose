package com.bignerdranch.android.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcompose.ui.theme.*

class CreateAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitleBackAlarm(TitleBackAlarm("Добавить будильник"))
                    CreateAlarm()
                }
            }
        }
    }
}


data class TitleBackAlarm(val title: String)

@Composable
fun MyTitleBackAlarm(str: TitleBackAlarm) {
    val context = LocalContext.current
    Column (modifier = Modifier.padding(20.dp)) {
        Text(text = str.title, fontSize = 28.sp, color = White, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.width(8.dp))

    Row(modifier = Modifier.padding(all = 12.dp), horizontalArrangement = Arrangement.End) {
        IconButton(onClick = { context.startActivity(Intent(context, AlarmActivity::class.java)) }){
            Image(painter = painterResource(R.drawable.back_button),
                contentDescription = "Back button",
                modifier = Modifier.size(55.dp, 55.dp)
            )
        }
    }
}

@Composable
fun CreateAlarm(){
    val input = remember { mutableStateOf("16:30") }
    val inputCal = remember { mutableStateOf("14.01.2021") }

    Column() {
        Spacer(modifier = Modifier.height(90.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            Spacer(modifier = Modifier.width(16.dp))
            TextField(value = input.value, onValueChange = { input.value = it},
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
                    .background(color = White, shape = RoundedCornerShape(5.dp)),
                leadingIcon = { Icon(painter = painterResource(R.drawable.alarm),
                    contentDescription = "alarm")}
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextField(value = inputCal.value, onValueChange = { inputCal.value = it},
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
                    .background(color = White, shape = RoundedCornerShape(5.dp)),
                leadingIcon = { Icon(painter = painterResource(R.drawable.calendar),
                    contentDescription = "alarm")}
            )
        }
        Column() {
            val checkedState = remember { mutableStateOf(false)}
            val checkedState2 = remember { mutableStateOf(false)}
            val checkedState3 = remember { mutableStateOf(false)}
            val checkedState4 = remember { mutableStateOf(false)}
            val checkedState5 = remember { mutableStateOf(false)}
            val checkedState6 = remember { mutableStateOf(false)}
            val checkedState7 = remember { mutableStateOf(false)}

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Повторять каждый", fontSize = 18.sp, color = White,
                fontWeight = FontWeight.Light, modifier = Modifier.padding(8.dp))
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState.value,
                        onCheckedChange = {checkedState.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }

                Text(text = "Понедельник", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState2.value,
                        onCheckedChange = {checkedState2.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Вторник", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState3.value,
                        onCheckedChange = {checkedState3.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Среда", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState4.value,
                        onCheckedChange = {checkedState4.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Четверг", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState5.value,
                        onCheckedChange = {checkedState5.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Пятница", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState6.value,
                        onCheckedChange = {checkedState6.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Суббота", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
            Row() {
                Box() {
                    Spacer(modifier = Modifier.width(18.dp))
                    Image(painter = painterResource(R.drawable.checkbox_rec),
                        contentDescription = "checkbox",
                        modifier = Modifier
                            .size(64.dp, 36.dp)
                            .padding(8.dp))
                    Checkbox(checked = checkedState7.value,
                        onCheckedChange = {checkedState7.value = it},
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Yellow,
                            checkedColor = Yellow
                        ), modifier = Modifier.size(64.dp, 36.dp)
                    )
                }
                Text(text = "Воскресенье", fontSize = 18.sp, color = White,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(8.dp))
            }
        }
    }
    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(
            onClick = { },
            Modifier
                .width(370.dp)
                .height(56.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.textButtonColors(
                backgroundColor = LimeGreen,
                contentColor = White
            )
        ) {
            Text(text = "Добавить будильник", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview8() {
    JetpackComposeTheme {
    }
}