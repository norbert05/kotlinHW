package hu.horvathnorbert.kotlin_hw.dto.message

import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import java.util.*

class MessageDetailsDto(val fromUser: UserDetailsDto,
                        val toUser: UserDetailsDto,
                        val message: String,
                        val date: Long)