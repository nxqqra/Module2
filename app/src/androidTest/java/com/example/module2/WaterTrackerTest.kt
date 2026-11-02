package com.example.module2

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()

    @Test
    fun testWaterTrackerFullFlow() {
        // Загружаем интерфейс трекера
        composeTestRule.setContent {
            WaterTracker()
        }

        // 1. Проверка наличия и работы кнопки добавления жидкости
        val addButton = composeTestRule.onNodeWithText("+250 мл")
        addButton.assertExists()
        addButton.performClick()
        composeTestRule.onNodeWithText("250 мл").assertExists()

        // 2. Доводим счётчик до 1500 мл (кликаем ещё 5 раз)
        repeat(5) {
            addButton.performClick()
        }
        composeTestRule.onNodeWithText("1500 мл").assertExists()

        // 3. Проверка кнопки "Завершить день" и подсчёта дней подряд
        val finishButton = composeTestRule.onNodeWithText("Завершить день")
        finishButton.assertExists()
        finishButton.performClick()

        // После нажатия: объём сброшен на 0 мл, дни увеличились до 1
        composeTestRule.onNodeWithText("0 мл").assertExists()
        composeTestRule.onNodeWithText("Дней подряд (>=1500 мл): 1").assertExists()
    }
}