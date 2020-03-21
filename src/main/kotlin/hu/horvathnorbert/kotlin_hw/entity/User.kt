package hu.horvathnorbert.kotlin_hw.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "userEntity")
class User(
        val username: String,
        val password: String,
        val name: String
): BaseEntity() {

}