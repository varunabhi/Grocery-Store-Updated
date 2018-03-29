package com.varun.grocerystore.dao

import scala.util.Try

trait UserDao {
      def getUserPassword(userId:Int):Try[String]
      def getAdminPassword(adminId:Int):Try[String]
      def setUserPassword(userId:Int,password:String)
      def setAdminPassword(adminId:Int,password:String)
}
