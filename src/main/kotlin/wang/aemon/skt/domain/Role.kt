package wang.aemon.skt.domain

import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@Setter
@Getter
@NoArgsConstructor
data class Role(
    val id: Long,
    var name: String,
    var nameZh: String
)