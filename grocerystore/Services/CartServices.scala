package com.varun.grocerystore.Services

import com.varun.grocerystore.entities.{Cart, Item}

class CartServices {

  def addToCart(obj_item:Item,qty:Int):Map[Item,Int] ={
    var cart=Cart.getCart
    cart += (obj_item -> qty)
    Cart.setCart(cart)
  }

  def updateCart(obj_item:Item,newQty:Int): Map[Item,Int] ={
    var cart=Cart.getCart
    cart=cart.updated(obj_item,newQty)  //Here updated and += will do same thing because object key will remain same
    Cart.setCart(cart)
  }

  def removeFromCart(item:Item): Map[Item,Int] ={
    var cart=Cart.getCart
    cart-=item
    Cart.setCart(cart)
  }
}
