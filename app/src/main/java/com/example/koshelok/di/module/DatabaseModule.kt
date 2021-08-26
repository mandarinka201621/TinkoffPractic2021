package com.example.koshelok.di.module

import android.content.Context
import androidx.room.Room
import com.example.koshelok.data.db.KoshelokDatabase
import com.example.koshelok.di.AppScope
import dagger.Module
import dagger.Provides

@Module
class DatabaseModule {

    @AppScope
    @Provides
    fun providesRoomDatabase(context: Context): KoshelokDatabase {
        return Room.databaseBuilder(
            context,
            KoshelokDatabase::class.java,
            "koshelok.db"
        ).build()
    }
}
