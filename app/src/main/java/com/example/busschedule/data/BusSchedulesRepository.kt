package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

interface BusSchedulesRepository {

    fun getAllSchedulesStream(): Flow<List<BusSchedule>>

    fun getScheduleStream(id: Int): Flow<BusSchedule?>
}