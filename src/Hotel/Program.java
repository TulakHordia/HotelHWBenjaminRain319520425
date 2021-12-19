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
            System.out.println("3. All Guests.");
            System.out.println("4. Available rooms.");

            System.out.println("Type 11 to Exit.");

            System.out.println("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Amount of guests? (Between 1 and 4)");
                    int amountOfGuests = input.nextInt();
                    while (amountOfGuests < 1 || amountOfGuests > 4) {
                        System.out.println("Please try again, guests between 1 and 4 only: ");
                        amountOfGuests = input.nextInt();
                    }
                    input.nextLine();

                    Guest[] guests = new Guest[amountOfGuests];

                    String newGuestName = null;
                    int newGuestPassportNumber = 0;

                    for (int i = 0; i < amountOfGuests; i++) {

                        System.out.printf("Enter Guest %d Name: ", (i + 1));
                        newGuestName = input.nextLine();

                        System.out.printf("Enter Guest %d Passport: ", (i + 1));
                        newGuestPassportNumber = input.nextInt();
                        input.nextLine();

                        while (newGuestPassportNumber < 1) {
                            System.out.println("Please type the guests Passport number again: ");
                            newGuestPassportNumber = input.nextInt();
                            input.nextLine();
                        }
                        guests[i] = new Guest(newGuestName, newGuestPassportNumber);
                    }

                    System.out.println(Sheraton.addGuests(guests));

                    break;

                case 2:

                    System.out.println("Please enter guests passport number: ");
                    int guestPassportNumber = input.nextInt();
                    int check = Sheraton.checkByPassportNumber(guestPassportNumber);
                    System.out.println(check);

                    break;

                case 3:

                    Sheraton.returnAllGuests();
                    break;

                case 4:

                    System.out.println("The floor #" + Sheraton.checkFloorsByRooms() + " has the most available rooms.");
                    break;

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
