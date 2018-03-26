package com.varun.grocerystore.exceptions

case class DbNotClearException(message: String) extends RuntimeException{

  def this(){
    this("Error In Clearing The Database")
  }

  override def getMessage: String = {
    message
  }

}
