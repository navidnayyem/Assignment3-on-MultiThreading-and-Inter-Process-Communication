import java.util.Scanner;

class T1 extends Thread {
	public void run(){  
		System.out.println("Thread 1");
		try {
			//lock();
			Thread.sleep(1000);
			//unlock();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	} 
}

class T2 extends Thread {
	public void run(){  
		System.out.println("Thread 2");
		try {
			//lock();
			Thread.sleep(1000);
			//unlock();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	} 
}

class T3 extends Thread {
	public void run(){ 
		System.out.println("Thread 3");
		try {
			//lock();
			Thread.sleep(1000);
			//unlock();
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	} 
}

class SyncSum {
	int sum = 0;
	
	SyncSum (int Sub_Sum, int thread_id) throws InterruptedException
	{
		System.out.println(sum);
		System.out.println(Sub_Sum +" "+ thread_id);
		sum = sum + Sub_Sum;
		Thread.sleep(1000);
		System.out.println(sum);
	}
	synchronized void totalsum() {
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException e) {
	            System.out.println("Interrupted");
	        }
	        System.out.println("]");
	    }
}

public class MultiThreading_and_InterProcessCommunication {
	static int sum = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N,T,i;
		System.out.print("Enter an integer N: ");
		N = Integer.parseInt(input.nextLine());
		System.out.print("Enter an integer T: ");
		T = Integer.parseInt(input.nextLine());
		int array[] = new int[N]; // array of N integers
		for (i = 0; i < N; i++) {
			array[i] = Integer.parseInt(input.nextLine());
		}

		T1 thread1 = new T1(); //thread1
		thread1.start(); //starting thread1
		T2 thread2 = new T2(); //thread2
		thread2.start(); //starting thread2
		T3 thread3 = new T3(); //thread3
		thread3.start(); //starting thread3
	}
}