package hu.horvathnorbert.kotlin_hw.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "userEntity")
class User(
        @Column(unique = true) val username: String,
        val password: String,
        var name: String
): BaseEntity() {

}