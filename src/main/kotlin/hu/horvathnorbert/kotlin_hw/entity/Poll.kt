package hu.horvathnorbert.kotlin_hw.entity

import javax.persistence.*

@Entity
class Poll(
        @Column(unique = true) val name: String,
    @ManyToMany @JoinTable(name = "user_poll",
            joinColumns = [JoinColumn(name = "user_id")],
            inverseJoinColumns = [JoinColumn(name = "poll_id")]
    ) val users: MutableList<User>
): BaseEntity() { }