package com.varun.grocerystore.exceptions

case class DbUpdationexception(message:String) extends RuntimeException {

  def this(){
    this("Error In Updating Database ")
  }

  override def getMessage: String = {
    message
  }

}
