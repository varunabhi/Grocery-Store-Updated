package com.varun.grocerystore.exceptions

class DbConnectionException(message:String) extends RuntimeException{

  def this(){
    this("Error in Connection with DataBase")
  }

  override def getMessage: String = {
    message
  }
}
