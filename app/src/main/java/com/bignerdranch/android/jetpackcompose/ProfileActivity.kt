package com.bignerdranch.android.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitleBack(TitleBack("Профиль пользователя"))
                    AvatarPic()
                    TwoButtons(TwoButtonsClass("Войти", "Регистрация"))
                }
            }
        }
    }
}

data class TitleBack(val title: String)

@Composable
fun MyTitleBack(str: TitleBack) {
    val context = LocalContext.current
    Column (modifier = Modifier.padding(20.dp)) {
        Text(text = str.title, fontSize = 28.sp, color = White, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.width(8.dp))

    Row(modifier = Modifier.padding(all = 12.dp), horizontalArrangement = Arrangement.End) {
        IconButton(onClick = { context.startActivity(Intent(context, SettingsActivity::class.java)) }){
            Image(painter = painterResource(R.drawable.back_button),
                contentDescription = "Back button",
                modifier = Modifier.size(55.dp, 55.dp)
            )
        }
    }
}

@Composable
fun AvatarPic(){
    Column(verticalArrangement = Arrangement.Top,
    horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(140.dp))
        Image(painter = painterResource(R.drawable.avatar_big),
            contentDescription = "avatar picture",
        modifier = Modifier.size(230.dp, 230.dp))
        Spacer(modifier = Modifier.height(36.dp))
        Text(text = "Вход не выполнен", fontSize = 18.sp, color = White)
    }
}

data class TwoButtonsClass(val but1: String, val but2: String)

@Composable
fun TwoButtons(but: TwoButtonsClass)
{
    val context = LocalContext.current
    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { context.startActivity(Intent(context, LogInActivity::class.java)) },
            Modifier
                .width(390.dp)
                .height(70.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.textButtonColors(backgroundColor = LimeGreen, contentColor = White)
        ){
            Text(text = but.but1, fontSize = 18.sp)
        }
        Column(verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { context.startActivity(Intent(context, SignUpActivity::class.java)) },
                Modifier
                    .width(390.dp)
                    .height(70.dp)
                    .padding(8.dp),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.textButtonColors(backgroundColor = LimeGreen, contentColor = White)
            ){
                Text(text = but.but2, fontSize = 18.sp)
            }
            Spacer(modifier = Modifier.height(40.dp))
        }
    }


}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
    JetpackComposeTheme {

    }
}