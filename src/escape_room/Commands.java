package escape_room;

public enum Commands {
	
	HELP("help", "Displays this text."),
	WHO("user", "Prints current user."),
	SWITCH("switch_user", "Allows you to log in as a different user."),
	LOGS("logs", "Display all logs for this user."),
	EXIT("exit", "Exits the program.");
	
	private String command;
	private String message;
	
	private Commands(String command, String message) {
		this.command = command;
		this.message = message;
	}
	
	public static void printHelp() {
		for (Commands command : Commands.values()) {
			System.out.println(command);
		}
	}
	
	public static Commands getFromCommand(String commandStr) {
		for (Commands command : Commands.values()) {
			if (command.getCommand().equalsIgnoreCase(commandStr)) {
				return command;
			}
		}
		
		return null;
	}
	
	public String getCommand() {
		return this.command;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	public String toString() {
		return this.command + ": " + this.message;
	}
	
}
