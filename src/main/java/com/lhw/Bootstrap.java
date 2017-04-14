package com.lhw;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * Created by liu.huawei on 2017/4/14.
 */
public class Bootstrap  {
  public static void main(String[] args) throws InterruptedException {
    ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    Thread.sleep(TimeUnit.SECONDS.toMillis(Long.MAX_VALUE));
  }
}
