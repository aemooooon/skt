package wang.aemon.skt.domain

import com.baomidou.mybatisplus.annotation.IdType
import com.baomidou.mybatisplus.annotation.TableId
import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import org.intellij.lang.annotations.Identifier
import java.io.Serializable

@ApiModel(value = "用户对象", description = "用户对象")
data class User(
    @ApiModelProperty(value = "用户Id", notes = "用户Id")
    val id: Long,
    @ApiModelProperty(value = "用户名", notes = "用户Id")
    val username: String,
    @ApiModelProperty(value = "用户密码", notes = "用户Id")
    var password: String,
    @ApiModelProperty(value = "用户状态", notes = "用户Id")
    var status: Int = 0,
    @ApiModelProperty(value = "创建时间", notes = "用户Id")
    val createAt: Long = System.currentTimeMillis()
) : Serializable