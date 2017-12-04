/**
 * Represents all musical trombones extending the brass group
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class Trombone extends Brass {

    /**
     * Constructs a Trombone object using instance variables
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Trombone(int price, String serialNumber) {
        super(true, price, serialNumber);
    }

    /**
     * Plays the sound that correpsonds to the trombone
     * @return a String representing the sound that comes out of the trombone
     */
    public String play() {
        return "brawwwwmpBWAAAAA";
    }

    /**
     * Summarizes all the properties used to create a trombone object
     * @return a String that displays all the properties mentioned above
     */
    public String toString() {
        String slidePresent = "";
        if (!getHasSlide()) {
            slidePresent = "does not have";
        } else {
            slidePresent = "does have";
        }
        return "Trombone " + getSerialNumber() + " costs $" + getPrice()
            + ". " + "It " + slidePresent + " a slide"
            + " and makes this sound: " + play();
    }
}
