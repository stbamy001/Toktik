
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Toktik {

    /**
     * 
     * @param args
     * @throws FileNotFoundException
     */
    // private static BinarySearchTree<Account> accounts;

    public static void main(String[] args) throws FileNotFoundException {

        Scanner input = new Scanner(System.in);
        BinarySearchTree<Account> accounts = new BinarySearchTree<Account>();

        System.out.println("pick an option");
        System.out.println("1. Find the profile description for a given account");
        System.out.println("2. List all accounts");
        System.out.println("3. Create an account");
        System.out.println("4. Delete an account");
        System.out.println("5. Display all posts for a single account");
        System.out.println("6. Add a new post for an account");
        System.out.println("7. Load a file of actions from disk and process this");
        System.out.println("8. Quit");

        String choice = input.nextLine();

        while (!choice.equals("8")) {

            if (choice.equals("7")) {
                System.out.println("What is the name of the file?");

                String fileName = input.nextLine();
                File file = new File(fileName);
                System.out.println("File action complete");
                if (file.exists()) {
                    Scanner fileReader = new Scanner(file);

                    while (fileReader.hasNextLine()) {
                        String command = fileReader.nextLine();
                        if (command.substring(0, 6).equals("Create")) {
                            int secondSpace = command.indexOf(" ", 8);
                            String name = command.substring(7, secondSpace);
                            String description = command.substring(secondSpace + 1);
                            Account account = new Account(name, description);
                            accounts.insert(account);

                        }

                        if (command.substring(0, 3).equals("Add")) {
                            int secondSpace = command.indexOf(" ", 5);
                            String name = command.substring(4, secondSpace);

                            int endFilename = command.indexOf(" ", secondSpace + 1);
                            String theFilename = command.substring(secondSpace + 1, endFilename);

                            int endLikes = command.indexOf(" ", endFilename + 1);
                            String likes = command.substring(endFilename + 1, endLikes);
                            int numLikes = Integer.parseInt(likes);

                            String title = command.substring(endLikes + 1);
                            Post post = new Post(title, theFilename, numLikes);
                        }

                        // String choice = input.nextLine();
                        choice = "8";

                    }

                } else {
                    System.out.println("File not found");
                    break;
                }

            } else if (choice.equals("1")) {
                // Find the profile description for a given account
                System.out.println("Enter the account name:");
                Scanner n = new Scanner(System.in);
                String accname = input.nextLine();
                Account a = new Account(accname, "");
                System.out.println("The profile description is: " + (accounts.find(a)).data.getDescription());

            }

            else if (choice.equals("2")) {
                // 2. List all accounts
                System.out.println("All accounts: ");
                accounts.inOrder();
            }

            else if (choice.equals("3")) {
                // Create an account
                System.out.println("Enter the name of the account: ");
                Scanner n = new Scanner(System.in);
                String name = n.nextLine();

                System.out.println("Add a description: ");
                Scanner s = new Scanner(System.in);
                String d = s.nextLine();
                Account a = new Account(name, d);
                accounts.insert(a);

            }

            else if (choice.equals("4")) {
                // Delete an account
                System.out.println("Enter the name of the account you would like to delete: ");
                Scanner n = new Scanner(System.in);
                String name = n.nextLine();
                Account a = new Account(name, "");
                accounts.delete(a);

            }

            else if (choice.equals("5")) {
                // Display all posts for a single account
                System.out.println("Enter the name of the account: ");
                Scanner n = new Scanner(System.in);
                String name = n.nextLine();
                Account a = new Account(name, "");
                Account account = accounts.find(a).data;
                account.getPosts();

            }

            else if (choice.equals("6")) {
                // Add a new post for an account
                System.out.println("Enter the name of the account: ");
                Scanner n = new Scanner(System.in);
                String name = n.nextLine();
                System.out.println("Give your post a title: ");
                String title = n.nextLine();
                System.out.println("Add your video: ");
                String video = n.nextLine();

                // Post post = new Post(title, title, 0);
                Account a = new Account(name, "");
                Account account = accounts.find(a).data;
                account.addPost(title, video, 0);

            }

            input = new Scanner(System.in);
            System.out.println("Choose an action from menu");
            System.out.println("1. Find the profile description for a given account");
            System.out.println("2. List all accounts");
            System.out.println("3. Create an account");
            System.out.println("4. Delete an account");
            System.out.println("5. Display all posts for a single account");
            System.out.println("6. Add a new post for an account");
            System.out.println("7. Load a file of actions from disk and process this");
            System.out.println("8. Quit");
            choice = input.nextLine();

        }

        System.out.println("Goodbye!");

    }
}