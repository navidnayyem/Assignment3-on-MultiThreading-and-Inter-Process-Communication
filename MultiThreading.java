import java.util.*;

public class SyncSum implements Runnable{
	Thread t;
	ArrayList<Integer> arr;
	int sum = 0;
	public SyncSum (Thread i, ArrayList<Integer> arr) {
		super();
		this.t = i;
		this.arr = arr;
	}

	synchronized public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < arr.size(); i++) {
			sum = sum + arr.get(i);
		}	
		Thread.sleep(1000);
		System.out.println("Thread no."+t+" has a total of:"+sum);
	}
	int getsum () {
		return sum;
	}
	
}

public class MultiThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner ts = new Scanner(System.in);
		System.out.println("Enter the length of the String");
		int string = ts.nextInt();
		ArrayList<Integer> StrL = new ArrayList<Integer>(string);
		System.out.println("Enter elements in the string");
		for (int i = 0; i < string; i++) {
			StrL.add(ts.nextInt());
		}
		System.out.println("Enter the number of the Threads");
		int tha = ts.nextInt();
		ArrayList<Integer> Thr = new ArrayList<Integer>(tha);
		int size = string/tha;
		int k = 0;
		int carry;
		int total=0;
		for (int i=0; i<tha; i++) 
        { 
			for ( int j = 0 ; j < size ; j++) {
				carry = StrL.get(k);
				Thr.set(i, carry);
				k++;
			}
            Thread object = new Thread(new SyncSum (i, Thr)); 
            object.run ();
            total = total + object.getsum ();  
        }
		System.out.println("The total sum:-"+total);

	}

}
