package com.varun.grocerystore.services

import com.varun.grocerystore.dao.CartDao
import com.varun.grocerystore.model.{Cart,PaymentMethod}

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

}
