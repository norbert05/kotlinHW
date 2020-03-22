package hu.horvathnorbert.kotlin_hw.controller

import hu.horvathnorbert.kotlin_hw.dto.message.MessageCreateDto
import hu.horvathnorbert.kotlin_hw.dto.message.MessageDetailsDto
import hu.horvathnorbert.kotlin_hw.service.MessageService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/message")
class MessageController(private val messageService: MessageService) {

    val log = LoggerFactory.getLogger(UserController::class.java)

    @GetMapping("/list")
    fun getAllMessage(): List<MessageDetailsDto> {
        return messageService.getAllMessage()
    }

    @PostMapping
    fun addMessage(@RequestBody messageCreateDto: MessageCreateDto): MessageDetailsDto {
        return messageService.addMessage(messageCreateDto)
    }
}