package escape_room;

public enum Command {
	
	HELP("help", "Displays this text."),
	WHO("whoami", "Prints current user."),
	USERS("users", "Prints users on the current system."),
	SWITCH("switch_user", "Allows you to log in as a different user."),
	LOGS("logs", "Display all logs for this user."),
	TOE("unlock_toe", "Admin only. Allows access to the T.O.E."),
	EXIT("exit", "Exits the program.");
	
	private String command;
	private String message;
	
	private Command(String command, String message) {
		this.command = command;
		this.message = message;
	}
	
	public static void printHelp() {
		for (Command command : Command.values()) {
			System.out.println(command);
		}
	}
	
	public static Command getFromCommand(String commandStr) {
		for (Command command : Command.values()) {
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
