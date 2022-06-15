package mobiler.abbosbek.alqurankotlin.model

import java.io.Serializable

data class SurahModel(
    val englishName: String,
    val englishNameTranslation: String,
    val name: String,
    val number: Int,
    val numberOfAyahs: Int,
    val revelationType: String
):Serializable
