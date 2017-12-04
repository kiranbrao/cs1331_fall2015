/**
 * Represents an exception where a musician tries
    to sell his/her/its last instrument
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class LastInstrumentException extends Exception {

    /**
     * Constructs a LastInstrumnetException object using instance variables
     * @param message       The message that appears when the
        exception is caught
     */
    public LastInstrumentException(String message) {
        super(message);
    }
}
