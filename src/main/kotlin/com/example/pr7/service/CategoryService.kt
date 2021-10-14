package com.example.pr7.service

import com.example.pr7.model.Category

interface CategoryService {

    fun categoryAdd(category: Category) : Boolean

    fun categoryDelete(id:Long)

    fun categoryUpdate(id:Long,categoryName: String) : Boolean

    fun categoryAll(): Iterable<Category>

    fun categorySearch(categoryName: String): Iterable<Category>

}