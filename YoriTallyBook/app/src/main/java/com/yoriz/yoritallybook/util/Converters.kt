package com.yoriz.yoritallybook.util

import androidx.room.TypeConverter
import java.sql.Date

/**
 * Created by yoriz
 * on 2020/6/9 3:34 PM.
 */
object Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(value) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.let { date.time }
    }
}