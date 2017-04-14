package com.lhw.metrics;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

import com.yammer.metrics.Metrics;
import com.yammer.metrics.core.Counter;
import com.yammer.metrics.reporting.ConsoleReporter;

/**
 * TODO
 *
 */
public class TestCounter {

  private final Counter pendingJobs = Metrics.newCounter(TestCounter.class, "pending-jobs");
  private final Queue<String> queue = new LinkedList<String>();

  public void add(String str) {
    pendingJobs.inc();
    queue.offer(str);
  }

  public String take() {
    pendingJobs.dec();
    return queue.poll();
  }

  /**
   * TODO
   *
   * @param args void
   */
  public static void main(String[] args) throws InterruptedException {
    TestCounter tc = new TestCounter();
    ConsoleReporter.enable(1, TimeUnit.SECONDS);
    while (true) {
      tc.add("1");
      Thread.sleep(1000);
    }
  }

}
