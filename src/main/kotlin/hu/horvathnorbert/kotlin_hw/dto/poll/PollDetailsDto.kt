package hu.horvathnorbert.kotlin_hw.dto.poll

import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto

class PollDetailsDto(val name: String, val users: List<UserDetailsDto>)