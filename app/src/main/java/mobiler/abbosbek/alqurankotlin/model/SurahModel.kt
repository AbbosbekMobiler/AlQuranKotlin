package mobiler.abbosbek.alqurankotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "surahList")
data class SurahModel(
    @PrimaryKey(autoGenerate = true)
    val uid : Int,
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
):Serializable
