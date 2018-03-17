package com.varun.grocerystore.entities

object Catalogue{

  private var lst_items=List[Item]()

  def setItems(lst:List[Item]): Unit ={
    lst_items=lst
  }
  def getItems: List[Item] ={
     lst_items
  }
}


