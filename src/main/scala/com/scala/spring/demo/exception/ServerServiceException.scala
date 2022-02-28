package com.scala.spring.demo.exception

case class ServerServiceException (errorCode: String = "", message: String = "", cause: Throwable = None.orNull)
  extends Exception(message, cause)
