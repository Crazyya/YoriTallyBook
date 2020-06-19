package com.yoriz.yoritallybook

import android.app.Application
import androidx.room.Room
import com.yoriz.yoritallybook.sql.AppRoomDatabase

/**
 * Created by yoriz
 * on 2020/6/9 5:17 PM.
 */
class MainApplication : Application() {
    companion object {
        private var instance: MainApplication? = null
        private var roomDB: AppRoomDatabase? = null

        fun instance() = instance!!
        fun db() = roomDB!!
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        roomDB =
            Room.databaseBuilder(this, AppRoomDatabase::class.java, AppRoomDatabase.DatabaseName)
                .build()
    }
}