/**
 * Represents all musical guitars extending the string group
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class Guitar extends Stringed {

    /**
     * Constructs a Guitar object using instance variables
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Guitar(int price, String serialNumber) {
        super(6, price, serialNumber);
    }

    /**
     * Plays the sound that correpsonds to the guitar
     * @return a String representing the sound that comes out of the guitar
     */
    public String play() {
        return "dowdowdowdowbrrrow";
    }

    /**
     * Summarizes all the properties used to create a guitar object
     * @return a String that displays all the properties mentioned above
     */
    public String toString() {
        String strings = "";
        if (getNumStrings() == 0) {
            strings = "strings";
        } else if (getNumStrings() == 1) {
            strings = "string";
        } else {
            strings = "strings";
        }

        return "Guitar " + getSerialNumber() + " costs $" + getPrice() + ". "
            + "It has " + getNumStrings() + " " + strings
            + " and makes this sound: " + play();
    }
}
