package Hotel;

public class Room {

    private int numOfBeds;
    private Guest[] allGuests;

    public Room(int numOfBeds) {
        this.numOfBeds = numOfBeds;
        allGuests = new Guest[numOfBeds];
        for (int i = 0; i < allGuests.length; i++) {
            allGuests[i] = new Guest();
        }
    }

    public Room() {

    }

    public void setAllGuests(Guest[] allGuests) {
        this.allGuests = allGuests;
    }

    public int getNumOfBeds() {
        return this.numOfBeds;
    }

    public int getNumberOfGuestsInRoom() {
        int counter = 0;
        if (allGuests == null) {
            return 0;
        }
        else {
            for (int i = 0; i < allGuests.length; i++) {
                if (allGuests[i].getName() != null) {
                    counter++;
                }
            }
            return counter;
        }
    }

    public int getNumOfAvailableBeds() {
        return this.getNumOfBeds() - this.getNumberOfGuestsInRoom();
    }

    public Guest[] getAllGuests() {
        return this.allGuests;
    }

    public String toString() {
        StringBuilder bedsNumber = new StringBuilder("Number of available beds: " + this.numOfBeds);
        for (int i = 0; i < this.allGuests.length; i++) {
            if (i == 0) {
                bedsNumber.append(" Guests: ").append(this.allGuests.length);
            }
            bedsNumber.append(" ").append(this.allGuests[i].toString());
        }
        return bedsNumber.toString();
    }
}
