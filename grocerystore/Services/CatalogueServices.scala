package com.varun.grocerystore.Services

import java.io.File

import com.varun.grocerystore.entities.{Catalogue, Item}

import scala.xml._
class CatalogueServices {

  private val f = XML.loadFile(new File("/home/varun/IdeaProjects/grocerystore[Unit]/src/main/scala/com/varun/grocerystore/GroceryDataBasic.xml"))
  private val tag: NodeSeq = f \\ "item"

def getTagLength: Int = {
    tag.length
  }

  def updateCatalogue(): List[Item] = {                  // Run It in Main Once to Start Service
    (new CatalogueUpdateService).updateCatalogue(addToCatalog)
  }

  def addToCatalog: List[Item] = {  // To be Run Firstly
    val lst_items=tag.map(Item.toItemXML).toList
    lst_items
}

  def getCatalogue: List[Item] ={
    val lst=addToCatalog
    lst
  }

}









