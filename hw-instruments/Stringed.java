/**
 * Represents all instruments of the string group extending musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public abstract class Stringed extends Instrument {

    private int numStrings;

    /**
     * Constructs a Stringed object using instance variables
     * @param numStrings    The number of strings on the stringed instrument
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Stringed(int numStrings, int price, String serialNumber) {
        super(price, serialNumber);
        this.numStrings = numStrings;
    }

    /**
     * Connects abstract play method from subclasses to superclass
     * @return a string representing the sound of the stringed instrument
     */
    public abstract String play();

    /**
     * Retrives the number of strings on the stringed instrument
     * @return the number of strings on the stringed instrument
     */
    public int getNumStrings() {
        return numStrings;
    }
}
