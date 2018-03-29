package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.DiscountBuyGetDao

import scala.collection.mutable
import scala.util.{Failure, Success}

case class BuyGetDiscount( discountBuyGetDao: DiscountBuyGetDao) {

  def setDiscount(itemId: Int, itemQty: Double, offerItemId: Int, offerItemQty: Double): Either[Throwable,mutable.HashMap[Int, mutable.HashMap[Double, List[(Int, Double)]]]] ={
    discountBuyGetDao.addDiscount(itemId,itemQty,offerItemId,offerItemQty) match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
  }


  def getDiscount(itemId:Int): Either[Throwable,mutable.HashMap[Double,List[(Int,Double)]]] ={
    discountBuyGetDao.getAllDiscounts(itemId) match {
      case Success(s) => Right(s)
      case Failure(f) => Left(f)
    }
  }
}
