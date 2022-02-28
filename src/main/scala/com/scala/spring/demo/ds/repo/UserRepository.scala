package com.scala.spring.demo.ds.repo

import com.scala.spring.demo.ds.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
trait UserRepository extends CrudRepository[User, Int] {}
