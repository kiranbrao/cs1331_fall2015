/**
 * Represents an exception where a musician tries to sell an
    instrument that is not owned
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class DontOwnInstrumentException extends Exception {

    /**
     * Constructs a DontOwnInstrumentException object using instance variables
     * @param message       The message that appears when the
        exception is caught
     */
    public DontOwnInstrumentException(String message) {
        super(message);
    }
}
