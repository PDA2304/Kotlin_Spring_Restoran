package com.example.pr7.service.impl

import com.example.pr7.model.Category
import com.example.pr7.repo.CategoryRepository
import com.example.pr7.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Service

@Service
class CategoryImplService : CategoryService {
    @Autowired
    @Lazy
    lateinit var repository: CategoryRepository

    override fun categoryAdd(category: Category): Boolean {
        if (repository.existsByCategoryName(category.categoryName!!)) return false // Такой объект уже существует
        repository.save(category)
        return true
    }

    override fun categoryDelete(id: Long) {
        repository.deleteById(id)
    }

    override fun categoryUpdate(id: Long, categoryName: String): Boolean {

        val category = repository.findById(id).orElseThrow()

        if (repository.existsByCategoryName(categoryName)) return false

        category.categoryName = categoryName
        repository.save(category)
        return true
    }

    override fun categoryAll(): Iterable<Category> {
        return repository.findAll().sortedBy { it.id }
    }

    override fun categorySearch(categoryName: String): Iterable<Category> {
        var result =  repository.findByCategoryName(categoryName).sortedBy { it.id }
        if(result.size ==0)
        {
            return  repository.findAll().sortedBy { it.id }
        }
        return result
    }
}