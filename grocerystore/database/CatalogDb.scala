
package com.varun.grocerystore.database

import com.varun.grocerystore.model.Item

import scala.collection.mutable.ListBuffer

object CatalogDb {
  private val lst_ctlg=ListBuffer[Item]()

  def getItemFromDb(item:Item): Boolean ={
    if(lst_ctlg.contains(item))
      true
    else
      false
  }

 def addToDB(item:Item): Boolean ={
  lst_ctlg+=item
   true
 }
 def updateDB(item:Item): Boolean ={
  //
   true
 }

 def removeFromDB(item:Item): Boolean ={
  lst_ctlg-=item
   true
 }
 def getDB: ListBuffer[Item] ={
  lst_ctlg
 }

  def getCurrentCount: Int ={
    lst_ctlg.size
  }

  def clearDB():Boolean ={
    lst_ctlg.clear()
    true
  }

 }