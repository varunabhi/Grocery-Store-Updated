package com.varun.grocerystore.model

object PaymentMethod extends Enumeration {
    val Credit_Card:Value=Value("Credit Card")
  val Debit_Card:Value=Value("Debit Card")
  val Net_Banking: Value =Value("Net Banking")
}
