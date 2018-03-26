package com.varun.grocerystore.dao

import com.varun.grocerystore.model.Item

import scala.util.Try

trait CartDao {
  def findItem(item:Item):Try[(Item,Double)]
  def getCart:Try[Map[Item,Double]]
  def insertItem(item:Item,qty:Double):Try[Map[Item,Double]]
  def updateItem(item:Item,qty:Double):Try[Map[Item,Double]]
  def deleteItem(item:Item):Try[Map[Item,Double]]
  def clearAllItems():Try[Map[Item,Double]]
  def getCurrentCount:Int
}
