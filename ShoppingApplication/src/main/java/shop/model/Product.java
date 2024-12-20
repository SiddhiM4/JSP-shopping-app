package shop.model;

public class Product {

	private int pid;
	private String pname;
	private float pprice;
	private int pqty;
	public Product(int pid, String pname, float pprice, int pqty) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.pprice = pprice;
		this.pqty = pqty;
	}
	public Product() {
		
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
	public float getPprice() {
		return pprice;
	}
	public void setPprice(float pprice) {
		this.pprice = pprice;
	}
	public int getPqty() {
		return pqty;
	}
	public void setPqty(int pqty) {
		this.pqty = pqty;
	}
	
	
}
