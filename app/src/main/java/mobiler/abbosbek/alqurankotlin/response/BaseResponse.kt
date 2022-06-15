package mobiler.abbosbek.alqurankotlin.response

data class BaseResponse<T>(
    val data : T,
    val code : Int
)
