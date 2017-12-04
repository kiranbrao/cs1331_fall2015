/**
 * Represents an exception where a musician tries to buy an instrument
    he/she/it already owns
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class SameSerialNumberException extends Exception {

    /**
     * Constructs a SameSerialNumberException object using instance variables
     * @param message       The message that appears when the
        exception is caught
     */
    public SameSerialNumberException(String message) {
        super(message);
    }
}
