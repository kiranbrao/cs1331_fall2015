/**
 * Represents all musical snare drums extending the percussion group
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class Snare extends Percussion {

    /**
     * Constructs a Snare object using instance variables
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Snare(int price, String serialNumber) {
        super(14, price, serialNumber);
    }

    /**
     * Plays the sound that correpsonds to the snare drum
     * @return a String representing the sound that comes out of the snare drum
     */
    public String play() {
        return "ddddDDDDdddDDDDD";
    }

    /**
     * Summarizes all the properties used to create a snare drum object
     * @return a String that displays all the properties mentioned above
     */
    public String toString() {
        String diameter = "";
        if (getDrumDiameter() == 0) {
            diameter = "inches";
        } else if (getDrumDiameter() == 1) {
            diameter = "inch";
        } else {
            diameter = "inches";
        }
        return "Snare " + getSerialNumber() + " costs $" + getPrice() + ". "
            + "It has a diameter of " + getDrumDiameter() + " inches"
            + " and makes this sound: " + play();
    }
}
