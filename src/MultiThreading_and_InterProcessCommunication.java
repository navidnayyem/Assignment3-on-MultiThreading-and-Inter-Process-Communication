import java.util.ArrayList;
import java.util.Scanner;

class SyncSum implements Runnable{
	int sum = 0;
	Thread th;
	ArrayList<Integer> sub_sum;
	
	public SyncSum(ArrayList<Integer> sub_sum,Thread th) {
		super();
		this.sub_sum = sub_sum;
		this.th = th;
	}
	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public Thread getTh() {
		return th;
	}

	public void setTh(Thread th) {
		this.th = th;
	}

	public ArrayList<Integer> getSub_sum() {
		return sub_sum;
	}

	public void setSub_sum(ArrayList<Integer> sub_sum) {
		this.sub_sum = sub_sum;
	}

	synchronized public void run() {
		try {
			System.out.println(sum);
			System.out.println(sub_sum +" "+ th);
			for (int i = 0; i < sub_sum.size(); i++) {
				sum = sum + sub_sum.get(i);
			}
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Total Sum of Thread "+ th + ":" + sum);
	}
}

public class MultiThreading_and_InterProcessCommunication {
	public static void main(String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
	
		int i;
		int totalsum = 0;
		
		System.out.print("Enter an integer N: ");
		int N = Integer.parseInt(input.nextLine());
		System.out.print("Enter an integer T: ");
		int T = Integer.parseInt(input.nextLine());
		
		int array[] = new int[N]; // array of N integers
		
		if (N % T == 0) { // checks whether N is divisible by T
			
			System.out.println("\nEnter " + N + " Integer Numbers: ");
			
			for (i = 0; i < N; i++) {
				array[i] = Integer.parseInt(input.nextLine());
			}
			
			for (i = 0; i < T; i++) {
				Thread thread = new Thread(); //Creating T threads to calculate the sum of N subarrays
				thread.start(); //starting thread
	            //totalsum = totalsum + SyncSum.getsum(); //couldn't find out total sum
	        }		
			System.out.println("The Total Sum of All Threads: " + totalsum);
		} else {
			System.out.println(N + " is not divisible by " + T);
		}
	}
}