package com.varun.grocerystore.database

import scala.collection.mutable

object DiscountBuyGetDb {
  //It can be Immutable with Var

  val mapDiscounts: mutable.Map[Int, Map[Double, List[(Int, Double)]]] =mutable.Map[Int,Map[Double,List[(Int,Double)]]]()

   private def createValueMap(valuesMap: Map[Double, List[(Int, Double)]],selfItemQty: Double, offeredItemId: Int, offeredItemQty: Double): Map[Double,List[(Int,Double)]] =
  {
    if(!valuesMap.contains(selfItemQty) || valuesMap.isEmpty){
      val offeredItemDetails=(offeredItemId,offeredItemQty)
      val updatedMap=valuesMap + (selfItemQty -> List(offeredItemDetails))
      updatedMap
    }
    else {
      val discounts=valuesMap(selfItemQty)
      val offeredItemDetails=(offeredItemId,offeredItemQty)
      val updatedMap=valuesMap + (selfItemQty -> (List(offeredItemDetails) ::: discounts))
      updatedMap
    }
  }


  def addToDb(selfId:Int, selfItemQty:Double, offeredItemId:Int, offeredItemQty:Double): mutable.Map[Int, Map[Double, List[(Int, Double)]]] ={
      if(!mapDiscounts.contains(selfId)){
        val emptyMap=Map[Double, List[(Int, Double)]]()
        val valuesMap=createValueMap(emptyMap,selfItemQty,offeredItemId,offeredItemQty)
        mapDiscounts.put(selfId,valuesMap)
        mapDiscounts
      }
    else {
        val valuesMap =mapDiscounts(selfId)
        val updatedValuesMap=createValueMap(valuesMap,selfItemQty,offeredItemId,offeredItemQty)
        mapDiscounts.put(selfId,updatedValuesMap)
        mapDiscounts
      }
  }

  def getDiscounts(itemId:Int):Map[Double,List[(Int,Double)]]={
    mapDiscounts(itemId)
  }

}
