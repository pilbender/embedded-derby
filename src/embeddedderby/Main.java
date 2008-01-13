/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedderby;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 *
 * @author Richard Scott Smith
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws IOException {
		// Show menu
		boolean q = true;
		int input;
		Name currentName;

		NameDAO nameDAO = new NameDAO();

		while (q) {
			menu();
			input = readInput();

			switch (input) {
				case 1:
					currentName = setName();
					nameDAO.addName(currentName);
					break;
				case 2:
					currentName = setName();
					currentName = nameDAO.getName(currentName);
					System.out.println();
					System.out.println(currentName);
					System.out.println();
					break;
				case 3:
					currentName = setName();
					nameDAO.updateName(currentName);
					break;
				case 4:
					currentName = setName();
					nameDAO.deleteName(currentName);
					break;
				case 5:
					List<Name> names = nameDAO.getAllNames();
					System.out.println();
					for (int i = 0; i < names.size(); ++i) {
						System.out.println(names.get(i));
					}
					System.out.println();
					break;
				case 6:
					q = false;
					break;
				default:
			}
		}
		System.exit(0);
	}

	public static void menu() throws IOException {
		System.out.println("*** Database Menu ***");
		System.out.println("  1. Insert Name");
		System.out.println("  2. Read Name");
		System.out.println("  3. Update Name");
		System.out.println("  4. Delete Name");
		System.out.println("  5. Return All Names");
		System.out.println("  6. Quit");
		System.out.print("Make a menu selection: ");
		System.out.flush();


	}

	public static int readInput() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int returnValue = (new Integer(input.readLine())).intValue();
		return returnValue;
	}

	public static String readString() throws IOException {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		return input.readLine();
	}

	public static Name setName() throws IOException {
		Name names = new Name();
		System.out.print("Input First Name: ");
		names.setFirstName(readString());
		System.out.print("Input Middle Name: ");
		names.setMiddleName(readString());
		System.out.print("Inpub Last Name: ");
		names.setLastName(readString());

		return names;
	}
}
