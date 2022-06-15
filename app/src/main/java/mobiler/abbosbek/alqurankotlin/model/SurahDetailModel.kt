package mobiler.abbosbek.alqurankotlin.model

data class SurahDetailModel(
    val id : Int,
    val sura : Int,
    val aya : Int,
    val arabic_text : String,
    val translation : String
)
