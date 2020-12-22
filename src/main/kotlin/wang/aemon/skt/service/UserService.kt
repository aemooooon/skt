package wang.aemon.skt.service

import wang.aemon.skt.domain.User
import wang.aemon.skt.dto.UserAdd

interface UserService {
    fun findById(id: Long): User?
    fun findAll(): List<User>?
    fun save(user: User): Int
    fun updateById(user: User): Int
    fun deleteById(id: Long): Int
}