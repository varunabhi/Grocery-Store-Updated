package com.varun.grocerystore.exceptions

case class ParsingException(message:String) extends RuntimeException{

  def this(){
    this("Error In Fetching Items")
  }

  override def getMessage: String = {
    message
  }

}
