package com.varun.grocerystore.Services

import java.util.Calendar
import java.util.concurrent.{Executors, TimeUnit}

import com.varun.grocerystore.entities.Item

class CatalogueUpdateService {






  private def getHoursUntilTarget(targetHour: Int) = {
    val calendar = Calendar.getInstance
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    if (hour < targetHour) targetHour - hour
    else targetHour - hour + 24
  }

  def updateCatalogue(func: => List[Item]):List[Item] ={    // Lock issues can be there
    val scheduler = Executors.newScheduledThreadPool(1)
    val calendar = Calendar.getInstance
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    var lst:List[Item]=List()
    scheduler.scheduleAtFixedRate(new Runnable {
      override def run(): Unit = {
        lst=func
      }
    }
    , 10,30 , TimeUnit.SECONDS)
      lst
  }

}
