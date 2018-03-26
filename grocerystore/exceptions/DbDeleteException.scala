package com.varun.grocerystore.exceptions

case class DbDeleteException(message:String) extends RuntimeException{
  def this(){
    this("Error in Deletion")
  }

  override def getMessage: String = {
    message
  }
}
