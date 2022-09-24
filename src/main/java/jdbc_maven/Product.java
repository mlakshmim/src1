package jdbc_maven;

public class Product {
	
	private int pid;
	private String pname;
	private double price;
	private String manufacture;
	private double discount;
	private int warnty;
	private String mdate;
	private double gst;
	public Product(int pid, String pname, double price, String manufacture, double discount, int warnty, String mdate,
			double gst) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.price = price;
		this.manufacture = manufacture;
		this.discount = discount;
		this.warnty = warnty;
		this.mdate = mdate;
		this.gst = gst;
	}
	public Product() {
		
	}
	 
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", manufacture=" + manufacture
				+ ", discount=" + discount + ", warnty=" + warnty + ", mdate=" + mdate + ", gst=" + gst + "]";
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacture() {
		return manufacture;
	}
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWarnty() {
		return warnty;
	}
	public void setWarnty(int warnty) {
		this.warnty = warnty;
	}
	public String getMdate() {
		return mdate;
	}
	public void setMdate(String mdate) {
		this.mdate = mdate;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	
	
	
	
	

}
