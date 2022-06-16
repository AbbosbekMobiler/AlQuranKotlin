package mobiler.abbosbek.alqurankotlin.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "ayat")
data class SurahDetailModel(
    @PrimaryKey(autoGenerate = true)
    val uid : Int,
    val id : Int,
    val sura : Int,
    val aya : Int,
    val arabic_text : String,
    val translation : String
)
