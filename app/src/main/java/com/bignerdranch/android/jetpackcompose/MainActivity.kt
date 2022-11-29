package com.bignerdranch.android.jetpackcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import com.bignerdranch.android.jetpackcompose.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Green
                ) {
                    MyTitle(Title("Список дел"))
                    MyRectangle(Rectangle("Вечерний поход в кино",
                        "Идем в кино с коллегами!"),
                        RectangleText("10.02.2021", "19:40"))

                    MyRectangle(Rectangle("Забрать заказ Ozon",
                        "Пункт выдачи на ул. Ленина, 103"),
                        RectangleText("10.02.2021", "19:40"))

                    MyRectangle(Rectangle("Запись в автосервис",
                        "Сдать автомобиль в автосервис на ул.\n" +
                                "Бисертская, д. 14. Замена масла"),
                        RectangleText("10.02.2021", "19:40"))

                    MyButton()
                }
            }
        }
    }
}

data class Title(val title: String)
data class Rectangle(val header:String, val text:String)
data class RectangleText(val date:String, val time:String)

@Composable
fun MyTitle(str: Title) {
    val context = LocalContext.current
    Column (modifier = Modifier.padding(20.dp)) {
        Text(text = str.title, fontSize = 28.sp, color = White, fontWeight = FontWeight.Bold)
    }
    Spacer(modifier = Modifier.width(8.dp))

    Row(modifier = Modifier.padding(all = 12.dp), horizontalArrangement = Arrangement.End) {
        IconButton(onClick = { context.startActivity(Intent(context, ProfileActivity::class.java)) }){
            Image(painter = painterResource(R.drawable.avatar),
                contentDescription = "Profile picture",
                modifier = Modifier.size(62.dp, 62.dp))
        }
    }
}

@Composable
fun MyRectangle(rec:Rectangle, recT:RectangleText){
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(130.dp))
        Card(
            shape = Shapes.large,
            backgroundColor = Yellow,
            modifier = Modifier
                .width(390.dp)
                .padding(10.dp)
                .clickable { context.startActivity(Intent(context, EditTaskActivity::class.java)) },
        ){
            Row {
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Вечерний поход в кино", color = White, fontSize = 18.sp)
                    Text(text = "Идем в кино с коллегами!", color = Gray, fontSize = 13.sp)
                }
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.End) {
                    Text(text = "10.02.2021", color = Gray, fontSize = 13.sp)
                    Text(text = "19:40", color = Gray, fontSize = 13.sp)
                }
            }
        }
        Card(
            shape = Shapes.large,
            backgroundColor = Yellow,
            modifier = Modifier
                .width(390.dp)
                .padding(10.dp)
                .clickable { context.startActivity(Intent(context, EditTaskActivity::class.java)) },
        ){
            Row {
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Забрать заказ Ozon", color = White, fontSize = 18.sp)
                    Text(text = "Пункт выдачи на ул. Ленина, 103", color = Gray, fontSize = 13.sp)
                }
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.End) {
                    Text(text = "10.02.2021", color = Gray, fontSize = 13.sp)
                    Text(text = "19:40", color = Gray, fontSize = 13.sp)
                }
            }
        }
        Card(
            shape = Shapes.large,
            backgroundColor = Yellow,
            modifier = Modifier
                .width(390.dp)
                .padding(10.dp)
                .clickable { context.startActivity(Intent(context, EditTaskActivity::class.java)) },
        ){
            Row {
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.Start) {
                    Text(text = "Запись в автосервис", color = White, fontSize = 18.sp)
                    Text(text = "Сдать автомобиль в автосервис на ул.\n" +
                            "Бисертская, д. 14. Замена масла", color = Gray, fontSize = 13.sp)
                }
                Column(modifier = Modifier.padding(all = 18.dp),
                    horizontalAlignment = Alignment.End) {
                    Text(text = "10.02.2021", color = Gray, fontSize = 13.sp)
                    Text(text = "19:40", color = Gray, fontSize = 13.sp)
                }
            }
        }
    }
}

@Composable
fun MyButton(){
    val context = LocalContext.current

    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { context.startActivity(Intent(context, AddTaskActivity::class.java)) },
            Modifier
                .width(390.dp)
                .height(70.dp)
                .padding(8.dp),
            shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.textButtonColors(backgroundColor = LimeGreen, contentColor = White)
        ){
            Text(text = "Добавить задачу", fontSize = 18.sp)
        }
        Spacer(modifier = Modifier.height(100.dp))
    }

    Column(verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(modifier = Modifier
            .width(370.dp)
            .height(80.dp),
            painter = painterResource(R.drawable.menurectangle),
            contentDescription = "menu_rect",
        )
    }
    Row (verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.Center) {
        IconButton(onClick = { },
            Modifier.size(55.dp, 70.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Icon(painter = painterResource(R.drawable.list),
                    contentDescription = "list",
                    Modifier
                        .size(36.dp, 36.dp),
                    tint = Green)
                Text(text = "List", color = Green, fontSize = 14.sp)
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
fun DefaultPreview() {
    JetpackComposeTheme {
        MyTitle(
            str = Title("Список дел")
        )
    }
}