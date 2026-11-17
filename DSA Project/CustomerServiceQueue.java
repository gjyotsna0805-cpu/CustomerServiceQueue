import java.io.*;
import java.util.*;

public class CustomerServiceQueue {

  // Customer class
  static class Customer {
    String token;
    String name;
    String service;

    Customer(String token, String name, String service) {
      this.token = token;
      this.name = name;
      this.service = service;
    }
  }

  // Node class for Linked List
  static class Node {
    Customer data;
    Node next;

    Node(Customer data) {
      this.data = data;
      this.next = null;
    }
  }

  // Queue implementation
  static class CustomerQueue {

    Node front, rear;
    int size = 0;
    int nextToken = 101;

    // Join Queue
    void joinQueue(String name, String service) {

      String token = "Q" + nextToken++;

      Customer customer = new Customer(token, name, service);
      Node newNode = new Node(customer);

      int peopleAhead = size;

      if (front == null) {
        front = rear = newNode;
      } else {
        rear.next = newNode;
        rear = newNode;
      }

      size++;

      System.out.println("Token issued.");
      System.out.println(token + " | " + name + " | "
          + service + " | People ahead: " + peopleAhead);

      saveToFile();
    }

    // Call Next Customer
    void callNextCustomer() {

      if (front == null) {
        System.out.println("Queue is empty.");
        return;
      }

      Customer customer = front.data;

      System.out.println("Now serving: " + customer.token
          + " | " + customer.name);

      front = front.next;
      size--;

      if (front == null) {
        rear = null;
        System.out.println("Queue is now empty.");
      } else {
        System.out.println("Remaining in queue: " + size);
      }

      saveToFile();
    }

    // Display Queue
    void displayQueue() {

      if (front == null) {
        System.out.println("Queue is empty.");
        return;
      }

      Node temp = front;
      int position = 1;

      System.out.println("Customer Queue:");

      while (temp != null) {

        Customer c = temp.data;

        System.out.println(position + ". " + c.token
            + " | " + c.name
            + " | " + c.service);

        temp = temp.next;
        position++;
      }
    }

    // Leave Queue using Token
    void leaveQueue(String token) {

      if (front == null) {
        System.out.println("Queue is empty.");
        return;
      }

      Node temp = front;
      Node previous = null;

      while (temp != null) {

        if (temp.data.token.equalsIgnoreCase(token)) {

          if (previous == null) {
            front = temp.next;
          } else {
            previous.next = temp.next;
          }

          if (temp == rear) {
            rear = previous;
          }

          size--;

          System.out.println("Token " + token
              + " removed from the queue.");

          saveToFile();
          return;
        }

        previous = temp;
        temp = temp.next;
      }

      System.out.println("Token " + token + " not found.");
    }

    // Load Queue from File
    void loadFromFile() {

      File file = new File("customers.txt");

      if (!file.exists()) {
        return;
      }

      try (BufferedReader br = new BufferedReader(
          new FileReader(file))) {

        String line;

        while ((line = br.readLine()) != null) {

          if (line.startsWith("NEXT_TOKEN=")) {
            nextToken = Integer.parseInt(
                line.substring("NEXT_TOKEN=".length()));
            continue;
          }

          String[] data = line.split("\\|", 3);

          if (data.length == 3) {

            String token = data[0].trim();
            String name = data[1].trim();
            String service = data[2].trim();

            Customer customer = new Customer(token, name, service);

            Node newNode = new Node(customer);

            if (front == null) {
              front = rear = newNode;
            } else {
              rear.next = newNode;
              rear = newNode;
            }

            size++;

            // Maintain correct token sequence
            try {
              int number = Integer.parseInt(
                  token.substring(1));

              nextToken = Math.max(nextToken, number + 1);

            } catch (NumberFormatException | StringIndexOutOfBoundsException e) {
              System.out.println(
                  "Skipping invalid token: " + token);
            }
          }
        }

        System.out.println("Customer data loaded successfully.");

      } catch (IOException | NumberFormatException e) {
        System.out.println("Error loading file: " + e.getMessage());
      }
    }

    // Save Queue to File
    void saveToFile() {

      try (PrintWriter writer = new PrintWriter(
          new FileWriter("customers.txt"))) {

        writer.println("NEXT_TOKEN=" + nextToken);

        Node temp = front;

        while (temp != null) {

          Customer c = temp.data;

          writer.println(c.token + "|"
              + c.name + "|"
              + c.service);

          temp = temp.next;
        }

      } catch (IOException e) {
        System.out.println("Error saving file: " + e.getMessage());
      }
    }
  }

  // Main Method
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    CustomerQueue queue = new CustomerQueue();

    // Load previously saved customers
    queue.loadFromFile();

    int choice = sc.nextInt();

    do {

      System.out.println("\n===== CUSTOMER SERVICE QUEUE =====");
      System.out.println("1. Join Queue");
      System.out.println("2. Call Next Customer");
      System.out.println("3. Display Queue");
      System.out.println("4. Leave Queue");
      System.out.println("5. Exit");

      System.out.print("Enter your choice: ");

      try {
        choice = Integer.parseInt(sc.nextLine().trim());
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Enter a number.");
        continue;
      }

      switch (choice) {

        case 1:
          System.out.print("Enter Customer Name: ");
          String name = sc.nextLine().trim();

          System.out.print("Enter Service Required: ");
          String service = sc.nextLine().trim();

          if (name.isEmpty() || service.isEmpty()) {
            System.out.println(
                "Name and service cannot be empty.");
          } else {
            queue.joinQueue(name, service);
          }
          break;

        case 2:
          queue.callNextCustomer();
          break;

        case 3:
          queue.displayQueue();
          break;

        case 4:
          System.out.print("Enter Token Number: ");
          String token = sc.nextLine().trim();

          queue.leaveQueue(token);
          break;

        case 5:
          queue.saveToFile();
          System.out.println("Data saved successfully.");
          System.out.println("Thank you for using the system!");
          break;

        default:
          System.out.println(
              "Invalid choice. Please select 1 to 5.");
      }

    } while (choice != 5);

    sc.close();
  }
}