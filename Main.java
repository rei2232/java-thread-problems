
class MyThread extends Thread {
	    int k;
	    public MyThread(int i) {
	            k = i;
	    }

	    @Override
	    public void run() {
	        //Your Code
	    	 int num, count, i;
	    	    num=1;
	    	    count=0;
	    	 
	    	    while (count < k){
	    	      num=num+1;
	    	      for (i = 2; i <= num; i++){ //Here we will loop from 2 to num
	    	        if (num % i == 0) {
	    	          break;
	    	        }
	    	      }
	    	      if ( i == num){//if it is a prime number
	    	        count = count+1;
	    	      }
	    	    }
	    	    System.out.println("Value of nth prime: " + num);
		
	    }
}
public class Main{

	public static void main(String args[]){  
		int n = 100;
		for(int i=0;i<n;i++) {
				MyThread tmp = new MyThread(i);
				tmp.start();
				try {
					tmp.join(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			
		}
		
	}
}
