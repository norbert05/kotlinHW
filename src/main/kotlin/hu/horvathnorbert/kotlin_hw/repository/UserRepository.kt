package hu.horvathnorbert.kotlin_hw.repository

import hu.horvathnorbert.kotlin_hw.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository: JpaRepository<User, String> {

    fun findByUsername(username: String): User
}