package escape_room;

import java.io.File;

public class User {

	private static final String ROOT_PATH = "resources" + File.separator;

	private boolean admin;
	private String username;
	private String password;

	public User(String username, String password) {
		this(username, password, false);
	}

	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
	}

	public String getName() {
		return this.username;
	}

	public boolean isAdmin() {
		return this.admin;
	}

	public File[] getLogFiles() {
		return new File(ROOT_PATH + this.username.toLowerCase()).listFiles();
	}

	public String getResource(String fileName) {
		return ROOT_PATH + fileName;
	}

	public boolean checkPass(String password) {
		return password.equals(this.password);
	}

}
