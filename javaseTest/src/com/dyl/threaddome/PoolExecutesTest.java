package com.dyl.threaddome;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
/**
 * 线程池的执行方式：
 * 	execute(Runnable runnable);
 *  Future submit(Runnable runnable);
 * 	Future submit(Callable callble):
 * 	submit()可以获取线程的返回值，future.get()得到返回值。Runnable 无返回值，因此返回null
 * 	<T> invokeAny(Callable<T> callables);
 * 	invokeAny获取多个线程中任意一个返回值，如果其中任意一个执行结束或者抛出异常，其他的callable都会被取消。
 * 	List<Future> invokeAll((Callable<T> callables);
 *  invokeAll获取多有callable返回值
 *  线程池的关闭：
 *  shutdown();
 *  shutdownNow();
 *  两者的区别：《interrupt 打断》
 *  	shutdown()只是将空闲的线程interrupt(),之前提交的任务可以继续执行知道结束。
 *  	shutdownNow()是interrupt()所有的线程。因此大部分线程将立刻被打断，之所以不是全部，是因为shutdownNow()能力有限。
 * @author uu
 *
 */
public class PoolExecutesTest {

	public static void main(String[] args) {
		
		ExecutorService singlePool = Executors.newSingleThreadExecutor();
		Set<Callable<String>> callables = new HashSet();
		
		callables.add(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				double b = 2/0;
				return "Callable1 task";
			}
		});
		callables.add(new Callable<String>() {
					
					@Override
					public String call() throws Exception {
						return "Callable2 task";
					}
				});
		callables.add(new Callable<String>() {
			
			@Override
			public String call() throws Exception {
				double b = 2/0;
				return "Callable3 task";
			}
		});
		/*singlePool.execute(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("task");
			}
		});*/
		String string = null;
		try {
			//invokeAny（Callable<type> callable）返回值根据Callable<type>的type
			  string = singlePool.invokeAny(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(string);
		singlePool.shutdown();
	}
	

}

