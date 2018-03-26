package com.varun.grocerystore.model

import com.varun.grocerystore.dao.CatalogueDaoImpl

case class Item(id: Int, name: String, amount: Double, stock: Double, discPerc : Double=0) extends Serializable
{
  def getItem(id:Int): Item ={
        val ctlg=new CatalogueDaoImpl
        ctlg.findItem(id).get
  }

}


