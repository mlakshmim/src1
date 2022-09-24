package jdbc_maven;

import java.util.Scanner;

public class MainDriver1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		DAO1 d1 = new DAO1();
		boolean flag = true;
		while (flag) {
			System.out.println("1.Save Person\n2.Update person\n3.Exit");
			int choice = sc.nextInt();
			switch (choice) {

			case 1: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter Address");
				String address = sc.next();
				System.out.println("Enter phone");
				long phone = sc.nextLong();
				System.out.println("Enter pincode");
				int pincode = sc.nextInt();
				p.setId(id);
				p.setName(name);
				p.setPhone(phone);
				p.setAdress(address);
				p.setPincode(pincode);
				String result = d1.savePerson(p);
				System.out.println(result);
				break;
			}
			case 2: {
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				p.setId(id);
				p.setName(name);

				String result1 = d1.updatePerson(p);
				System.out.println(result1);
				break;
			}
			case 3:
				// Get Person
				System.out.println("Enter id");
				int id = sc.nextInt();
				Person p1=d1.getPerson(id);
				System.out.println(p1.getId());
				System.out.println(p1.getName());
				System.out.println(p1.getAdress());
			
				break;
			default: {
				System.out.println("Enter valid Input");
			}
			}
		}
	}

}
