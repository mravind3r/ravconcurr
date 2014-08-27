package reservation;

public class Singleton {

	
	private Singleton(){}
	
	
	
	private static volatile Singleton instance = null;
	
	
	public Singleton getinstance(){
		synchronized (this) {
			if(instance==null){
				instance = new Singleton();
			}
		}
		
		
		return instance;
	}
	
	
}
