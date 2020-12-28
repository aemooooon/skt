package wang.aemon.skt.domain

import io.swagger.annotations.ApiModel
import io.swagger.annotations.ApiModelProperty
import lombok.NoArgsConstructor
import java.io.Serializable

@NoArgsConstructor
@ApiModel(value = "用户对象", description = "用户对象")
data class User(
    @ApiModelProperty(value = "用户Id", notes = "用户Id")
    val id: Long,
    @ApiModelProperty(value = "用户名", notes = "用户Id")
    val username: String,
    @ApiModelProperty(value = "用户密码", notes = "用户Id")
    var password: String,
    @ApiModelProperty(value = "用户启用状态", notes = "用户Id")
    var enabled: Int = 0,
    @ApiModelProperty(value = "用户锁定状态", notes = "用户Id")
    var locked: Int =0,
    @ApiModelProperty(value = "创建时间", notes = "用户Id")
    val createAt: Long = System.currentTimeMillis()
) : Serializable