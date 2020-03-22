package hu.horvathnorbert.kotlin_hw.dto.message

import java.util.*

class MessageCreateDto(val fromUsername: String,
                        val toUsername: String,
                        val message: String)