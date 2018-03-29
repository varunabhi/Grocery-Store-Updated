package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.DiscountPercentDao

import scala.collection.immutable.HashMap
import scala.util.{Failure, Success}

case class PercentDiscount(discountPercentDao: DiscountPercentDao) {

  def setDiscount(itemId:Int,minimumQty:Double,discountPercent:Double): Either[Throwable,HashMap[Int,HashMap[Double,Double]]] ={
            discountPercentDao.addDiscount(itemId,minimumQty,discountPercent) match {
              case Success(s) =>Right(s)
              case Failure(f) => Left(f)
            }
    }


  def getDiscount(itemId:Int): Either[Throwable,HashMap[Double,Double]] ={
    discountPercentDao.getAllDiscounts(itemId) match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
  }
}
