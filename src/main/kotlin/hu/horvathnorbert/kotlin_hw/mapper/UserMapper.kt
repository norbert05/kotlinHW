package hu.horvathnorbert.kotlin_hw.mapper

import hu.horvathnorbert.kotlin_hw.dto.user.UserCreateDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.User
import hu.horvathnorbert.kotlin_hw.utils.md5

fun User.mapToUserDetailsDto(): UserDetailsDto {
    return UserDetailsDto(name = this.name, username = this.username)
}

fun UserCreateDto.mapToUser(): User {
    return User(username = this.userName, password = this.password.md5(), name = this.name)
}

fun List<User>.mapToDetailsDtoList() : List<UserDetailsDto> {
    return this.map { it.mapToUserDetailsDto() }
}