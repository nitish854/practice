package com.threads;

import java.util.concurrent.atomic.AtomicInteger;

public class CustomThreadPool extends Thread{

	static Thread []threads = new Thread[2];
	static Runnable []tasks = new Runnable[10];
	volatile static AtomicInteger counter = new AtomicInteger(0);
	volatile static AtomicInteger index = new AtomicInteger(0);
	
	public void run(){
		while(counter.get() < tasks.length){
			System.out.println("done"+counter +Thread.currentThread().getName());
			tasks[counter.get()].run();
			counter.set(counter.incrementAndGet());
		}
	}
	
	
	

	public static void main(String[] args) {

	
		for(int i=0;i<2;i++){
			threads[i] = new CustomThreadPool();
		}
		
		
		for(int i=0;i<10;i++){
			tasks[i] = new Runnable() {
				@Override
				public void run() {
					System.out.println(index.get());
					index.set(index.incrementAndGet());
				}
			};
		}
		
		for(int i=0;i<2;i++){
			threads[i].start();
		}
		
		
		}
		
		
}
