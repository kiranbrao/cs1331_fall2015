/**
 * Represents an exception where a musician tries to buy an
    instrument with insufficient funds
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class NotEnoughFundsException extends Exception {

    /**
     * Constructs a NotEnoughFundsException object using instance variables
     * @param message       The message that appears when the
        exception is caught
     */
    public NotEnoughFundsException(String message) {
        super(message);
    }
}
