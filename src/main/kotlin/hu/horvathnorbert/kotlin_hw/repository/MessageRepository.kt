package hu.horvathnorbert.kotlin_hw.repository

import hu.horvathnorbert.kotlin_hw.entity.Message
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository: JpaRepository<Message, String>