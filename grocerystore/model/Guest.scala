package com.varun.grocerystore.model

//import com.varun.grocerystore.database.CartDb

class Guest extends User {
  override val id: Int =_  //Here I want to use val but was not able to


  def setId(Id:Int): Unit ={
//  id=Id    // reassignment to val occurs
  }
  def getId: Int ={
    id
  }

}
