package com.varun.grocerystore.model


case class Item(id: Int, name: String, amount: Double, stock: Double, discPerc : Double=0) extends Serializable
{
//  def getItem(id:Int): Item ={
//        val ctlg=new CatalogueDaoImpl    //Not to use Dao here
//        ctlg.findItem(id).get
//  }

}


