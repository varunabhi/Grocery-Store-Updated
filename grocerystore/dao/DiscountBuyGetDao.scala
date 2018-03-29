package com.varun.grocerystore.dao

import scala.collection.immutable._
import scala.collection.mutable
import scala.util.Try

trait DiscountBuyGetDao {
    def getAllDiscounts(itemId:Int):Try[mutable.HashMap[Double,List[(Int,Double)]]]
    def addDiscount(itemId:Int,itemQty:Double,offerItemId:Int,offerItemQty:Double):Try[mutable.HashMap[Int,mutable.HashMap[Double, List[(Int,Double)]]]]
}
