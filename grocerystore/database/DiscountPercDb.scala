package com.varun.grocerystore.database

import scala.collection.immutable
import scala.collection.immutable.HashMap

object DiscountPercDb {
  var mapItemPercent: immutable.HashMap[Int, immutable.HashMap[Double, Double]] = immutable.HashMap[Int, immutable.HashMap[Double, Double]]()
  var valuesMap:immutable.HashMap[Double, Double] = immutable.HashMap[Double, Double]()

  private def createValuesMap(valuesMap: immutable.HashMap[Double, Double], qty: Double, disc: Double):immutable.HashMap[Double, Double] = {
      val valuesMapTemp=valuesMap+ (qty -> disc)
      valuesMapTemp
    }


  def addDiscount(itemId: Int, qty: Double, discount: Double): HashMap[Int, immutable.HashMap[Double, Double]] = {
    if (!mapItemPercent.contains(itemId)) {
      val emptyMap=immutable.HashMap[Double, Double]()
      val valuesMap=createValuesMap(emptyMap,qty: Double, discount: Double)
      mapItemPercent+=(itemId -> valuesMap)
      mapItemPercent
    }
    else {
      val valuesMap=mapItemPercent(itemId)
      val updatedValuesMap=createValuesMap(valuesMap,qty: Double, discount: Double)
      mapItemPercent+=(itemId -> updatedValuesMap)
      mapItemPercent
    }
  }

  def getItemDiscounts(itemId:Int): immutable.HashMap[Double,Double] ={
    mapItemPercent(itemId)
  }
}