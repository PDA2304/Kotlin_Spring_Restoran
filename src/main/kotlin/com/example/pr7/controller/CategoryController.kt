package com.example.pr7.controller

import com.example.pr7.model.Category
import com.example.pr7.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.validation.BindingResult
import org.springframework.validation.ObjectError
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid


@Controller
class CategoryController {

    @Autowired
    @Lazy
    lateinit var categoryService: CategoryService

    @GetMapping("/category")
    fun categoryGet(category: Category, model: Model): String {
        model["categoryAll"] = categoryService.categoryAll()
        return "fragmentsCategory/category"
    }

    @PostMapping("/category/search")
    fun categoryPost(@Valid category: Category, bindingResult: BindingResult, model: Model): String {
        model["categoryAll"] = categoryService.categorySearch(category.categoryName!!)
        return "fragmentsCategory/category"
    }

    @PostMapping("/category/insert")
    fun categoryInsertPost(@Valid category: Category, bindingResult: BindingResult, model: Model): String {
        model["categoryAll"] = categoryService.categoryAll()
        model["ID"] = -1

        if (bindingResult.hasErrors()) return "fragmentsCategory/category"

        val requestCode = categoryService.categoryAdd(category)

        if (!requestCode) {
            bindingResult.addError(ObjectError("categoryName", "Такое название категории уже существует"))
            return "fragmentsCategory/category"
        }

        return "redirect:/category"
    }

    @PostMapping("/category/{id}/update")
    fun categoryUpdatePost(@PathVariable(value = "id") id: Long, @Valid category: Category, bindingResult: BindingResult, model: Model,): String {
        model["categoryAll"] = categoryService.categoryAll()
        model["ID"] = id
        if(bindingResult.hasErrors())
        {
            return "fragmentsCategory/category"
        }

       val requestCode =  categoryService.categoryUpdate(id,category.categoryName!!)

        if(!requestCode)
        {
            bindingResult.addError(ObjectError("categoryName", "Такое название категории уже существует"))
            return "fragmentsCategory/category"
        }

        return "redirect:/category"
    }

    @GetMapping("/category/{id}/remove")
    fun categoryDeletePost(@PathVariable(value = "id") id: Long, model: Model): String {
        model["categoryAll"] = categoryService.categoryAll()
        categoryService.categoryDelete(id)
        return "redirect:/category"
    }

}