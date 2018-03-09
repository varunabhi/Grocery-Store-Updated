import java.io.{File, FileNotFoundException}

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite}
import org.junit.{Test, _}
import Assert._
import com.varun.grocerystore.importingXml.importXml
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.util.control.Exception
import xml._


@RunWith(classOf[JUnitRunner])
class xmlImportTests extends FunSuite with BeforeAndAfter {

  val obj=new importXml
  val obj1=new importXml

//  before{
//
//    obj.getAttr()
//  }


  test("Checking xml element returned is not empty"){
    assert(obj.fromXmltoLb().length != 0)
  }

  test("Checking that List Buffer is not Empty"){
    obj.getAttr()
    assert(obj.getListBuffer().size!=0)
  }

  test("Checking that List Buffer contains all elements of XML file"){
    assert(obj.getListBuffer().size===obj.fromXmltoLb().length)
  }

  test("Checking that function clears contents of ListBuffer"){
    obj.clearLb()
    assert(obj.lb.size===0)
  }



  }

