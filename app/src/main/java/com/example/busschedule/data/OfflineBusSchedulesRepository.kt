package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusSchedulesRepository(private val busScheduleDao: BusScheduleDao) : BusSchedulesRepository {
    override fun getAllSchedulesStream(): Flow<List<BusSchedule>> = busScheduleDao.getAllSchedules()

    override fun getScheduleStream(stopName: String): Flow<List<BusSchedule>> = busScheduleDao.getSchedule(stopName)

}