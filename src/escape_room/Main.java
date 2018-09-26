package escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	private static final String ROOT_PATH = "src" + File.separator + "escape_room" + File.separator;
	
	public static void main(String[] args) {
		String user = "Cypher";
		String input = "";
		Scanner userIn = new Scanner(System.in);

		System.out.println("Welcome Dr. " + user);

		File[] files = new File(ROOT_PATH + user.toLowerCase())
				.listFiles();
		
		while (input != "exit") {
			System.out.println("-----------------");
			System.out.println("Type \"logs\" to view available logs, or type the name of the log to open, "
					+ "or type \"exit\" to exit.\n");
			input = userIn.nextLine();
			System.out.println();
			switch (input) {
			case "logs":
				for (File file : files) {
					String str = file.getName().substring(0, file.getName().indexOf('.'));
					System.out.println(str);
				}
				break;
			case "exit":
				System.out.println("Goodbye");
				input = "exit";
				break;
			default:
				for (File file : files) {
					if (input.equals(file.getName().substring(0, file.getName().indexOf('.')))) {
						printFile(file.getAbsolutePath());
						break;
					}
				}
				
				System.out.println("Unknown option");
			}
		}

		userIn.close();

	}

	private static void printFile(String fileName) {
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
