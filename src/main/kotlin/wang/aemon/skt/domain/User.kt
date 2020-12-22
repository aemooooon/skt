package wang.aemon.skt.domain

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import org.intellij.lang.annotations.Identifier

data class User(
    val id: Long,
    val username: String,
    var password: String,
    var status: Int = 0,
    val createAt: Long = System.currentTimeMillis()
)