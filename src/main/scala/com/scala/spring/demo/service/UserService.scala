package com.scala.spring.demo.service

import com.scala.spring.demo.dto.UserInfo
import com.scala.spring.demo.exception.ServerServiceException

trait UserService {

  /** Returns User information for given user id.
   *
   * @param id User id.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return User information.
   */
  @throws(classOf[ServerServiceException])
  def getUser(id: Int): UserInfo;

  /** Returns all User information.
   *
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return All user information.
   */
  @throws(classOf[ServerServiceException])
  def getUsers(): Array[UserInfo];

  /** Creates a new user based on the given information.
   *
   * @param user User information.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return Id of created user.
   */
  @throws(classOf[ServerServiceException])
  def create(user: UserInfo): Int;

  /** Updates existing user based on the given information.
   *
   * @param user User information
   * @throws com.scala.spring.demo.exception.ServerServiceException
   */
  @throws(classOf[ServerServiceException])
  def update(user: UserInfo): Unit;

  /** Deletes user information based on given id.
   *
   * @param id User id.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   */
  @throws(classOf[ServerServiceException])
  def delete(id: Int): Unit;
}
