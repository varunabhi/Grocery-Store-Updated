package com.varun.grocerystore.dao
import com.varun.grocerystore.model.Item
import com.varun.grocerystore.database.CatalogDb
import com.varun.grocerystore.exceptions._

import scala.util.Try

class CatalogueDaoImpl extends CatalogueDao {
//  val items: List[Item] = _


  override def findItem(id: Int): Try[Item] = {
    val items: List[Item] =CatalogDb.getDB.toList
    Try(items.find(_.id==id) match {
      case Some(x) => x
      case _ => throw ItemNotFoundException(s"Not able to find Item with id ${id}")
    })
  }

  override def getAllItems: Try[List[Item]] = {
    val items: List[Item] =CatalogDb.getDB.toList
    val DbSize=CatalogDb.getDB.size
      Try(items.size match {
        case DbSize =>items
        case _ =>throw new ParsingException()
      })
  }

  override def insertItem(item: Item): Try[List[Item]] = {
    val items: List[Item] =CatalogDb.getDB.toList
    val OldSize=items.size
    val NewSize=OldSize+1
    CatalogDb.addToDB(item)
    val updItems=CatalogDb.getDB.toList
    Try(updItems.size match {
      case OldSize => throw DbInsertionException("Not able To update Database ")
      case NewSize => updItems
      case _ => throw new DbInsertionException()
    })
  }

  override def updateItem(item: Item): Try[List[Item]] ={
      CatalogDb.updateDB(item)
      val items=CatalogDb.getDB
    Try(items.find(_.equals(item)) match {
      case Some(x) => items.toList
      case _ => throw DbUpdationexception(s"Cant update item with id ${item.id}")
    })
  }

  override def deleteItem(item: Item): Try[List[Item]] = {
    CatalogDb.removeFromDB(item)
    val items=CatalogDb.getDB.toList
     Try(items.find(_.equals(item)) match {
       case None => items
       case _ => throw DbDeleteException(s"Not able to delete item with id ${item.id}")
     })
  }

  override def clearAllItems(): Try[List[Item]] = {
    CatalogDb.clearDB()
    val items=CatalogDb.getDB.toList
    Try( items match {
      case List() => items
      case _ => throw new DbNotClearException()
    })
  }

  override def getCurrentCount: Int = {
    CatalogDb.getCurrentCount
  }
}
