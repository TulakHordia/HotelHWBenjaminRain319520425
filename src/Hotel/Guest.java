package Hotel;

public class Guest {

    private String name;
    private int passportNumber;

    public Guest(String name, int passportNumber) {
        this.name = name;
        this.passportNumber = passportNumber;
    }

    public Guest() {
        this(null, 0);
    }

    public Guest(Guest other) {
        this.name = other.name;
        this.passportNumber = other.passportNumber;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassportNumber() {
        return this.passportNumber;
    }

    public void setPassportNumber(int passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String toString() {
        return "Name: " + this.name + " Passport Number: " + this.passportNumber;
    }
}
