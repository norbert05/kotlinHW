package hu.horvathnorbert.kotlin_hw.mapper

import hu.horvathnorbert.kotlin_hw.dto.user.UserCreateDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.User

fun User.mapToUserDetailsDto(): UserDetailsDto {
    return UserDetailsDto(name = this.name, username = this.username)
}

fun UserCreateDto.mapToUser(): User {
    return User(username = this.userName, password = this.password, name = this.name)
}