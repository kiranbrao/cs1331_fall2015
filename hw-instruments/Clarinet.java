/**
 * Represents all musical clarinets extending the woodwind group
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class Clarinet extends Woodwind {

    /**
     * Constructs a Clarinet object using instance variables
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Clarinet(int price, String serialNumber) {
        super(1, price, serialNumber);
    }

    /**
     * Plays the sound that correpsonds to the clarinet
     * @return a String representing the sound that comes out of the clarinet
     */
    public String play() {
        return "floodooloodooloo";
    }

    /**
     * Summarizes all the properties used to create a clarinet object
     * @return a String that displays all the properties mentioned above
     */
    public String toString() {
        String reed = "";
        if (getNumReeds() == 0) {
            reed = "reeds";
        } else if (getNumReeds() == 1) {
            reed = "reed";
        } else {
            reed = "reeds";
        }
        return "Clarinet " + getSerialNumber() + " costs $" + getPrice() + ". "
            + "It has " + getNumReeds() + " " + reed + " and makes this sound: "
            + play();
    }
}
