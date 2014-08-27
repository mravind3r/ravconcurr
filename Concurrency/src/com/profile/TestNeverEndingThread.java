package com.profile;

public class TestNeverEndingThread {

	public static void main(String[] args) {
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run(){
				while(true){
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					System.out.println("....");
					
				}
				
			}
		});
		
		t.start();
	}
	
}
