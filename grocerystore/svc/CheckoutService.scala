package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.CartDao
import com.varun.grocerystore.model.{Cart, Item, PaymentMethod}

import scala.collection.immutable
import scala.util.Try

case class CheckoutService(cartdao:CartDao) {

  var paymentMthd:PaymentMethod.Value=_


  def getCheckoutCart: Cart ={
    val cart=Cart(CartServices(cartdao).getCart.getCart)
    cart
  }


  def getFinalTotal(obj:Cart):Double={
    val cart=Cart(CartServices(cartdao).getCart.getCart)
    cart.getTotal
  }

  def setPaymentMethod(mthd:PaymentMethod.Value): Try[PaymentMethod.Value] ={
    paymentMthd=mthd
    Try(checkPayment(paymentMthd))
  }

  def checkPayment(obj:PaymentMethod.Value): PaymentMethod.Value ={
    if(obj==getpaymentMethod)
      obj
    else
      throw new Exception("Payment Method error")
  }

  def getpaymentMethod: PaymentMethod.Value ={
    paymentMthd
  }

  private def computePercentDiscount(cart:Map[Item,Double]): collection.immutable.HashMap[Item,Double] ={ //Mapping Item with Its Discount
    var mapItemToDisc= immutable.HashMap[Item,Double]()
    cart.foreach((x) => {
      val discPerc=x._1.discPerc
      val discount=(x._1.amount * x._2)*(discPerc/100)
      mapItemToDisc+=(x._1 -> discount)
    })
    mapItemToDisc
    }

  def finalDiscountedPercentCart(): Map[(Item,Double),Double] ={
    val cartWithoutDiscount=getCheckoutCart.getCart
    val discountsMap=computePercentDiscount(cartdao.getCart.get)
    val finalEffectiveCart=cartWithoutDiscount.map((x)=>{
      val item=x._1._1
      val priceWithoutDiscount=x._2
      val effectivePrice=priceWithoutDiscount-discountsMap(item)
      x._1 -> effectivePrice
    })
    finalEffectiveCart
  }
}

