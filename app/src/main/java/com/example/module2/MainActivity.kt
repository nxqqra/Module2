package com.example.module2

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextIndent
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

// =======================================================================
// ОСНОВНАЯ АКТИВНОСТЬ
// =======================================================================
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Приложение запускает исправленную корзину из Задания 10
            ShoppingCartScreen()
        }
    }
}

// =======================================================================
// ЗАДАНИЕ 1: Функция приветствия с обработкой null
// =======================================================================
@Composable
fun Hello(name: String?, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (!name.isNullOrBlank()) "Привет, $name!" else "Имя не задано",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )
    }
}

// =======================================================================
// ЗАДАНИЕ 2: Три предпросмотра с системным UI
// =======================================================================
@Preview(
    name = "portrait",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=portrait"
)
@Composable
fun HelloPreviewPortrait() {
    Hello(name = "Марк")
}

@Preview(
    name = "landscape",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=411dp,height=891dp,orientation=landscape"
)
@Composable
fun HelloPreviewLandscape() {
    Hello(name = null)
}

@Preview(
    name = "round",
    showBackground = true,
    showSystemUi = true,
    device = "spec:width=200dp,height=200dp,isRound=true"
)
@Composable
fun HelloPreviewRound() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.Yellow
    ) {
        Hello(name = "Марк")
    }
}

// =======================================================================
// ЗАДАНИЕ 3: Стилизация текста из strings.xml
// =======================================================================
@Preview(showBackground = true)
@Composable
fun Task3Preview() {
    val textFromRes = stringResource(id = R.string.compose_description)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Вариант 1
        Text(
            text = textFromRes,
            color = Color(0xFF2E7D32),
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        // Вариант 2
        Text(
            text = textFromRes,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )

        // Вариант 3
        Text(
            text = textFromRes,
            fontSize = 24.sp,
            color = Color.Black,
            style = TextStyle(
                textIndent = TextIndent(firstLine = 48.sp),
                textDecoration = TextDecoration.Underline
            ),
            modifier = Modifier
                .background(Color(0xFF81C784))
                .fillMaxWidth()
        )
    }
}

// =======================================================================
// ЗАДАНИЕ 4: Стилизованная кнопка
// =======================================================================
@Preview(name = "ButtonPreview - portrait", showBackground = true, showSystemUi = true)
@Composable
fun CustomButtonPreview() {
    Button(
        onClick = { },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(2.dp, Color.Gray),
        elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
    ) {
        Text(text = "Нажми на меня", color = Color.Black)
    }
}

// =======================================================================
// ЗАДАНИЕ 5: Контейнер 100.dp с инициалами
// =======================================================================
@Preview(name = "Task1Preview - portrait", showBackground = true, showSystemUi = true)
@Composable
fun Task5Preview() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .background(Color(0xFFFF5722), shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "МГ", color = Color.Black)
            }
        }
    }
}

// =======================================================================
// ЗАДАНИЕ 6: Векторные круги в Box (240x120 dp)
// =======================================================================
@Preview(name = "Task 6 - Top Right", showBackground = true)
@Composable
fun Task6Part1Preview() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Black)
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Circle",
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
}

@Preview(name = "Task 6 - Centered Purple", showBackground = true)
@Composable
fun Task6Part2Preview() {
    Box(
        modifier = Modifier
            .size(width = 240.dp, height = 120.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.circle),
            contentDescription = "Purple Circle",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            colorFilter = ColorFilter.tint(Color(0xFF800080))
        )
    }
}

// =======================================================================
// ЗАДАНИЕ 7: Контакты (Column и Row)
// =======================================================================
@Preview(name = "ContactColumnPreview - portrait", showBackground = true, showSystemUi = true)
@Composable
fun ContactColumnPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Имя: Евгений")
        Text("Отчество: Андреевич")
        Text("Фамилия: Лукашин")
        Text("Мобильный телефон: +7 495 495 95 95")
        Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12")
    }
}

