import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String emailAddress;

    public Contact(String name, String phoneNumber, String emailAddress) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + emailAddress;
    }
}

public class ContactManager {
    private List<Contact> contactList;
    private Scanner scanner;

    public ContactManager() {
        contactList = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addContact(String name, String phoneNumber, String emailAddress) {
        Contact contact = new Contact(name, phoneNumber, emailAddress);
        contactList.add(contact);
        System.out.println("Contact added: " + contact);
    }

    public void viewContacts() {
        if (contactList.isEmpty()) {
            System.out.println("Contact list is empty.");
        } else {
            System.out.println("Contact List:");
            for (Contact contact : contactList) {
                System.out.println(contact);
            }
        }
    }

    public void editContact(int index, String phoneNumber, String emailAddress) {
        if (index >= 0 && index < contactList.size()) {
            Contact contact = contactList.get(index);
            contact.setPhoneNumber(phoneNumber);
            contact.setEmailAddress(emailAddress);
            System.out.println("Contact updated: " + contact);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void deleteContact(int index) {
        if (index >= 0 && index < contactList.size()) {
            Contact contact = contactList.remove(index);
            System.out.println("Contact deleted: " + contact);
        } else {
            System.out.println("Invalid index.");
        }
    }

    public static void main(String[] args) {
        ContactManager contactManager = new ContactManager();
        int choice;

        do {
            System.out.println("\nContact Manager Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Edit Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = contactManager.scanner.nextInt();
            contactManager.scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = contactManager.scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = contactManager.scanner.nextLine();
                    System.out.print("Enter Email Address: ");
                    String emailAddress = contactManager.scanner.nextLine();
                    contactManager.addContact(name, phoneNumber, emailAddress);
                    break;
                case 2:
                    contactManager.viewContacts();
                    break;
                case 3:
                    System.out.print("Enter the index of the contact to edit: ");
                    int editIndex = contactManager.scanner.nextInt();
                    contactManager.scanner.nextLine(); // Consume newline
                    System.out.print("Enter new Phone Number: ");
                    String newPhoneNumber = contactManager.scanner.nextLine();
                    System.out.print("Enter new Email Address: ");
                    String newEmailAddress = contactManager.scanner.nextLine();
                    contactManager.editContact(editIndex, newPhoneNumber, newEmailAddress);
                    break;
                case 4:
                    System.out.print("Enter the index of the contact to delete: ");
                    int deleteIndex = contactManager.scanner.nextInt();
                    contactManager.deleteContact(deleteIndex);
                    break;
                case 5:
                    System.out.println("Exiting Contact Manager.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}
