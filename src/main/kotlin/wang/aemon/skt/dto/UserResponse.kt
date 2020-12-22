package wang.aemon.skt.dto

data class UserResponse(
    val id: Long,
    val username: String,
    var status: Int,
    val createAt: Long
)