@Composable
fun ContactCard(name: String, patronymic: String, surname: String, phone: String, address: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(12.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Имя: $name")
            Text("Отчество: $patronymic")
            Text("Фамилия: $surname")
            Text("Мобильный телефон: $phone")
            Text("Адрес: $address", textAlign = TextAlign.Center)
        }
    }
}

@Preview(name = "ListPreview - portrait", showBackground = true, showSystemUi = true)
@Composable
fun ContactListPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        ContactCard("Евгений", "Андреевич", "Лукашин", "+7 495 495 95 95", "г. Москва, 3-я улица Строителей, д. 25, кв. 12")
        ContactCard("Василий", "Егорович", "Кузякин", "---", "Ивановская область, дер. Крутово, д. 4")
        ContactCard("Людмила", "Прокофьевна", "Калугина", "+7 495 788 78 78", "Москва, Большая Никитская, д. 43, кв. 290")
    }
}

@Preview(name = "ContactRowPreview - portrait", showBackground = true, showSystemUi = true)
@Composable
fun ContactRowPreview() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray)
            .padding(12.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Имя: Евгений")
                Text("Отчество: Андреевич")
                Text("Фамилия: Лукашин")
                Text("Мобильный телефон: +7 495 495 95 95")
                Text("Адрес: г. Москва, 3-я улица Строителей, д. 25, кв. 12", textAlign = TextAlign.Center)
            }
            // Произвольная иконка справа
            Text(text = "⭐", fontSize = 28.sp)
        }
    }
}

// =======================================================================
// ЗАДАНИЕ 8: Трекер воды
// =======================================================================
@Composable
fun WaterTracker() {
    var waterCount by remember { mutableIntStateOf(0) }
    var streakDays by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Трекер воды",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF415F91)
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "$waterCount мл",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF565F71)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Дней подряд (>=1500 мл): $streakDays",
            fontSize = 18.sp,
            color = Color.DarkGray
        )
        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = { waterCount += 250 },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF415F91))
        ) {
            Text(text = "+250 мл", fontSize = 18.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = {
                if (waterCount >= 1500) {
                    streakDays += 1
                } else {
                    streakDays = 0
                }
                waterCount = 0
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF757575))
        ) {
            Text(text = "Завершить день", fontSize = 16.sp, color = Color.White)
        }
    }
}

@Preview(name = "Task 8 - Water Tracker", showBackground = true, showSystemUi = true)
@Composable
fun WaterTrackerPreview() {
    WaterTracker()
}

// =======================================================================
// ЗАДАНИЕ 10: Исправленная корзина
// =======================================================================
data class Product(
    val id: Int,
    val name: String,
    val price: Int
)

@Composable
fun ShoppingCartScreen() {
    val context = LocalContext.current

    var products by remember {
        mutableStateOf(
            listOf(
                Product(0, "Товар #1", 100),
                Product(1, "Товар #2", 150),
                Product(2, "Товар #3", 56)
            )
        )
    }

    val totalSum = products.sumOf { it.price }
    val productSize = products.size

    Column(modifier = Modifier.padding(16.dp)) {
        for (product in products) {
            Text(text = "${product.name} - ${product.price} рублей")
        }

        Spacer(modifier = Modifier.height(10.dp))
        Text(text = "Товаров на сумму: $totalSum рублей")
        Spacer(modifier = Modifier.height(10.dp))

        Button(
            onClick = {
                val newProducts = products + Product(
                    id = products.size,
                    name = "Товар #${products.size + 1}",
                    price = Random.nextInt(50, 150)
                )
                products = newProducts

                if (newProducts.sumOf { it.price } > 500) {
                    Toast.makeText(context, "Доставка бесплатная!", Toast.LENGTH_SHORT).show()
                }
            }
        ) {
            Text(text = "Добавить товар")
        }

        if (productSize > 0) {
            Spacer(modifier = Modifier.height(6.dp))
            Button(
                onClick = {
                    products = products.dropLast(1)
                }
            ) {
                Text(text = "Удалить товар")
            }
        }
    }
}

@Preview(name = "Task 10 - Shopping Cart", showBackground = true, showSystemUi = true)
@Composable
fun ShoppingCartPreview() {
    ShoppingCartScreen()
}