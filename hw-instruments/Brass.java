/**
 * Represents all instruments of the brass group extending musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public abstract class Brass extends Instrument {

    private boolean hasSlide;

    /**
     * Constructs a Brass object using instance variables
     * @param hasSlide      Whether or not the brass instrument has a slide
     * @param price         The price of the instrument
     * @param serialNumber  The serial number of the instrument
     */
    public Brass(boolean hasSlide, int price, String serialNumber) {
        super(price, serialNumber);
        this.hasSlide = hasSlide;
    }

    /**
     * Connects abstract play method from subclasses to superclass
     * @return a string representing the sound of the brass instrument
     */
    public abstract String play();

    /**
     * Retrives whether or not the brass instrument has a slide
     * @return a boolean value representing whether or not the
        brass instrument has a slide
     */
    public boolean getHasSlide() {
        return hasSlide;
    }
}
