/*
 * Copyright (C) 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.databinding.basicsample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.example.android.databinding.basicsample.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Este es un archivo de prueba instrumental de Android que se ejecuta en un dispositivo o emulador.
 * Contiene pruebas para verificar la funcionalidad de la interfaz de usuario de la actividad principal.
 */
@RunWith(AndroidJUnit4::class)
class BasicUsageTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun observableFieldsActivity_likes() {
        // Abre la actividad haciendo clic en el botón.        onView(withId(R.id.observable_fields_activity_button)).perform(click())
        onView(withId(R.id.observable_fields_activity_button)).perform(click())

        // Haga clic en "Like" 5 veces
        repeat(5) {
            onView(withId(R.id.like_button)).perform(click())
        }

        // Verifica que el número de "Me gusta" se muestre como "5".
        onView(withId(R.id.likes)).check(matches(withText("5")))
    }

    @Test
    fun viewmodelActivity_likes() {
        // Abre la actividad haciendo clic en el botón.
        onView(withId(R.id.viewmodel_activity_button)).perform(click())

        // Realiza cinco "Me gusta".
        repeat(5) {
            onView(withId(R.id.like_button)).perform(click())
        }

        // Verifica que el número de "Me gusta" se muestre como "5" y que aparezca la barra de progreso.
        onView(withId(R.id.likes)).check(matches(withText("5")))
        onView(withId(R.id.progressBar)).check(matches(isDisplayed()))
    }
}
