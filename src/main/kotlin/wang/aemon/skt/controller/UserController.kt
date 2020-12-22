package wang.aemon.skt.controller

import org.springframework.web.bind.annotation.*
import wang.aemon.skt.controller.UserController.Companion.BASE_USER_URL
import wang.aemon.skt.domain.User
import wang.aemon.skt.service.UserService

@RestController
@RequestMapping(value = [BASE_USER_URL])
class UserController(
    private val userService: UserService
) {

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): User? {
        return this.userService.findById(id)
    }

    @GetMapping
    fun findAll(): List<User>? {
        return this.userService.findAll()
    }

    @PostMapping
    fun save(@RequestBody user: User): Int {
        return this.userService.save(user)
    }

    @PutMapping
    fun updateById(@RequestBody user: User): Int {
        return this.userService.updateById(user)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable id: Long): Int {
        return this.userService.deleteById(id)
    }

    companion object {
        const val BASE_USER_URL: String = "/api/v1/user"
    }
}