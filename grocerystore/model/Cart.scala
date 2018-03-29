package com.varun.grocerystore.model

case class Cart(cart:Map[(Item,Double),Double]) extends Serializable {

    def this(){
      this(Map())
    }

    def getCart:Map[(Item,Double),Double] ={
      cart
    }

    def getCurrentCount: Int ={
      cart.size
    }

    def getTotal:Double={
      cart.values.sum
    }

}
