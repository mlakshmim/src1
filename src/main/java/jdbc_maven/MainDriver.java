package jdbc_maven;

import java.util.Scanner;

public class MainDriver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DAO d = new DAO();
		boolean flag = true;
		while (flag) {
			System.out.println("Select Choice");
			System.out.println("1.SavePerson\n2.UpdatePerson\n3.DeletePerson\n4.GetPerson\n5.Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1: {
				// Insert
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter Address");
				String address = sc.next();
				System.out.println("Enter phone");
				Long phone = sc.nextLong();
				System.out.println("Enter pincode");
				int pincode = sc.nextInt();
				String result = d.savePerson(id, name, address, phone, pincode);
				System.out.println(result);
			}
				break;

			case 2: {
				// Update
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				String result1 = d.updatePerson(id, name);
				System.out.println(result1);
			}
				break;

			case 3: {
				// Delete
				System.out.println("Enter id");
				int id = sc.nextInt();

				String result3 = d.deletePerson(id);
				System.out.println(result3);
			}
				break;
			case 4: {
				// Get Person
				System.out.println("Enter id");
				int id = sc.nextInt();
				String result = d.getPerson(id);
				System.out.println(result);
			}
				break;
			case 5: {
				flag = false;
			}
				break;
			default: {
				System.out.println("Enter valid Number");
			}
			}

		}
	}
}
