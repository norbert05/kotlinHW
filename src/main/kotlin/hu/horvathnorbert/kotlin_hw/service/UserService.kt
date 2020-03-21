package hu.horvathnorbert.kotlin_hw.service

import hu.horvathnorbert.kotlin_hw.dto.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.mapper.mapToUserDetailsDto
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUser() : List<UserDetailsDto> {
        return userRepository.findAll().map { it.mapToUserDetailsDto() }
    }
}