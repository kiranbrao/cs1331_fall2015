/**
 * Represents all instruments of the woodwind
    group extending musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public abstract class Woodwind extends Instrument {

    private int numReeds;

    /**
     * Constructs a Woodwind object using instance variables
     * @param numReeds      The number of reeds on the woodwind instrument
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Woodwind(int numReeds, int price, String serialNumber) {
        super(price, serialNumber);
        this.numReeds = numReeds;
    }

    /**
     * Connects abstract play method from subclasses to superclass
     * @return a string representing the sound of the woodwind instrument
     */
    public abstract String play();

    /**
     * Retrives the number of reeds on the woodwind instrument
     * @return the number of reeds on the woodwind instrument
     */
    public int getNumReeds() {
        return numReeds;
    }
}
