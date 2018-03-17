package com.varun.grocerystore.entities

object Cart {

  private var cartMap=Map[Item,Int]()

  def getCart:Map[Item,Int] ={
    cartMap
  }

  def setCart(mp:Map[Item,Int]): Map[Item,Int] ={
    cartMap=mp
    cartMap
  }

}



