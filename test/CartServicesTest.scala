package com.varun.grocerystore.services.CartServices

import com.varun.grocerystore.dao.{CartDaoImpl, CatalogueDaoImpl}
import com.varun.grocerystore.model.Item
import com.varun.grocerystore.services.{CartServices, CatalogueServices}
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CartServicesTest extends FunSuite with BeforeAndAfter {

    val cartDao=new CartDaoImpl
    val ctlgDao=new CatalogueDaoImpl
    val cartSvc=CartServices(cartDao)
    val ctlgSvc=CatalogueServices(ctlgDao)
    var items:List[Item]=Nil
  before{
    ctlgDao.clearAllItems()
    ctlgSvc.createCatalog()
    items=ctlgDao.getAllItems.get
  }

  test("Test whether Items are getting added or not") {
    assert(cartSvc.addToCart(items.head, 5).isRight)
  }

  test("All are added to cart or not"){
    items.foreach(cartSvc.addToCart(_,5))
    assert(cartDao.getCurrentCount===ctlgDao.getCurrentCount)
  }

  test("Cart is updated or not"){
    cartSvc.updateCart(items.head,9)
    assert(cartDao.findItem(items.head).get._2===9)
  }

  test("Item is getting removed"){
    cartSvc.removeFromCart(items.last)
    assert(cartSvc.getItemFromCart(items.last).isLeft)
  }

  test("Cart is clear"){
    assert(cartSvc.clearCart().isRight)
  }

}