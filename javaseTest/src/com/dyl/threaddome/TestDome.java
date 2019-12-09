package com.dyl.threaddome;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestDome {

	public static void main(String[] args) {
		/*MyThread myThread = new MyThread();
		FutureTask futureTask =new FutureTask<>(myThread);
		Thread thread = new Thread(futureTask);
		thread.start();
		try {
			System.out.println(futureTask.get());
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		FutureTask<Integer> futureTask2 = new FutureTask<>((Callable<Integer>)()->{return 5;});
		ThreadGroup task = new ThreadGroup("callableThread");
		new Thread(task ,"有返回值的线程").start();
		try {
			System.out.println("线程返回值" + futureTask.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		/**
		 * 	newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
			newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
			newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
			newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
		 */
//		ExecutorService executorService = Executors.newCachedThreadPool(); 
		//newFixedThreadPool(nThread)创建固定数目（nThread）打线程池，且最多有nThread个同时处理。
//      ExecutorService executorService = Executors.newFixedThreadPool(5);
		//创建一个单线程线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行
//      ExecutorService executorService = Executors.newSingleThreadExecutor(); 
//		ScheduledExecutorService newSingleThreadScheduled = Executors.newScheduledThreadPool(int nThread);
		TestDome testDome  = new TestDome();
		//testDome.CachedThreadPoolTest();
		//testDome.newFixedThreadPoolTest();
		testDome.newSingleThreadScheduled();
		
	}
	
	public void newSingleThreadScheduled(){
		ScheduledExecutorService newSingleThreadScheduled = Executors.newScheduledThreadPool(4);
		 System.out.println("****************************newSingleThreadScheduled*******************************");
	        for(int i=0;i<4;i++)
	        {
	            final int index=i;
	            PoolThread poolThread = new PoolThread(index);
	            /**
	             * @param命令执行任务(要执行的线程）
    			 * @param延迟从现在到延迟执行的时间
    			 * @param unit延迟参数的时间单位
	             */
	            newSingleThreadScheduled.schedule(poolThread,3, TimeUnit.SECONDS);
	          //System.out.println(Thread.currentThread().getName());
	        }
	}
	
	public void newFixedThreadPoolTest(){
		ExecutorService newSingleThread = Executors.newSingleThreadExecutor();
		 System.out.println("****************************newSingleThread*******************************");
	        for(int i=0;i<4;i++)
	        {
	            final int index=i;
	            PoolThread poolThread = new PoolThread(index);
	            newSingleThread.execute(poolThread);
	          //System.out.println(Thread.currentThread().getName());
	        }
	}
	
	public void CachedThreadPoolTest(){
		 ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
	        System.out.println("****************************newCachedThreadPool*******************************");
	        for(int i=0;i<4;i++)
	        {
	            final int index=i;
	            PoolThread poolThread = new PoolThread(index);
	          newCachedThreadPool.execute(poolThread);
	          //System.out.println(Thread.currentThread().getName());
	        }
		
	}

}
