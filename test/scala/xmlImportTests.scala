import java.io.{File, FileNotFoundException}

import org.scalatest.{BeforeAndAfter, FlatSpec, FunSuite}
import org.junit.{Test, _}
import Assert._
import com.varun.grocerystore.importingXml.Catalogue
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import scala.util.control.Exception
import xml._


@RunWith(classOf[JUnitRunner])
class xmlImportTests extends FunSuite with BeforeAndAfter {

  val obj = new Catalogue
  test("Tag read is not Empty") {
    assert(obj.getTagLength != 0)
  }

  test("List of all items is not empty") {
    assert(obj.mapItems.nonEmpty)
  }

  test("All items are stored in list") {
    assert(obj.mapItems.length == obj.getTagLength)
  }

}

