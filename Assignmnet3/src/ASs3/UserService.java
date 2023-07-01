package ASs3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {
    private List<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public void loadUsersFromFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String username = parts[0].trim();
                String password = parts[1].trim();
                String name = parts[2].trim();
                User user = new User(username, password, name);
                users.add(user);
            }
        }

        scanner.close();
    }

    public User findUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

	public User validateUser(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}

