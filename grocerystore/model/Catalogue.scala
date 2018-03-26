package com.varun.grocerystore.model

//Data Transfer Object
case class Catalogue(items: List[Item])  extends Serializable {

  def this(){
    this(List())
  }

 def getItems: List[Item] ={
   if(items==null)
     List()
     else
     items
  }

  def currentCount(): Int ={
    items.size
  }
}


