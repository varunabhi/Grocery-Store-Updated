package com.varun.grocerystore.svc

import com.varun.grocerystore.dao.CartDao
import com.varun.grocerystore.model.{Cart, PaymentMethod}

class GenerateOrderSummary(cartdao:CartDao) {

  def showFinalCart(): Cart ={
    val cart=Cart(CartServices(cartdao).getCart.getCart)
    cart
  }

  def showFinalTotal(obj1:Cart): Double ={
    val cart=Cart(CartServices(cartdao).getCart.getCart)
    cart.getTotal
  }

  def getPaymentMethod(obj:CheckoutService): PaymentMethod.Value ={
    obj.getpaymentMethod
  }
}