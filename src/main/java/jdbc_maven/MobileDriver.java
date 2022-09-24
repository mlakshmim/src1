package jdbc_maven;

import java.util.Scanner;

public class MobileDriver {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
       Mobile m=new Mobile();
       MobileDAO md=new MobileDAO();
       boolean flag = true;
		while (flag) {
			System.out.println("Select Choice");
			System.out.println("1.Save Mobile\n2.Update Mobile\n3.getMobile\n4.Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:{
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter brand");
				String brand = sc.next();
				System.out.println("Enter colour");
				String colour = sc.next();
				System.out.println("Enter price");
				Double price=sc.nextDouble();
				System.out.println("Enter ram");
				int ram = sc.nextInt();
				System.out.println("Enter manufacturer");
				String manufacturer = sc.next();
				m.setId(id);
				m.setName(name);
				m.setBrand(brand);
				m.setColour(colour);
				m.setPrice(price);
				m.setRam(ram);
				m.setManufacturer(manufacturer);
				String result = md.saveMobile(m);
				System.out.println(result);
				break;
			}
			case 2: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				m.setId(id);
				m.setName(name);

				String result1 = md.updateMobile(m);
				System.out.println(result1);
				break;
			}
			case 3:{
				System.out.println("Enter id");
				int id = sc.nextInt();
				Mobile m1=md.getMobile(id);
				System.out.println(m1.getId());
				System.out.println(m1.getName());
				System.out.println(m1.getBrand());
				System.out.println(m1.getColour());
				System.out.println(m1.getPrice());
				System.out.println(m1.getRam());
				System.out.println(m1  .getManufacturer());
			
				break;
			}
			}
		}
	}

}
