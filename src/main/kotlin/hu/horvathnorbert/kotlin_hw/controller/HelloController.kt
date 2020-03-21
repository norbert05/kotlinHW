package hu.horvathnorbert.kotlin_hw.controller

import hu.horvathnorbert.kotlin_hw.dto.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.service.UserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping ("/hello")
class HelloController(private val userService: UserService) {

    @GetMapping
    fun hello() : List<UserDetailsDto> {
        return userService.getAllUser()
    }
}