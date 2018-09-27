package escape_room;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Terminal {

	private static final String SPACER = "-------------";
	
	ArrayList<User> users = new ArrayList<>();
	
	User currentUser;
	
	public Terminal() {
		
		initUsers();
		currentUser = users.get(0);
		
	}
	
	public void run() {
		
		Scanner userIn = new Scanner(System.in);
		
		String input = "";
		Command command = null;
		
		while (true) {
			
			System.out.println(SPACER);
			System.out.println("Type the name of a log to open it or type help for more commands.");
			System.out.println(SPACER);
			input = userIn.nextLine();
			command = Command.getFromCommand(input);
			System.out.println();
			
			if (command == null) {
				for (File file : currentUser.getLogFiles()) {
					if (input.equals(file.getName().substring(0, file.getName().indexOf('.')))) {
						printFile(file.getAbsolutePath());
						break;
					}
				}
				continue;
			}
			
			switch (command) {
			case EXIT:
				System.out.println("Goodbye");
				userIn.close();
				return;
			case HELP:
				Command.printHelp();
				break;
			case LOGS:
				for (File log : currentUser.getLogFiles()) {
					System.out.println(log.getName().substring(0, log.getName().indexOf('.')));
				}
				break;
			case SWITCH:
				userSwitch(userIn);
				break;
			case WHO:
				System.out.println(currentUser.getName());
				break;
			case TOE:
				if (currentUser.isAdmin()) {
					if (attemptToeRelease(userIn)) {
						System.out.println("The password to open the case is MOBO.");
					} else {
						System.out.println("Incorrect password.");
					}
				} else {
					System.out.println("Err: Permission denied");
				}
				break;
			default:
				System.out.println("Unknown command");
				break;
			}
			
		}
		
	}
	
	private void initUsers() {
		users.add(new User("Cypher", "gay"));
		users.add(new User("Caesar", "m@rt1an", true));
	}
	
	private void userSwitch(Scanner scanner) {
		
		String name;
		String pass;
		
		System.out.print("Username: ");
		name = scanner.nextLine();
		
		for (User user : users) {
			if (name.equalsIgnoreCase(user.getName())) {
				
				System.out.print("Password for " + user.getName() + ": ");
				pass = scanner.nextLine();
				
				if (user.checkPass(pass)) {

					System.out.println(SPACER);
					System.out.println("Logged in as " + user.getName());
					currentUser = user;
					
				} else {
					System.out.println("Incorrect password");
				}
				
				return;
				
			}
		}
		
		System.out.println("Unknown user");
		
	}
	
	private boolean attemptToeRelease(Scanner scanner) {
		
		String pass;
		
		System.out.print("Please enter case override password: ");
		pass = scanner.nextLine();
		
		return pass.equalsIgnoreCase("leave");
		
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
