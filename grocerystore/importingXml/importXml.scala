package com.varun.grocerystore.importingXml
import java.io.File

import scala.collection.mutable.ListBuffer
import xml._

case class dataToLB(i:Int,n:String,a:Double,s:Double){
  val id:Int=i
  val name:String=n
  val amount:Double=a
  val stock:Double=s

}


class importXml {


  val lb= new ListBuffer[dataToLB]
  val f=new File("/home/varun/IdeaProjects/grocerystore[Unit]/src/main/scala/com/varun/grocerystore/importingXml/GroceryDataBasic.xml")
   var xmlElem:Elem=null
  def importXmlAsElem(): Elem ={
    xmlElem=XML.loadFile(f)
     xmlElem
  }

  def fromXmltoLb(): NodeSeq ={
    val elm=importXmlAsElem()
    val tagname="item"
    val itemList=elm \\ tagname
     itemList
  }

  def getAttr(): Unit ={
    val obj=fromXmltoLb()

    for(x <- 0 until obj.length) {
      val obj1=obj(x)
      val id = getId(obj1)
      val name = getName(obj1)
      val amount = getAmount(obj1)
      val stock = getStock(obj1)

      val objx=setAttr(id, name, amount, stock)
      addtoLB(objx)
    }
    }

  def setAttr(id:Int,name:String,amount:Double,stock:Double): dataToLB ={
    val obj=dataToLB(id,name,amount,stock)
     obj
  }

  def addtoLB(obj:dataToLB): Unit ={
    lb+=obj
  }

  def clearLb(): ListBuffer[dataToLB] ={
    lb.clear()
    lb
  }

  def getListBuffer(): ListBuffer[dataToLB] ={
    lb
  }

  def getId(obj:Node): Int ={
    (obj \\ "id").text.toInt
  }


  def getName(obj:Node): String ={
    (obj \\ "name").text
  }


  def getAmount(obj:Node): Double ={
    (obj \\ "amount").text.toDouble
  }


  def getStock(obj:Node): Double ={
    (obj \\ "stock").text.toDouble
  }


  }







