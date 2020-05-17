package hu.horvathnorbert.kotlin_hw.mapper

import hu.horvathnorbert.kotlin_hw.dto.poll.PollDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.Poll

fun Poll.entityToDetailsDto() : PollDetailsDto {
    return PollDetailsDto(this.name, this.users.mapToDetailsDtoList())
}