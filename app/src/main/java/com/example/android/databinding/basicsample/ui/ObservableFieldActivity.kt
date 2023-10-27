package com.example.android.databinding.basicsample.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableInt
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.ObservableFieldProfile
import com.example.android.databinding.basicsample.databinding.ObservableFieldProfileBinding

// ObservableFieldActivity es una actividad que muestra datos estáticos y permite al usuario incrementar el número de "likes" haciendo clic en un botón.
// Esta actividad utiliza una clase ObservableFieldProfile para representar los datos y DataBindingUtil para inflar el diseño.
class ObservableFieldActivity : AppCompatActivity() {

    private val observableFieldProfile = ObservableFieldProfile("Ada", "Lovelace", ObservableInt(0))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ObservableFieldProfileBinding =
                DataBindingUtil.setContentView(this, R.layout.observable_field_profile)
        binding.user = observableFieldProfile
    }

    // Este método se activa mediante el atributo "android:onclick" en el diseño.
    // Contiene la lógica de negocio en la actividad, lo cual no es lo ideal. Consulte ViewModelActivity para una solución mejor.

    fun onLike(view: View) {
        observableFieldProfile.likes.set(observableFieldProfile.likes.get() + 1)
    }
}

//Este método personalizado permite la vinculación de tintes a AppCompatImageView.

/**
 * Agrega soporte para vincular tint a AppCompatImageView.
 * Ver [error] relacionado (https://b.corp.google.com/issues/152953070?pli=1)
 */
@BindingAdapter("app:tint")
fun ImageView.setImageTint(@ColorInt color: Int) {
    setColorFilter(color)
}