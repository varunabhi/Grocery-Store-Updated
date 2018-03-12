package com.varun.grocerystore.importingXml

import java.io.File

import scala.collection.mutable.ListBuffer
import xml._


class Catalogue {


  private val f = XML.loadFile(new File("/home/varun/IdeaProjects/grocerystore[Unit]/src/main/scala/com/varun/grocerystore/importingXml/GroceryDataBasic.xml"))
  private val tag: NodeSeq = f \\ "item"

  def mapItems: List[Any] = {
    tag.map(Item.toItemXML).toList
  }

  def getTagLength: Int = {
    tag.length
  }

}









