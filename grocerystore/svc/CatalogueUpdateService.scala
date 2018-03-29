package com.varun.grocerystore.svc

import java.util.Calendar
import java.util.concurrent.{Executors, TimeUnit}

import com.varun.grocerystore.model.Item

class CatalogueUpdateService {

  def getHoursUntilTarget(targetHour: Int): Int = {
    val calendar = Calendar.getInstance
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    if (hour <= targetHour) targetHour - hour
    else targetHour - hour + 12
  }

  def updateCatalogue(func: => List[Item]):List[Item] ={    // Lock issues can be there
    val scheduler = Executors.newScheduledThreadPool(1)
    val calendar = Calendar.getInstance
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    var lst:List[Item]=List()
    scheduler.scheduleAtFixedRate(new Runnable {
      override def run(): Unit ={
        lst = func
      }
    }//update time is set to 10 seconds
      , 0,10 , TimeUnit.SECONDS)
    lst
  }

}