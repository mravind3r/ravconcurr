package basics;

public class WaitForFinalization {

	
	public static void main(String[] args) throws InterruptedException {
		System.out.println("starting main thread...");
		NetworkSourcesloader networkSourcesloader = new WaitForFinalization().new NetworkSourcesloader();
		DatasourceLoader datasourceLoader = new WaitForFinalization().new DatasourceLoader();
		
		networkSourcesloader.start();
		networkSourcesloader.join();
		datasourceLoader.start();
		datasourceLoader.join();
		
		System.out.println("ending main thread...");
	}
	
	
	public class DatasourceLoader extends Thread {
		
		public void run(){
			System.out.println("loading data sources...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("finished loading data source...");
		}
	}
	
	
	public class NetworkSourcesloader extends Thread {
		
		public void run(){
			System.out.println("loading network sources...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("finished loading network source...");
		}
			
		
	}
	
	
	
}
