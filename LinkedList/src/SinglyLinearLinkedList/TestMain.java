package SinglyLinearLinkedList;

import java.util.Scanner;

public class TestMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SinglyList list = new SinglyList();

//		
//		list.addLast(22);
//		
		boolean flag = false;
		while (!flag) {
			try {
				System.out.println("1 => addFirst \n" + "2 => addLast \n" + "3 => add at position\n"  
						+ "4 => delete first \n" + "5 => delete last \n" + "6 => delete at position \n"
						+ "7=>  display\n" + "8 => exit \n ");
				System.out.println("ENTER CHOICE : ");
				int choice = sc.nextInt();

				switch (choice) {
				case 1://addFirst
					System.out.println("Enter value to add first : ");
					int val = sc.nextInt();
					list.addFirst(val);
					break;

				case 2://addLast
					System.out.println("Enter value to add last : ");
					val = sc.nextInt();
					list.addLast(val);

					break;
				case 3://add at position
					System.out.println("Enter value & position : ");
					val = sc.nextInt();
					int position = sc.nextInt();
					list.addAtPosition(val, position);
					break;

				case 4://delete first
					  list.deleteFirst();

					break;
				case 5://delete last
					list.deleteLast();

					break;
				case 6://delete at position
					System.out.println("Enter the node position to delete");
					int pos=sc.nextInt();
					list.deleteAtPosition(pos);

					break;
				case 7://display all node
					list.display();

					break;
				case 8:
					flag = true;
					break;

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

}
