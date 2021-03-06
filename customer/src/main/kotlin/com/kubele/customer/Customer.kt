package com.kubele.customer

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.SequenceGenerator

@Entity
data class Customer(
    @Id
    @SequenceGenerator(name = "customer_id_sequence", sequenceName = "customer_id_sequence")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_id_sequence")
    @Column(updatable = false)
    val id: Int = 0,
    val firstName: String = "",
    val lastName: String = "",
    @Column(unique = true)
    val email: String = ""
)
