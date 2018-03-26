package com.varun.grocerystore.services

import com.varun.grocerystore.dao.{CartDao, CatalogueDao}
import com.varun.grocerystore.model.Item
import scala.util.{Failure, Success}
case class PostCheckoutCatalogUpdate(catalogDao:CatalogueDao) {


  private def updateItem(item: Item,qty:Double): Unit ={
    val itemTemp=catalogDao.findItem(item.id).get
    catalogDao.deleteItem(item)
    catalogDao.insertItem(Item(itemTemp.id,itemTemp.name,itemTemp.amount,itemTemp.stock-qty))
  }

  def updatedCatalog(cart:CartDao ): Either[Throwable,List[Item]] ={
    val crt=cart.getCart.get
      crt.foreach((x) => updateItem(x._1,x._2))
    val updatedCtlg=catalogDao.getAllItems match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
//    Either(updatedCtlg.left.get,updatedCtlg.right.get)
      updatedCtlg
  }
}
