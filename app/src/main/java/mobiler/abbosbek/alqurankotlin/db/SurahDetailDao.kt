package mobiler.abbosbek.alqurankotlin.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mobiler.abbosbek.alqurankotlin.model.SurahDetailModel

@Dao
interface SurahDetailDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(items : List<SurahDetailModel>)

    @Query("select * from ayat")
    fun getAllAyat():List<SurahDetailModel>
}