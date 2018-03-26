//import java.util.Calendar
//
//import com.varun.grocerystore.Model.{Catalogue, Item}
//import com.varun.grocerystore.Services.{CatalogueServices, CatalogueUpdateService}
//import org.junit.runner.RunWith
//import org.scalatest.FunSuite
//import org.scalatest._
//import org.scalatest.junit.JUnitRunner
//
//
//@RunWith(classOf[JUnitRunner])
//class schedulerTest extends FunSuite with BeforeAndAfter {
//
//
//  val obj_ctlg=new Catalogue
//  val obj_ctlgServ=new CatalogueServices(obj_ctlg)
//  val obj_updCtl=new CatalogueUpdateService
//    val lst_items: List[Item] =obj_ctlgServ.addToCatalog().get
//  val hour: Int =Calendar.HOUR_OF_DAY
//
//  test("Test GetHours Function"){
//
//    assert(obj_updCtl.getHoursUntilTarget(11)==11-hour)
//  }
//
//  test("To test update service"){
//    val init_len=obj_ctlgServ.addToCatalog(obj_ctlg).length
//    Thread.sleep(15000)
//    val post_length=obj_ctlgServ.updateCatalogue(obj_ctlg).length
//    assert(init_len!=post_length)
//  }
//}
