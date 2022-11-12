package com.chirikualii.materidb.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import androidx.room.migration.Migration
import com.chirikualii.materidb.data.local.dao.MovieDao
import com.chirikualii.materidb.data.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDb : RoomDatabase() {

    abstract fun movieDao() : MovieDao
}