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

    public Room(Room other) {
        this.numOfBeds = other.numOfBeds;
    }

    public void setNumOfBeds(int numOfBeds) {
        if (numOfBeds > 4 || 0 >= numOfBeds) {
            System.out.println("4 beds max.");
        }
        else {
            this.numOfBeds = numOfBeds;
        }
    }

    public void setAllGuests(Guest[] allGuests) {
        this.allGuests = allGuests;
    }

    public int getNumOfBeds() {
        return this.numOfBeds;
    }

    public int getNumberOfGuestsInRoom() {
        int counter = 0;
        if (this.allGuests == null) {
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

    public void insertGuest(Guest guest) {
        for (int i = 0; i < allGuests.length; i++) {
            if (allGuests[i].getName() == null) {
                allGuests[i].setName(guest.getName());
                allGuests[i].setPassportNumber(guest.getPassportNumber());
                return;
            }
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
