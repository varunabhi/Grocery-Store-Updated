package com.varun.grocerystore.entities

class Guest extends User {
  override var id: Int =_  //Here I want to use val but was not able to


  def setId(Id:Int): Unit ={
  id=Id    // reassignment to val occurs
  }
  def getId: Int ={
    id
  }
}
