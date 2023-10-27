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

package com.example.android.databinding.basicsample.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.databinding.basicsample.R
import com.example.android.databinding.basicsample.data.ProfileLiveDataViewModel
import com.example.android.databinding.basicsample.databinding.ViewmodelProfileBinding

// ViewModelActivity es una actividad que utiliza un ViewModel para mantener los datos y responder a las acciones del usuario.
// El diseño utiliza BindingAdapters en lugar de expresiones para una funcionalidad más potente.
// * @see com.example.android.databinding.basicsample.util.BindingAdapters
class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Obtener ViewModel a través de ViewModelProviders
        val viewModel by viewModels<ProfileLiveDataViewModel>()

        // Alternativamente, se puede usar un ViewModel con campos observables y propiedades @Bindable:
        // val viewModel ViewModelProviders.of(this).get(ProfileObservableViewModel::class.java)

        // Obtener el enlace
        val binding: ViewmodelProfileBinding =
                DataBindingUtil.setContentView(this, R.layout.viewmodel_profile)

        // Vincular el diseño con el ViewModel
        binding.viewmodel = viewModel

        // LiveData necesita el propietario del ciclo de vida
        binding.lifecycleOwner = this
    }
}
