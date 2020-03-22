package hu.horvathnorbert.kotlin_hw.service

import hu.horvathnorbert.kotlin_hw.controller.UserController
import hu.horvathnorbert.kotlin_hw.dto.message.MessageCreateDto
import hu.horvathnorbert.kotlin_hw.dto.message.MessageDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.Message
import hu.horvathnorbert.kotlin_hw.mapper.mapToMessage
import hu.horvathnorbert.kotlin_hw.mapper.mapToMessageDetailDto
import hu.horvathnorbert.kotlin_hw.repository.MessageRepository
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.persistence.EntityNotFoundException

@Service
class MessageService(private val messageRepository: MessageRepository,
                     private val userRepository: UserRepository) {

    val log = LoggerFactory.getLogger(MessageService::class.java)

    fun getAllMessage(): List<MessageDetailsDto> {
        return messageRepository.findAll().map { it.mapToMessageDetailDto() }
    }

    fun addMessage(messageCreateDto: MessageCreateDto): MessageDetailsDto {
        val fromUser = userRepository.findByUsername(messageCreateDto.fromUsername) ?:
        throw EntityNotFoundException("Entity with username ${messageCreateDto.fromUsername} not found!")

        val toUser = userRepository.findByUsername(messageCreateDto.toUsername) ?:
        throw EntityNotFoundException("Entity with username ${messageCreateDto.toUsername} not found!")

        return messageRepository.save(messageCreateDto.mapToMessage(fromUser, toUser)).mapToMessageDetailDto()
    }
}