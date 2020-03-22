package hu.horvathnorbert.kotlin_hw.mapper

import hu.horvathnorbert.kotlin_hw.dto.message.MessageCreateDto
import hu.horvathnorbert.kotlin_hw.dto.message.MessageDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.Message
import hu.horvathnorbert.kotlin_hw.entity.User
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import org.springframework.context.annotation.Bean
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.util.*
import javax.persistence.EntityNotFoundException

fun Message.mapToMessageDetailDto(): MessageDetailsDto {
    return MessageDetailsDto(
            this.fromUser.mapToUserDetailsDto(),
            this.toUser.mapToUserDetailsDto(),
            this.message,
            this.date
    )
}

fun MessageCreateDto.mapToMessage(fromUser: User, toUser: User): Message {
    return Message(fromUser, toUser, this.message, System.currentTimeMillis())
}