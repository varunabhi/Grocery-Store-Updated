package com.varun.grocerystore.services.CatalogueServices

import com.varun.grocerystore.dao.CatalogueDaoImpl
import com.varun.grocerystore.services.CatalogueServices
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfter, FunSuite}

@RunWith(classOf[JUnitRunner])
class CatalogueTests extends FunSuite with BeforeAndAfter {

  val ctlgDao=new CatalogueDaoImpl
  val ctlgSvc = CatalogueServices(ctlgDao)

  before{
    ctlgDao.clearAllItems()
    ctlgSvc.createCatalog()
  }


  test("Tag read is not Empty") {
    assert(ctlgSvc.getTagLength!=0)
  }

  test("Items are being added to Catalogue") {
    val items=ctlgDao.getAllItems.get
    assert(ctlgSvc.addItem(items.head).isRight)
  }

  test("Catalogue is being created or not"){
    assert(ctlgSvc.createCatalog().isRight)
  }


  test("All items are stored in Catalogue") {
    assert(ctlgDao.getAllItems.get.size===ctlgSvc.getTagLength)
  }
}

