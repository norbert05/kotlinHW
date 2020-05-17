package hu.horvathnorbert.kotlin_hw.service

import hu.horvathnorbert.kotlin_hw.dto.poll.PollDetailsDto
import hu.horvathnorbert.kotlin_hw.entity.Poll
import hu.horvathnorbert.kotlin_hw.entity.User
import hu.horvathnorbert.kotlin_hw.error.exception.EntityAlreadyExistsException
import hu.horvathnorbert.kotlin_hw.error.exception.EntityNotFoundException
import hu.horvathnorbert.kotlin_hw.mapper.entityToDetailsDto
import hu.horvathnorbert.kotlin_hw.repository.PollRepository
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class PollService(private val pollRepository: PollRepository,
                  private val userRepository: UserRepository) {

    fun getAllPolls(): List<PollDetailsDto> {
        return pollRepository.findAll().map { it.entityToDetailsDto() }
    }

    fun addPoll(name: String): PollDetailsDto {
        if (pollRepository.findByName(name) != null)
            throw EntityAlreadyExistsException("Poll exists!")

        return pollRepository.save(Poll(name, Collections.emptyList())).entityToDetailsDto()
    }

    fun poll(username: String, pollName: String) {
        val poll = pollRepository.findByName(pollName) ?:
                throw EntityNotFoundException("Poll not found!")

        val user = userRepository.findByUsername(username) ?:
                throw EntityNotFoundException("User not found!")

        poll.users.add(user)
        pollRepository.save(poll)
    }
}