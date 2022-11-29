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
import com.bignerdranch.android.jetpackcompose.ui.theme.Green
import com.bignerdranch.android.jetpackcompose.ui.theme.JetpackComposeTheme
import com.bignerdranch.android.jetpackcompose.ui.theme.LimeGreen
import com.bignerdranch.android.jetpackcompose.ui.theme.White

class AddTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitleBackTask(TitleBackTask("Добавить задачу"))
                    AddTask()
                }
            }
        }
    }
}

data class TitleBackTask(val title: String)

@Composable
fun MyTitleBackTask(str: TitleBackTask) {
    val context = LocalContext.current
    Column (modifier = Modifier.padding(20.dp)) {
        Text(text = str.title, fontSize = 28.sp, color = White, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.width(8.dp))

    Row(modifier = Modifier.padding(all = 12.dp), horizontalArrangement = Arrangement.End) {
        IconButton(onClick = { context.startActivity(Intent(context, MainActivity::class.java)) }){
            Image(painter = painterResource(R.drawable.back_button),
                contentDescription = "Back button",
                modifier = Modifier.size(55.dp, 55.dp)
            )
        }
    }
}

@Composable
fun AddTask(){
    val input = remember { mutableStateOf("Заголовок задачи") }
    val inputTime = remember { mutableStateOf("16:30") }
    val inputCal = remember { mutableStateOf("14.01.2021") }
    val inputTask = remember { mutableStateOf("14.01.2021") }

    Column(horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Top) {
        Spacer(modifier = Modifier.height(128.dp))
        TextField(value = input.value, onValueChange = { input.value = it},
            modifier = Modifier
                .width(370.dp)
                .height(50.dp)
                .background(color = White, shape = RoundedCornerShape(5.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.Center) {
            TextField(value = inputTime.value, onValueChange = { inputTime.value = it },
                modifier = Modifier
                    .width(176.dp)
                    .height(50.dp)
                    .background(color = White, shape = RoundedCornerShape(5.dp)),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.alarm),
                        contentDescription = "alarm"
                    )
                }
            )
            Spacer(modifier = Modifier.width(16.dp))
            TextField(value = inputCal.value, onValueChange = { inputCal.value = it },
                modifier = Modifier
                    .width(176.dp)
                    .height(50.dp)
                    .background(color = White, shape = RoundedCornerShape(5.dp)),
                leadingIcon = {
                    Icon(
                        painter = painterResource(R.drawable.calendar),
                        contentDescription = "alarm"
                    )
                }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column() {
            TextField(value = inputTask.value, onValueChange = { inputTask.value = it},
                modifier = Modifier
                    .width(370.dp)
                    .height(150.dp)
                    .background(color = White, shape = RoundedCornerShape(5.dp))
            )
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
            Text(text = "Записать задачу", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(24.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
    JetpackComposeTheme {
    }
}