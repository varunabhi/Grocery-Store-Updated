package com.varun.grocerystore.utilities

import com.varun.grocerystore.model.Item

import scala.xml.Node

object XmlConverter {

  def toItemXML(obj: Node): Item = {
    Item((obj \\ "id").text.toInt, (obj \\ "name").text, (obj \\ "amount").text.toDouble, (obj \\ "stock").text.toDouble)
  }
}

