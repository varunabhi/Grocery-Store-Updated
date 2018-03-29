package com.varun.grocerystore.dao
import com.varun.grocerystore.database.DiscountPercDb
import com.varun.grocerystore.exceptions.ParsingException

import scala.collection.immutable.HashMap
import scala.util.Try

class DiscountPercentDaoImpl extends DiscountPercentDao {
  override def getAllDiscounts(itemId: Int): Try[HashMap[Double, Double]] = {
        val discounts=DiscountPercDb.getItemDiscounts(itemId)
      Try(discounts match {
        case a:HashMap[Double,Double] => discounts
        case _ => throw new ParsingException()
      })
  }

  override def addDiscount(itemId: Int, minimumQty: Double, discountPercent: Double): Try[HashMap[Int,HashMap[Double, Double]]] = {
    val updatedDiscounts=DiscountPercDb.addDiscount(itemId,minimumQty,discountPercent)
    Try(updatedDiscounts match {
      case a:HashMap[Int,HashMap[Double, Double]] => updatedDiscounts
      case _ => throw new ParsingException()
    })
  }
}
