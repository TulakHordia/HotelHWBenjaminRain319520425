package Hotel;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Hotel Sheraton = new Hotel();

        Scanner input = new Scanner(System.in);

        int choice;

         do {

             System.out.println("-----Hotel Menu-----");
             System.out.println("1. Enter new guests.");
             System.out.println("2. Find a guest by Passport Number.");
             System.out.println("3. Floor details.");
             System.out.println("4. Available rooms.");
             System.out.println("5. Remove guest.");

             System.out.println("Type 11 to Exit.");

             System.out.println("Enter your choice: ");
             choice = input.nextInt();

             switch (choice) {

                 case 1:

                     System.out.println("Amount of guests? (Between 1 and 4)");
                     int amountOfGuests = input.nextInt();
                     input.nextLine();

                     Guest[] guestsInfoName = new Guest[amountOfGuests];
                     Guest[] guestsInfoPassport = new Guest[amountOfGuests];
                     Guest[] guests = new Guest[amountOfGuests];

                     String newGuestName = null;
                     int newGuestPassportNumber = 0;

                     for (int i = 0; i < amountOfGuests; i++) {

                         System.out.printf("Enter Guest %d Name: ", (i + 1));
                         newGuestName = input.nextLine();

                         System.out.printf("Enter Guest %d Passport: ", (i + 1));
                         newGuestPassportNumber = input.nextInt();
                         input.nextLine();

                         guests[i] = new Guest(newGuestName, newGuestPassportNumber);
                     }

                     System.out.println(Sheraton.addGuests(guests));

                     break;

                 case 2:

                     System.out.println("Please enter guests passport number: ");
                     int guestPassportNumber = input.nextInt();

                     Sheraton.checkByPassportNumber(guestPassportNumber);

                     break;

                 case 3:

                 case 4:

                 case 5:

                 case 11:

                     System.out.println("Exiting program...");
                     System.exit(0);
                     break;

                 default:
                     System.out.println("Invalid option, please choose again.");

             }
             System.out.println("\nDo you want to go back to the main menu? (y/n)");
             char resume = input.next().charAt(0);
             if (resume == 'y' || resume == 'Y') {
             } else {
                 System.out.println("Exiting program...");
                 System.exit(0);
             }
         } while (choice != 11);
        System.out.println("Exiting program...Thank you!");
        input.close();
    }
}
