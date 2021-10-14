package com.example.pr7.repo

import com.example.pr7.model.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : CrudRepository<Category,Long> {

    fun existsByCategoryName(categoryName :String) : Boolean

    fun findByCategoryName(categoryName: String): List<Category>
}