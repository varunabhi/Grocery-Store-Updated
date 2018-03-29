package com.varun.grocerystore.database

object UserDb {

  var adminMap: Map[Int, String] =Map[Int,String]()
  var userMap: Map[Int, String] =Map[Int,String]()

  def getAdminPassword(adminId:Int): Option[String] ={
    adminMap(adminId) match {
      case null => None
      case x => Some(x)
    }
  }

  def getUserPassword(userId:Int): Option[String] ={
    userMap(userId) match {
      case null => None
      case x => Some(x)
    }
  }

  def setAdminPassword(adminId:Int,password:String): Unit ={   //Return Type
    adminMap+=(adminId -> password)
  }

  def setUserPassword(userId:Int,password:String): Unit ={     //Return Type
    userMap+=(userId -> password)
  }

}
