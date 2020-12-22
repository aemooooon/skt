package wang.aemon.skt.dao

import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select
import wang.aemon.skt.domain.User

@Mapper
interface UserDao : BaseMapper<User> {
    @Select("SELECT * FROM `user`")
    fun findAll():List<User>?
}