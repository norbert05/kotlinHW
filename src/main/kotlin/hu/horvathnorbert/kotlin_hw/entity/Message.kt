package hu.horvathnorbert.kotlin_hw.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity
class Message(@OneToOne @JoinColumn(name = "fromUserId") val fromUser: User,
              @OneToOne @JoinColumn(name = "toUserId") val toUser: User,
              val message: String,
              val date: Long) : BaseEntity()