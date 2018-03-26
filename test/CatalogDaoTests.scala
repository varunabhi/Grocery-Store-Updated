import com.varun.grocerystore.dao.CatalogueDaoImpl
import org.junit.runner.RunWith
import org.scalatest._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CatalogDaoTests extends FunSuite{

  val ctlgDao=new CatalogueDaoImpl

  test("Dao is Empty"){
    assert(ctlgDao.getAllItems.isFailure)
  }
}
