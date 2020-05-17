package hu.horvathnorbert.kotlin_hw.controller

import hu.horvathnorbert.kotlin_hw.dto.poll.PollDetailsDto
import hu.horvathnorbert.kotlin_hw.service.PollService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/poll")
class PollController(private val pollService: PollService) {
    @GetMapping("/list")
    fun getPolls(): List<PollDetailsDto> {
        return pollService.getAllPolls()
    }

    @PostMapping
    fun addPoll(@RequestParam name: String): PollDetailsDto {
        return pollService.addPoll(name)
    }

    @PutMapping("{pollName}")
    fun poll(@RequestParam username: String, @PathVariable pollName: String) {
        pollService.poll(username, pollName)
    }
}