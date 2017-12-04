/**
 * Represents all instruments of the
    percussion group extending musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public abstract class Percussion extends Instrument {

    private int drumDiameter;

    /**
     * Constructs a Percussion object using instance variables
     * @param drumDiameter  The diameter of the percussion instrument
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Percussion(int drumDiameter, int price, String serialNumber) {
        super(price, serialNumber);
        this.drumDiameter = drumDiameter;
    }

    /**
     * Connects abstract play method from subclasses to superclass
     * @return a string representing the sound of the precussion instrument
     */
    public abstract String play();

    /**
     * Retrives the diameter of the drum
     * @return the number representing the diameter of the drum in inches
     */
    public int getDrumDiameter() {
        return drumDiameter;
    }
}
