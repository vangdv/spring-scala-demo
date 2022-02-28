package com.scala.spring.demo.dto

case class ErrorResponse(code: String, message: String, extras: Array[String] = Array.empty)
