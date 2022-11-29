package com.bignerdranch.android.jetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bignerdranch.android.jetpackcompose.ui.theme.Green
import com.bignerdranch.android.jetpackcompose.ui.theme.JetpackComposeTheme
import com.bignerdranch.android.jetpackcompose.ui.theme.LimeGreen
import com.bignerdranch.android.jetpackcompose.ui.theme.White

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitleBackProf(TitleBackProf("Регистрация"))
                    SignUp()
                }
            }
        }
    }
}

@Composable
fun SignUp(){
    val input = remember { mutableStateOf("") }
    val inputPassword = remember { mutableStateOf("") }
    val inputEmail = remember { mutableStateOf("") }

    Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        TextField(value = input.value, onValueChange = { input.value = it},
            label = { Text(text = "Имя пользователя")},
            modifier = Modifier
                .width(370.dp)
                .height(50.dp)
                .background(color = White, shape = RoundedCornerShape(5.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = inputEmail.value, onValueChange = { inputEmail.value = it},
            label = { Text(text = "Адрес электронной почты")},
            modifier = Modifier
                .width(370.dp)
                .height(50.dp)
                .background(color = White, shape = RoundedCornerShape(5.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = inputPassword.value, onValueChange = { inputPassword.value = it},
            label = { Text(text = "Пароль")},
            modifier = Modifier
                .width(370.dp)
                .height(50.dp)
                .background(color = White, shape = RoundedCornerShape(5.dp)),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(16.dp))

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
                Text(text = "Регистрация", fontSize = 18.sp)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
    JetpackComposeTheme {
    }
}