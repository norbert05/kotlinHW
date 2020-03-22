package hu.horvathnorbert.kotlin_hw.repository

import hu.horvathnorbert.kotlin_hw.entity.Message
import hu.horvathnorbert.kotlin_hw.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MessageRepository: JpaRepository<Message, String> {

    @Query("SELECT m FROM Message m " +
            "WHERE (m.fromUser.username = :username " +
            "OR m.toUser.username = :username) " +
            "AND " +
            "(m.fromUser.username = :otherUser " +
            "OR m.toUser.username = :otherUser) " +
            "ORDER BY m.date ASC")
    fun getConversation(username: String, otherUser: String): List<Message>
}