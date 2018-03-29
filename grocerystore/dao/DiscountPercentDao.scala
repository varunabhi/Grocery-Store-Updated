package com.varun.grocerystore.dao

import scala.collection.immutable._
import scala.util.Try

trait DiscountPercentDao {
    def getAllDiscounts(itemId:Int):Try[HashMap[Double,Double]]
    def addDiscount(itemId:Int,minimumQty:Double,discountPercent:Double):Try[HashMap[Int,HashMap[Double, Double]]]
}
