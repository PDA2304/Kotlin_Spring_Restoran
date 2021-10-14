package com.example.pr7.model

import javax.persistence.*
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size


@Entity
@Table(name="category")
data class Category(

        @Column(name = "category_name")
        @field:NotEmpty(message = "Название категории не может быть пустым")
        @field:Size(min = 3, max = 30)
        var categoryName: String?,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long = -1
){
        constructor() : this("")
}

