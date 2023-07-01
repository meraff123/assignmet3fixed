package ASs3;

import java.io.IOException;
import java.util.Scanner;

public class UserLoginApplication {
	public User[] users = new User[4]; 
	private UserService userService = new UserService();
	
	UserService userArrayService = new UserService();

	public static void main(String[] args) throws IOException {
		UserLoginApplication a3uv = new UserLoginApplication();
		a3uv.doWork();
		
	}
	
	public void doWork () throws IOException {
		
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			
			boolean validLogin = false;
			int loginAttempts = 0;
			while (!validLogin && loginAttempts < 5) {
				System.out.println("Enter your email: ");
				String username = scanner.nextLine();
				System.out.println("Enter your password: ");
				String password = scanner.nextLine();

				User validUser = userService.validateUser(username, password);
				if (validUser != null) {
					System.out.println("Welcome: " + validUser.getName());
					validLogin = true;
				} else {
					System.out.println("Invalid login, please try again");
					loginAttempts++;
					if (loginAttempts == 5) {
						System.out.println("Too many failed login attempts, you are now locked out.");
					}
				}
			}
		} finally {
			if (scanner != null)
				scanner.close();
		}
	
	}
}
