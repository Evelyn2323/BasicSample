// La carpeta "com.example.android.databinding.basicsample" contiene clases relacionadas con el ejemplo de enlace de datos.
// ObservableFieldProfile es una clase de datos utilizada como variable de diseño.
// Representa un perfil con propiedades estáticas (nombre y apellido) y una propiedad observable (likes).

package com.example.android.databinding.basicsample.data

import androidx.databinding.ObservableInt


data class ObservableFieldProfile(
        val name: String,
        val lastName: String,
        val likes: ObservableInt
)
