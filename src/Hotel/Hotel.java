package Hotel;

import java.util.Arrays;
import java.util.Random;

public class Hotel {

    private static int numOfUsedRooms = 0;
    private static int floors = 9;
    private static int rooms = 90;
    private Room[][] allRooms;

    public static int getNumOfUsedRooms() {
        return numOfUsedRooms;
    }

    public void setNumOfUsedRooms(int numOfUsedRooms) {
        this.numOfUsedRooms = numOfUsedRooms;
    }

    public Room[][] getAllRooms() {
        return allRooms;
    }

    public void setAllRooms(Room[][] allRooms) {
        this.allRooms = allRooms;
    }

    public Hotel() {
        this.allRooms = new Room[floors][rooms];
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                Random beds = new Random();
                Room myRoom = new Room(beds.nextInt(4)+1);
                System.out.println("[" + i + "]" + "[" + j + "]" + myRoom);
                allRooms[i][j] = myRoom;
            }
        }
    }

    public int addGuests(Guest[] guestsToAddName) {
        Room numOfGuests = new Room(getNumOfUsedRooms());
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                if (allRooms[i][j].getNumOfAvailableBeds() >= guestsToAddName.length) {
                    if (allRooms[i][j].getNumberOfGuestsInRoom() == 0) {
                        numOfUsedRooms++;
                    }
                    for (int k = 0; k < guestsToAddName.length; k++) {
                        allRooms[i][j].insertGuest(guestsToAddName[k]);
                    }
                    return ((i+1) * 100 + j + 1);
                }
            }
        }
        return -1;
    }

    public void checkByPassportNumber(int byPassNum) {
        Guest passportNumCheck = new Guest();
        Room checkByRoom = new Room(getNumOfUsedRooms());
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                if (checkByRoom.getNumberOfGuestsInRoom() > 0) {
                    if (boolean containsId = Arrays.(passportNumCheck.getPassportNumber())) {

                    }
                    if (allRooms[i][j].equals(byPassNum)) {

                    }
                }
                //if (byPassNum == passportNumCheck.getPassportNumber()) {;
                //    System.out.println("Test3");
                //    System.out.println("Your guest resides in room: " );
                //}
            }
        }
    }
}
