package wang.aemon.skt.controller

import cn.hutool.core.lang.Validator
import io.swagger.annotations.Api
import io.swagger.annotations.ApiImplicitParam
import io.swagger.annotations.ApiOperation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*
import wang.aemon.skt.controller.UserController.Companion.BASE_USER_URL
import wang.aemon.skt.domain.CodeMessage
import wang.aemon.skt.domain.CommonResponse
import wang.aemon.skt.domain.User
import wang.aemon.skt.service.UserService

@RestController
@RequestMapping(value = [BASE_USER_URL])
@Api("用户控制器模块")
class UserController(
    private val userService: UserService
) {
    var logger: Logger = LoggerFactory.getLogger(javaClass)

    @ApiOperation(value = "根据ID查找用户")
    @ApiImplicitParam(paramType = "path", name = "id", value = "用户ID", required = true)
    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): CommonResponse {
        logger.info("test log info")
        val user = this.userService.findById(id)
        return if (Validator.isNotEmpty(user)) {
            CommonResponse.success(CodeMessage.SUCCESS, user)
        } else {
            CommonResponse.fail(CodeMessage.NOTFOUND, null)
        }
    }

    @ApiOperation(value = "查找全部用户")
    @GetMapping
    fun findAll(): CommonResponse {
        val result: List<User>? = this.userService.findAll()
        return if (result!!.isNotEmpty()) {
            CommonResponse.success(CodeMessage.SUCCESS, result)
        } else {
            CommonResponse.fail(CodeMessage.FAILED, null)
        }
    }

    @ApiOperation(value = "添加用户")
    @PostMapping
    fun save(@RequestBody user: User): CommonResponse {
        val result: Int = this.userService.save(user)
        return if (result > 0) {
            CommonResponse.success("用户已添加！", null)
        } else {
            CommonResponse.fail(CodeMessage.FAILED, null)
        }
    }

    @ApiOperation(value = "根据ID修改用户")
    @PutMapping
    fun updateById(@RequestBody user: User): CommonResponse {
        val result = this.userService.updateById(user)
        return if (result > 0) {
            CommonResponse.success("修改成功！")
        } else {
            CommonResponse.fail(CodeMessage.FAILED, null)
        }
    }

    @ApiOperation(value = "根据ID删除用户")
    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): CommonResponse {
        val result = this.userService.deleteById(id)
        return if (result > 0) {
            CommonResponse.success("删除成功！")
        } else {
            CommonResponse.fail(CodeMessage.FAILED, null)
        }
    }

    companion object {
        const val BASE_USER_URL: String = "/api/v1/user"
    }
}