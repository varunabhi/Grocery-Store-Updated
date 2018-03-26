package com.varun.grocerystore.services.CheckoutService

import com.varun.grocerystore.dao.{CartDaoImpl, CatalogueDaoImpl}
import com.varun.grocerystore.model.PaymentMethod
import com.varun.grocerystore.services._
import org.scalatest.{BeforeAndAfter, FunSuite}

class CheckoutServiceTest extends FunSuite with BeforeAndAfter{

  val cartDao=new CartDaoImpl
  val chkoutSvc=CheckoutService(cartDao)
  val ctlgDao=new CatalogueDaoImpl
  val ctlgSvc=CatalogueServices(ctlgDao)
  val cartSvc=CartServices(cartDao)
  ctlgSvc.createCatalog()
  ctlgDao.getAllItems.get.foreach(cartDao.insertItem(_,5))

  test("Final Total is Correct or not"){
    assert(chkoutSvc.getFinalTotal(cartSvc.getCart)===cartSvc.getCart.getTotal)
  }

  test("Test Payment Method Service"){
    chkoutSvc.setPaymentMethod(PaymentMethod.Net_Banking)
    assert(chkoutSvc.getpaymentMethod === PaymentMethod.Net_Banking)
  }

  test("Test CheckoutCart and Current User Cart are Same"){
    assert(chkoutSvc.getCheckoutCart===cartSvc.getCart)
  }
}
