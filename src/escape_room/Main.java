package escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String user = "Cypher";
		String input = "";
		Scanner userIn = new Scanner(System.in);

		System.out.println("Welcome Dr. " + user);

		while (input != "exit") {
			System.out.println("-----------------");
			System.out.println("Type \"logs\" to view available logs, or type the name of the log to open, "
					+ "or type \"exit\" to exit.\n");
			input = userIn.nextLine();
			System.out.println();
			switch (input) {
			case "logs":
				File[] files = new File(user.toLowerCase()).listFiles();
				for (File file : files) {
					System.out.println(file.getName());
				}
				break;
			default:
				System.out.println("Unknown option.");
			}
		}

		userIn.close();

	}

	private void printFile(String fileName) {
		Scanner fileIn;
		try {
			fileIn = new Scanner(new File(fileName));

			while (fileIn.hasNextLine()) {
				System.out.println(fileIn.nextLine());
			}

			fileIn.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
