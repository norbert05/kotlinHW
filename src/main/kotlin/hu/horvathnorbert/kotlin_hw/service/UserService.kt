package hu.horvathnorbert.kotlin_hw.service

import hu.horvathnorbert.kotlin_hw.dto.user.TokenDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserCreateDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserDetailsDto
import hu.horvathnorbert.kotlin_hw.dto.user.UserUpdateDto
import hu.horvathnorbert.kotlin_hw.error.exception.EntityNotFoundException
import hu.horvathnorbert.kotlin_hw.error.exception.PasswordIncorrectException
import hu.horvathnorbert.kotlin_hw.mapper.mapToUser
import hu.horvathnorbert.kotlin_hw.mapper.mapToUserDetailsDto
import hu.horvathnorbert.kotlin_hw.repository.UserRepository
import hu.horvathnorbert.kotlin_hw.utils.md5
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*
import java.util.function.Function
import java.util.stream.Collectors


@Service
class UserService(private val userRepository: UserRepository) {

    fun getAllUser() : List<UserDetailsDto> {
        return userRepository.findAll().map { it.mapToUserDetailsDto() }
    }

    fun createUser(userCreateDto: UserCreateDto): UserDetailsDto {
        return userRepository.save(userCreateDto.mapToUser()).mapToUserDetailsDto()
    }

    fun getUser(username: String): UserDetailsDto {
        val user = userRepository.findByUsername(username) ?:
        throw EntityNotFoundException("User not found with name: $username")

        return user.mapToUserDetailsDto()
    }

    fun modifyUser(userUpdateDto: UserUpdateDto): UserDetailsDto {
        val user = userRepository.findByUsername(userUpdateDto.username) ?:
        throw EntityNotFoundException("User not found with name: ${userUpdateDto.username}")

        user.name = userUpdateDto.name

        return userRepository.save(user).mapToUserDetailsDto()
    }

    fun login(username: String, password: String): TokenDto {
        val user = userRepository.findByUsername(username) ?:
        throw EntityNotFoundException("User not found with name: $username")

        if (password.md5() == user.password) {
            System.out.println("(*)" + getJWTToken(username))
            return TokenDto(getJWTToken(username))
        } else {
            throw PasswordIncorrectException("Password is incorrect!")
        }
    }

    // JWT
    private fun getJWTToken(username: String): String? {
        val secretKey = "mySecretKey"
        val grantedAuthorities: List<GrantedAuthority> = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER")

        val token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities
                                .map { it.authority }.toList() )
                .setIssuedAt(Date(System.currentTimeMillis()))
                .setExpiration(Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.toByteArray()).compact()
        return "Bearer $token"
    }
}