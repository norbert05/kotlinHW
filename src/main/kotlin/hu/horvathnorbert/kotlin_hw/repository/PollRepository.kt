package hu.horvathnorbert.kotlin_hw.repository

import hu.horvathnorbert.kotlin_hw.entity.Poll
import org.springframework.data.jpa.repository.JpaRepository

interface PollRepository: JpaRepository<Poll, String> {
    fun findByName(name: String): Poll?
}