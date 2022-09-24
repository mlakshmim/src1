package jdbc_maven;

import java.util.List;
import java.util.Scanner;

public class ProductDriver {

	public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
       Product p=new Product();
       ProductDAO pd=new ProductDAO();
       System.out.println("Enetr Number");
       int choice=sc.nextInt();
       switch(choice) {
       case 1:{
    	   System.out.println("Enter pid");
    	   int pid=sc.nextInt();
    	   p.setPid(pid);
    	   System.out.println("Enter Pname");
    	   String pname=sc.next();
    	   p.setPname(pname);
    	   System.out.println("Enter price");
    	   double price=sc.nextDouble();
    	   p.setPrice(price);
    	   System.out.println("Enter manufacture");
    	   String manufacture=sc.next();
    	   p.setManufacture(manufacture);
    	   System.out.println("Enter Discount");
    	   double discount=sc.nextDouble();
    	   p.setDiscount(discount);
    	   System.out.println("Enter warnty");
    	   int warnty=sc.nextInt();
    	   p.setWarnty(warnty);
    	   System.out.println("Enter ManufacturedDate");
    	   String mdate=sc.next();
    	   p.setMdate(mdate);
    	   System.out.println("Enter GSt");
    	   double gst=sc.nextDouble();
    	   p.setGst(gst);
    	   
    	   Product result=pd.saveProduct(p);
    	   System.out.println(result);
    	   break;
       }
       case 2:{
    	   System.out.println("Enter pid");
    	   int pid=sc.nextInt();
    	   p.setPid(pid);
    	   System.out.println("Enter Pname");
    	   String pname=sc.next();
    	   p.setPname(pname);
    	   
    	   Product result=pd.updateProduct(p);
    	   System.out.println(result);
    	   break;
       }
       case 3:{
    	   System.out.println("Enter id");
			int id = sc.nextInt();
			p.setPid(id);
			pd.getProduct(p);
			System.out.println(p.getPid());
			System.out.println(p.getPname());
			System.out.println(p.getPrice());
			System.out.println(p.getManufacture());
			System.out.println(p.getDiscount());
			System.out.println(p.getWarnty());
			System.out.println(p.getMdate());
			System.out.println(p.getGst());
			
			 Product result=pd.getProduct(p);
	    	 System.out.println(result);
	    	 break;
       }
       case 4:{
    	   System.out.println("Enter id");
    	   int id=sc.nextInt();
    	   p.setPid(id);
    	   
    	   String result=pd.deleteProduct(id);
	    	System.out.println(result);
	    	 break;
    	   
       }
       case 5:{
    	   List<Product> result=pd.getAllStudent();
    	   for(Product k:result) {
	    	System.out.println(k);
    	   }
	    	 break;
   	   
       }
       }
	}

}
 