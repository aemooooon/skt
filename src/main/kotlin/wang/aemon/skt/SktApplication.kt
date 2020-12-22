package wang.aemon.skt

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SktApplication

fun main(args: Array<String>) {
    runApplication<SktApplication>(*args)
}
