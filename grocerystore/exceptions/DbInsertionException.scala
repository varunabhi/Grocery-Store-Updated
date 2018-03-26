package com.varun.grocerystore.exceptions

case class DbInsertionException(message: String) extends RuntimeException {

  def this(){
    this("Error In Inserting In Database")
  }

  override def getMessage: String = {
    message
  }

}
