package com.scala.spring.demo.controller

import com.scala.spring.demo.dto.{ErrorResponse, UserInfo}
import com.scala.spring.demo.exception.ServerServiceException
import com.scala.spring.demo.service.UserService
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.{HttpStatus, MediaType, ResponseEntity}
import org.springframework.web.bind.annotation.{DeleteMapping, GetMapping, PathVariable, PostMapping, PutMapping, RequestMapping, ResponseStatus, RestController}
import org.springframework.web.bind.annotation.ExceptionHandler

import java.nio.file.AccessDeniedException

@RestController
@RequestMapping(value = Array("/users"), produces = Array(MediaType.APPLICATION_JSON_VALUE))
class UserController (@Autowired private val userService: UserService) {

  val logger: Logger = LoggerFactory.getLogger(classOf[UserController]);

  @GetMapping()
  def findAll(): Array[UserInfo] = {
    logger.debug("findAll:");
    userService.getUsers();
  }

  @PostMapping(Array("/"))
  @ResponseStatus(HttpStatus.CREATED)
  def createUser(user: UserInfo): Int = {
    logger.debug("createUser:");
    userService create user;
  }

  @GetMapping(Array("/{id}"))
  def findOne(@PathVariable("id") id: Int): UserInfo = {
    logger.debug("findOne:");
    userService getUser id;
  }

  @PutMapping(Array("/{id}"))
  @ResponseStatus(HttpStatus.NO_CONTENT)
  def updateUser(@PathVariable("id") id: Int, user: UserInfo): Unit = {
    logger.debug("updateUser:");
    userService update user;
  }

  @DeleteMapping(Array("/{id}"))
  @ResponseStatus(HttpStatus.NO_CONTENT)
  def deleteUser(@PathVariable("id") id: Int): Unit = {
    logger.debug("deleteUser:");
    userService delete id;
  }

  @ExceptionHandler(Array(classOf[Exception]))
  def handleException(ex: Exception): ResponseEntity[_] = {
    ex match {
      case _: ServerServiceException => {
        val bizEx = ex.asInstanceOf[ServerServiceException];
        if (bizEx.errorCode == "ERR-404")
          ResponseEntity.status(404).body(ErrorResponse("ERR-404", "Data could not be found."));
        else ResponseEntity.badRequest().body(ErrorResponse("ERR-400", "Invalid input."));
      };
      case _ => ResponseEntity.status(500).body(ErrorResponse("ERR-500", "The internal server error was occurred."));
    }
  }
}