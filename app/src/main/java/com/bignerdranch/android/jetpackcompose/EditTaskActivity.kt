package com.bignerdranch.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcompose.ui.theme.*

class EditTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitleBackTask(TitleBackTask("Изменить задачу"))
                    EditTask()
                }
            }
        }
    }
}

@Composable
fun EditTask(){
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
        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(
                onClick = { },
                Modifier
                    .width(370.dp)
                    .height(56.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.textButtonColors(
                    backgroundColor = Red,
                    contentColor = White
                )
            ) {
                Text(text = "Удалить задачу", fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))
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
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
    JetpackComposeTheme {
    }
}