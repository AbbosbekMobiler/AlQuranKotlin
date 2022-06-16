package mobiler.abbosbek.alqurankotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel
import mobiler.abbosbek.alqurankotlin.model.SurahModel

@Database(entities = [SurahModel::class,SurahDetailModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getSurahDao() : SurahDao
    abstract fun getSurahDetailDao() : SurahDetailDao

    companion object{
        var INSTANCE : AppDatabase ?= null

        fun initDatabase(context: Context){
            if (INSTANCE == null){
                synchronized(AppDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java,"quran_db").build()
                }
            }
        }

        fun getDatabase() : AppDatabase{
            return INSTANCE!!
        }
    }
}