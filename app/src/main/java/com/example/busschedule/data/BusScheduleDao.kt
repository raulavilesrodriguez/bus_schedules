package com.example.busschedule.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BusScheduleDao {

    @Query("SELECT * from schedules ORDER BY arrivalTimeInMillis ASC")
    fun getAllSchedules(): Flow<List<BusSchedule>>

    @Query("SELECT * from schedules WHERE id = :id")
    fun getSchedule(id: Int): Flow<BusSchedule>

}