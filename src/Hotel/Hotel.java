package Hotel;

import java.util.Arrays;
import java.util.Random;

public class Hotel {

    Random rand = new Random();
    int one = 1, ten = 10, hundred = 100;
    int resultFloors = rand.nextInt(ten-one) + one;
    int resultRooms = rand.nextInt(hundred-ten) + ten;
    private static int numOfUsedRooms = 0;
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
        this.allRooms = new Room[resultFloors][resultRooms];
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                Random beds = new Random();
                Room myRoom = new Room(beds.nextInt(4)+1);
                allRooms[i][j] = myRoom;
            }
        }
    }

    public int addGuests(Guest[] guestsToAddName) {
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                if (allRooms[i][j].getNumOfAvailableBeds() >= guestsToAddName.length) {
                    if (allRooms[i][j].getNumberOfGuestsInRoom() == 0) {
                        numOfUsedRooms++;
                    }
                    allRooms[i][j].setAllGuests(guestsToAddName);
                    return ((i+1) * 100 + j + 1);
                }
            }
        }
        return -1;
    }

    public int checkByPassportNumber(int byPassNum) {
        Guest[] guests;
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                if (allRooms[i][j].getNumberOfGuestsInRoom() != 0) {
                    guests = allRooms[i][j].getAllGuests();
                    for(Guest passNumGuests : guests) { // for each loop
                        if (byPassNum == passNumGuests.getPassportNumber()) {
                            return ((i+1) * 100 + j + 1);
                        }
                    }
                }
            }
        }
        return -1;
    }

    public int checkFloorsByRooms() {
        int counter, maxCount = 0, floorOfMaxCount = 0;
        for (int i = 0; i < allRooms.length; i++) {
            counter = 0;
            for (int j = 0; j < allRooms[i].length; j++) {
                if (allRooms[i][j].getNumberOfGuestsInRoom() == 0) {
                    counter++;
                }
            }
            if (counter > maxCount) {
                maxCount = counter;
                floorOfMaxCount = i;
            }
        }
        return floorOfMaxCount + 1;
    }

    public void returnAllGuests() {
        for (int i = 0; i < allRooms.length; i++) {
            for (int j = 0; j < allRooms[i].length; j++) {
                if (allRooms[i][j].getNumberOfGuestsInRoom() > 0) {
                    System.out.print("The guests in room " + ((i+1) * 100 + j + 1) + " are: " + Arrays.toString(allRooms[i][j].getAllGuests()) +"\n");
                }
            }
        }
    }
}
