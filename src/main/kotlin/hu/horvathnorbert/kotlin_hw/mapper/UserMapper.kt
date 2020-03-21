package hu.horvathnorbert.kotlin_hw.mapper

import hu.horvathnorbert.kotlin_hw.dto.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.User

fun User.mapToUserDetailsDto(): UserDetailsDto {
    return UserDetailsDto(name = this.name, username = this.username)
}