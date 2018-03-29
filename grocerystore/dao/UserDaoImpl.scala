package com.varun.grocerystore.dao
import scala.util.Try

class UserDaoImpl extends UserDao {

  override def getUserPassword(userId: Int): Try[String] = ???

  override def getAdminPassword(adminId: Int): Try[String] = ???

  override def setUserPassword(userId: Int, password: String): Unit = ???

  override def setAdminPassword(adminId: Int, password: String): Unit = ???

}
