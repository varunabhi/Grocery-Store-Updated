package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.CartDao
import com.varun.grocerystore.model.{Cart, Item}

import scala.util.{Failure, Success}

case class CartServices(cartDao:CartDao) {

  def getItemFromCart(item: Item): Either[Throwable,(Item,Double)] ={
    cartDao.findItem(item) match {
      case Success(a) => Right(a)
      case Failure(b) => Left(b)
    }
  }


  def addToCart(item:Item, qty:Double):Either[Throwable,Cart] ={
    val itemPresent=cartDao.insertItem(item,qty) match {
      case Success(a) =>
        val cartObj=Cart(a.map(cartMapper))
        Right(cartObj)

      case Failure(b) => Left(b)
    }
    itemPresent
  }

  def getCart: Cart ={
    Cart(cartDao.getCart.get.map(cartMapper))
  }



  def updateCart(obj_item:Item,newQty:Double): Either[Throwable,Cart]={
    cartDao.updateItem(obj_item,newQty)
    val updatedCart=getRightAndLeft
    //    val cart=Cart(updatedCart.right.get.map(cartMapper) )  //New Instance of Cart :) HAPPILY IMMUTABLE
    updatedCart
  }

  def removeFromCart(item:Item): Either[Throwable,Cart] ={
    cartDao.deleteItem(item)
    val updatedCart=getRightAndLeft
    //    val cart=Cart(updatedCart.right.get.map(cartMapper))   //New Instance of Cart :) HAPPILY IMMUTABLE
    updatedCart
  }


  def clearCart(): Either[Throwable,Cart] ={
    cartDao.clearAllItems()
    val updatedCart=getRightAndLeft
    //    val cart=Cart(updatedCart.right.get.map(cartMapper))   //New Instance of Cart :) HAPPILY IMMUTABLE
    updatedCart
  }


  private def cartMapper(obj:(Item,Double)): ((Item,Double),Double) ={
    val totalPrice=obj._1.amount * obj._2
    (obj,totalPrice)
  }

  private def getRightAndLeft: Either[Throwable,Cart] ={
    val updatedCart=cartDao.getCart match {
      case Success(a) =>
        val cartObj=Cart(a.map(cartMapper))
        Right(cartObj)

      case Failure(f) => Left(f)
    }
    updatedCart
  }
}
