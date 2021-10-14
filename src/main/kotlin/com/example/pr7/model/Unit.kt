package com.example.pr7.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

@Entity
@Table(name = "unit")
data class Unit(
        @Column(name = "unit_name")
        @field:NotEmpty(message = "Название единицы измерения не может быть пустым")
        @field:Size(min = 1, max = 3)
        var unitName: String?,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1
){
    constructor() : this("")
}

