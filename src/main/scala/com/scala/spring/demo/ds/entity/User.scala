package com.scala.spring.demo.ds.entity

import javax.persistence._
import scala.beans.BeanProperty


@Entity
@Table(name = "User")
class User (first: String, last: String) {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @BeanProperty
  var id: Int = _;

  @BeanProperty
  var firstName: String = first;

  @BeanProperty
  var lastName: String  = last;

  def this() = this (null, null);

  override def toString: String = id + " = " + firstName + " " + lastName;
}