package com.varun.grocerystore.dao

import com.varun.grocerystore.model.Item

import scala.util.Try

trait CatalogueDao {
  def findItem(id:Int):Try[Item]
  def getAllItems:Try[List[Item]]
  def insertItem(item:Item):Try[List[Item]]
  def updateItem(item:Item):Try[List[Item]]
  def deleteItem(item:Item):Try[List[Item]]
  def clearAllItems():Try[List[Item]]
  def getCurrentCount:Int
}
