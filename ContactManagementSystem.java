import java.io.*;
import java.util.*;

public class ContactManagementSystem {
    private static final String FILE_PATH = "contacts.txt";
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("===============================");
            System.out.println("CONTACT MANAGEMENT SYSTEM");
            System.out.println("[1] Add contact \n[2] View Contacts \n[3] Update Contact \n[4] Delete Contact \n[5] Exit program");
            System.out.println("===============================");
            System.out.print("Enter Choice: ");
            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 1:
                    addContact(scan);
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact(scan);
                    break;
                case 4:
                    deleteContact(scan);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private static void addContact(Scanner scan) {
        System.out.print("Enter contact name: ");
        String name = scan.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(name);
            writer.newLine();
            System.out.println("Contact added.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void viewContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            if ((line = reader.readLine()) != null) {
                System.out.println("Contacts:");
                do {
                    System.out.println(line);
                } while ((line = reader.readLine()) != null);
            } else {
                System.out.println("Contact List is empty...");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void updateContact(Scanner scan) {
        System.out.print("Enter the name of the contact to update: ");
        String oldName = scan.nextLine();
        System.out.print("Enter the new name: ");
        String newName = scan.nextLine();

        List<String> contacts = readContactsFromFile();
        if (contacts.contains(oldName)) {
            contacts.set(contacts.indexOf(oldName), newName);
            writeContactsToFile(contacts);
            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static void deleteContact(Scanner scan) {
        System.out.print("Enter the name of the contact to delete: ");
        String name = scan.nextLine();

        List<String> contacts = readContactsFromFile();
        if (contacts.remove(name)) {
            writeContactsToFile(contacts);
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    private static List<String> readContactsFromFile() {
        List<String> contacts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                contacts.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return contacts;
    }

    private static void writeContactsToFile(List<String> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String contact : contacts) {
                writer.write(contact);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
