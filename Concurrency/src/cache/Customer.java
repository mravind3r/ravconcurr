package cache;

public class Customer {

	private int customerId;
	private String name;
	public int getCustomerId() {
		return customerId;
	}
	public String getName() {
		return name;
	}
	
	
	public Customer(int cid,String cname){
		this.customerId = cid;
		this.name = cname;
	}
	
	
	
}
