package hu.horvathnorbert.kotlin_hw.service

import hu.horvathnorbert.kotlin_hw.dto.user.UserCreateDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserUpdateDto
import hu.horvathnorbert.kotlin_hw.mapper.mapToUser
import hu.horvathnorbert.kotlin_hw.mapper.mapToUserDetailsDto
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUser() : List<UserDetailsDto> {
        return userRepository.findAll().map { it.mapToUserDetailsDto() }
    }

    fun createUser(userCreateDto: UserCreateDto): UserDetailsDto {
        return userRepository.save(userCreateDto.mapToUser()).mapToUserDetailsDto()
    }

    fun getUser(username: String): UserDetailsDto {
        return userRepository.findByUsername(username).mapToUserDetailsDto()
    }

    fun modifyUser(userUpdateDto: UserUpdateDto): UserDetailsDto {
        val user = userRepository.findByUsername(userUpdateDto.username)
        user.name = userUpdateDto.name

        return userRepository.save(user).mapToUserDetailsDto()
    }
}