package day6.shared

object Util {

  def simulateLanternfish(internalTimers: List[Int], days: Int): Long = {
    var lanternfishCounter = List(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L); // day 1, day 2, day 3, ...
    internalTimers.foreach(day => lanternfishCounter = lanternfishCounter.updated(day, lanternfishCounter(day) + 1L));
    for (_ <- 0 until days) {
      println(lanternfishCounter)
      val zeros = lanternfishCounter.head;
      lanternfishCounter = lanternfishCounter.drop(1).appended(zeros);
      lanternfishCounter = lanternfishCounter.updated(6, lanternfishCounter(6) + zeros);
    }
    lanternfishCounter.sum
  }

}
