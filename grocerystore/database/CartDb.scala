package com.varun.grocerystore.database

import com.varun.grocerystore.exceptions.{DbDeleteException, DbInsertionException, DbUpdationexception, ParsingException}
import com.varun.grocerystore.model.Item

import scala.collection.mutable

object CartDb {

  val mapCart: mutable.Map[Item, Double] =mutable.Map[Item,Double]()

  def addToDB(item:Item,qty:Double): Boolean ={
    try {
      mapCart += (item -> qty)
      true
    }
    catch{
      case ex:DbInsertionException => false
      case y:Exception =>y.getMessage; false
    }
  }

  def updateDB(item:Item,newqty:Double): Boolean ={
    try{
    mapCart.update(item,newqty)
      true
    }
    catch {
      case ex:DbUpdationexception => false
      case y:Exception => y.getMessage;false
    }
  }

  def removeFromDB(item:Item): Boolean ={
    try {
      mapCart -= item
      true
    }
    catch {
      case ex:DbDeleteException => false
      case y:Exception => y.getMessage;false
    }
  }
  def removeAll(): Boolean ={
    try {
      mapCart.clear()
      true
    }
    catch {
      case ex:DbDeleteException => ex.getMessage;false
      case y:Exception => y.getMessage;false
    }
  }
  def getDB: mutable.Map[Item,Double] ={
    try{
    mapCart
    }
    catch {
      case ex:ParsingException => ex.getMessage;mutable.Map()
      case y:Exception => y.getMessage;mutable.Map()
    }
  }

  def getCurrentCount: Int ={
    mapCart.size
  }
}
