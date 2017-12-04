/**
 * Represents all musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public abstract class Instrument {

    private int price;
    private String serialNumber;

    /**
     * Constructs an Instrument object using instance variables
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Instrument(int price, String serialNumber) {
        this.price = price;
        this.serialNumber = serialNumber;
    }

    /**
     * Retrives the price of the instrument
     * @return the number representing the price of the instrument
     */
    public int getPrice() {
        return price;
    }

    /**
     * Retrives the serial number of the instrument
     * @return the string representing the serial number of the instrument
     */
    public String getSerialNumber() {
        return serialNumber;
    }

    /**
     * Connects abstract play method from subclasses to superclass
     * @return a string representing the sound of the instrument
     */
    public abstract String play();

    /**
     * Overrides the equals method to compare object serial numbers
     * @param other  The other object being compared to the current object
     * @return a boolean representing if the objects are equal
        according to the new equals() method
     */
    public boolean equals(Object other) {
        Instrument that = (Instrument) other;
        return (this.getSerialNumber() == that.getSerialNumber());
    }

    /**
     * Overrides the hashCode method to be be consistent
        with overridden equals() method
     * @return an int value for a dummy hashCode overwrite
     */
    public int hashCode() {
        int result = 17;
        result = 31 * result + serialNumber.hashCode();
        return result;
    }

}
