package com.yoriz.yoritallybook.sql

import androidx.room.Database
import androidx.room.RoomDatabase
import com.yoriz.yoritallybook.bean.BillHistory
import com.yoriz.yoritallybook.bean.BillHistoryDao
import com.yoriz.yoritallybook.bean.ConsumptionType
import com.yoriz.yoritallybook.bean.ConsumptionTypeDao

/**
 * Created by yoriz
 * on 2020/6/9 5:14 PM.
 */
@Database(
    entities = [BillHistory::class, ConsumptionType::class],
    version = 1,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {
    companion object {
        const val DatabaseName = "yori_db"
    }

    abstract fun billHistoryDao(): BillHistoryDao
    abstract fun consumptionTypeDao(): ConsumptionTypeDao
}