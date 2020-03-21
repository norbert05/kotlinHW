package hu.horvathnorbert.kotlin_hw.controller

import hu.horvathnorbert.kotlin_hw.dto.user.UserCreateDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserUpdateDto
import hu.horvathnorbert.kotlin_hw.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping ("/user")
class UserController(private val userService: UserService) {

    @GetMapping("/list")
    fun getAllUser(): List<UserDetailsDto> {
        return userService.getAllUser()
    }

    @PostMapping
    fun createUser(@RequestBody userCreateDto: UserCreateDto): UserDetailsDto {
        return userService.createUser(userCreateDto)
    }

    @GetMapping("/list/{username}")
    fun getUser(@PathVariable username: String): UserDetailsDto {
        return userService.getUser(username)
    }

    @PutMapping("{username}")
    fun modifyName(@RequestParam name: String, @PathVariable username: String): UserDetailsDto {
        return userService.modifyUser(UserUpdateDto(name = name, username = username))
    }
}