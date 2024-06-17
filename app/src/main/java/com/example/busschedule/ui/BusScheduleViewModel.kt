/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.busschedule.ScheduleApplication
import com.example.busschedule.data.BusSchedule
import com.example.busschedule.data.BusSchedulesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class BusScheduleViewModel(private val busSchedulesRepository: BusSchedulesRepository): ViewModel() {

    // Get example bus schedule
    fun getFullSchedule(): Flow<List<BusSchedule>> =
        busSchedulesRepository.getAllSchedulesStream()

    // Get example bus schedule by stop
    fun getScheduleFor(stopName: String): Flow<List<BusSchedule>> =
        busSchedulesRepository.getScheduleStream(stopName)

    companion object {
        val factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]
                        as ScheduleApplication)
                val busSchedulesRepository = application.container.busSchedulesRepository
                BusScheduleViewModel(busSchedulesRepository = busSchedulesRepository)
            }
        }
    }
}
