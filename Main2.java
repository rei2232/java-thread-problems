class MyThread extends Thread {
	
    int k;
    public MyThread(int i) {
            k = i;
    }

    @Override
    public void run() {
    	for(int i=0;i<k;k++) {
    		
    	}
    	
    }
	
}
public class Main2 {
	public static void main(String args[]){  
	 
		
		for(int i=0;i<6;i++) {
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
  /*
		int a[][]={{1,1,1},{2,2,2},{3,3,3}};    
		int b[][]={{1,1,1},{2,2,2},{3,3,3}};   
		int c[][]=new int[3][3]; 
		int x = 0;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				c[i][j] = 0;
				for(int k=0;k<3;k++) {
					
					MyThread tmp = new MyThread(x);
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}


*/