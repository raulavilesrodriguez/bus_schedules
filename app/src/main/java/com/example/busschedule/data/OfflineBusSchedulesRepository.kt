package com.example.busschedule.data

import kotlinx.coroutines.flow.Flow

class OfflineBusSchedulesRepository(private val busScheduleDao: BusScheduleDao) : BusSchedulesRepository {
    override fun getAllSchedulesStream(): Flow<List<BusSchedule>> = busScheduleDao.getAllSchedules()

    override fun getScheduleStream(id: Int): Flow<BusSchedule?> = busScheduleDao.getSchedule(id)

}