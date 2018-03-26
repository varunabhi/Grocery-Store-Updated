package com.varun.grocerystore.exceptions

case class ItemNotFoundException(message:String) extends RuntimeException{

  def this(){
    this("Item Not Found")
  }

  override def getMessage: String = {
    message
  }


}
