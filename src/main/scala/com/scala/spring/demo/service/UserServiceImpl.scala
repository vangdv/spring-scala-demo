package com.scala.spring.demo.service
import com.scala.spring.demo.ds.repo.UserRepository
import com.scala.spring.demo.dto.UserInfo
import com.scala.spring.demo.exception.ServerServiceException
import org.slf4j.{Logger, LoggerFactory}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl( @Autowired private val userRepository: UserRepository) extends UserService {

  val logger: Logger = LoggerFactory.getLogger(classOf[UserServiceImpl]);

  /** Returns User information for given user id.
   *
   * @param id User id.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return User information.
   */
  override def getUser(id: Int): UserInfo = {
    val result = userRepository findById id;
    if (!result.isPresent) throw ServerServiceException("ERR-404", "User could not be found. id=" + id);

    val user = result.get();
    UserInfo(user.getId(), user.getFirstName, user.getLastName);
  }

  /** Returns all User information.
   *
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return All user information.
   */
  override def getUsers(): Array[UserInfo] = {

    val result = userRepository.findAll();

    val infoList = Array.newBuilder[UserInfo];

    result.forEach(x => infoList += UserInfo(x.getId(), x.getFirstName(), x.getLastName()));
    infoList.result();
  }

  /** Creates a new user based on the given information.
   *
   * @param user User information.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   * @return Id of created user.
   */
  override def create(user: UserInfo): Int = ???

  /** Updates existing user based on the given information.
   *
   * @param user User information
   * @throws com.scala.spring.demo.exception.ServerServiceException
   */
  override def update(user: UserInfo): Unit = ???

  /** Deletes user information based on given id.
   *
   * @param id User id.
   * @throws com.scala.spring.demo.exception.ServerServiceException
   */
  override def delete(id: Int): Unit = ???
}
