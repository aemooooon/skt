package wang.aemon.skt.service

import org.springframework.stereotype.Service
import wang.aemon.skt.dao.UserDao
import wang.aemon.skt.domain.User
import wang.aemon.skt.dto.UserAdd

@Service
class UserServiceImpl(
    private val userDao: UserDao
) : UserService {
    override fun findById(id: Long): User? {
        return this.userDao.selectById(id)
    }

    override fun findAll(): List<User>? {
        return this.userDao.selectList(null)
    }

    override fun save(user: User): Int {
        return this.userDao.insert(user)
    }

    override fun updateById(user: User): Int {
        return this.userDao.updateById(user)
    }

    override fun deleteById(id: Long): Int {
        return this.userDao.deleteById(id)
    }
}