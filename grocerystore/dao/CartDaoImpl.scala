package com.varun.grocerystore.dao

import com.varun.grocerystore.database.CartDb
import com.varun.grocerystore.exceptions._
import com.varun.grocerystore.model.Item

import scala.collection.mutable
import scala.util.Try

class CartDaoImpl extends CartDao {

  val cart: mutable.Map[Item, Double] =CartDb.getDB

  override def findItem(item: Item): Try[(Item,Double)] = {
    Try(cart.find(_._1==item) match {
      case Some(x) => x
      case _ => throw new ItemNotFoundException()
    })
  }

  override def getCart: Try[Map[Item, Double]] = {
    val DbSize=CartDb.getDB.size
    Try(cart.size match {
      case DbSize => cart.toMap
      case _ => throw new ParsingException()
    })
  }

  override def insertItem(item: Item, qty: Double): Try[Map[Item, Double]] = {
    val InitSize=CartDb.getDB.size
      CartDb.addToDB(item,qty)
    val NewSize=CartDb.getDB.size
    val TempSize=InitSize+1
    Try(NewSize match {
      case TempSize => CartDb.getDB.toMap
      case _ => throw  DbInsertionException(s"Not able to insert item ${item.id}")
    })
  }

  override def updateItem(item: Item, Qty: Double): Try[Map[Item, Double]] = {
    CartDb.updateDB(item,Qty)
    Try(CartDb.getDB.get(item) match {
      case Some(Qty) => CartDb.getDB.toMap
      case Some(x) => throw DbUpdationexception(s"Not able to update item with item id ${item.id}")
      case _ => throw new DbUpdationexception()
    })
  }

  override def deleteItem(item: Item): Try[Map[Item, Double]] = {
    CartDb.removeFromDB(item)
    Try(if (CartDb.getDB.contains(item)) {
      throw DbDeleteException(s"Not able to delete item with id ${item.id}")
    } else {
      CartDb.getDB.toMap
    })
  }

  override def clearAllItems(): Try[Map[Item, Double]] = {
    CartDb.removeAll()
    Try({
      if (CartDb.getDB.isEmpty)
        CartDb.getDB.toMap
      else
        throw new DbNotClearException()
    })
  }

  override def getCurrentCount: Int = {
    CartDb.getCurrentCount
  }
}
