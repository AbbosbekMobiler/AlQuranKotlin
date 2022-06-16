package mobiler.abbosbek.alqurankotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mobiler.abbosbek.alqurankotlin.model.SurahModel

@Dao
interface SurahDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items : List<SurahModel>)

    @Query("select * from surahList")
    fun getAllSurah() : List<SurahModel>
}