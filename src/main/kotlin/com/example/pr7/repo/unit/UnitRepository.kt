package com.example.pr7.repo.unit

import com.example.pr7.model.Unit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UnitRepository:CrudRepository<Unit,Long> {
}