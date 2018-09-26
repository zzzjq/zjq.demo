package zjq.test.thread.pcmodel;

import java.util.ArrayList;
import java.util.List;


public class Plate {
	/** 装鸡蛋的盘子*/
	List<Object> eggs = new ArrayList<Object>();
	/** 取鸡蛋*/
	public synchronized Object getEgg(){
		while (eggs.size()==0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		Object egg = eggs.get(0);
		eggs.clear();//清空盘子
		notify();//唤醒阻塞队列的某线程就绪队列
		System.out.println("拿到鸡蛋");
		return egg;
	}
	/** 放鸡蛋*/
	public synchronized void putEgg(Object egg){
		while (eggs.size()>0){
			try{
				wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		eggs.add(egg);//往盘子里面放鸡蛋
		notify();//唤醒阻塞队列的某线程到就绪队列
		System.out.println("放入鸡蛋");
	}
	static class AddThread implements Runnable{
		private Plate plate;
		private Object egg = new Object();
		public AddThread(Plate plate){
			this.plate = plate;
		}
		public void run() {
			plate.putEgg(egg);
		}
	}
	static class GetThread implements Runnable{
		private Plate plate;
//		private Object egg = new Object();
		public GetThread(Plate plate){
			this.plate = plate;
		}
		public void run (){
			plate.getEgg();
		}
	}
	public static void main(String[] args) {

		Plate plate = new Plate();
		for(int i=1;i<10;i++){
			new Thread(new AddThread(plate)).start();
			new Thread(new GetThread(plate)).start();
		}
	}

}
