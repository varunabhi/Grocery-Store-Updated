package com.varun.grocerystore.DaoObjects

import com.varun.grocerystore.Services.CatalogueServices

class DaoImpl extends DaoObject[List[Any]] {
  override def addToCatalogue: List[Any] = (new CatalogueServices).addtoCatlogue

  override def updateCataLogue: List[Any] = {(new CatalogueServices).updateCatalogue}  //Still to be implemented

  override def removeFromCatalogue: List[Any] = {List()}  //Still to be implemented

}
