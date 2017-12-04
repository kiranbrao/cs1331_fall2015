import java.util.ArrayList;

/**
 * Represents all players of musical instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class Musician {

    private String name;
    private ArrayList<Instrument> instruments;
    private int funds;

    /**
     * Constructs a Musician object using instance variables
     * @param name          The name of the musician
     * @param instruments   The instruments that the musician owns
     * @param funds         The amount of funds the musician has
     */
    public Musician(String name, ArrayList<Instrument> instruments, int funds) {
        this.name = name;
        this.instruments = instruments;
        this.funds = funds;
    }

   /**
     * Retrieves the instance variable representing the musician's name
     * @return a String of the musician's name
     */
    public String getName() {
        return name;
    }

    /**
     * Displays a musicians current instruments from their instrument array
     */
    public void getInstruments() {
        for (Instrument i : instruments) {
            System.out.println(i.getSerialNumber());
        }
    }

    /**
     * Sets the musician's funds to the parameter value
     * @param newFunds The value representing the musician's new funds
     */
    public void setFunds(int newFunds) {
        funds = newFunds;
    }

    /**
     * Retrieves the instance variable representing the musician's funds
     * @return The value representing the musician's current funds
     */
    public int getFunds() {
        return funds;
    }

    /**
     * Allows a musician to purchase an instrument by subtracting
        funds and adding it to his/her/its collection
     * @param purchasedInstrument        The instrument being bought
     * @throws NotEnoughFundsException   If the instrument costs
        more than available funds
     * @throws SameSerialNumberException If the musician already
        owns the instrument
     */
    public void buyInstrument(Instrument purchasedInstrument)
        throws NotEnoughFundsException, SameSerialNumberException {
        int currentFunds;
        if (this.getFunds() < purchasedInstrument.getPrice()) {
            throw new NotEnoughFundsException("This musician does not"
                + " have enough money for this instrument");
        }
        for (Instrument instrument : instruments) {
            if (instrument.equals(purchasedInstrument)) {
                throw new SameSerialNumberException("This musician already"
                + " owns this instrument");
            }
        }

        currentFunds = this.getFunds() - purchasedInstrument.getPrice();
        setFunds(currentFunds);
        instruments.add(purchasedInstrument);
    }

    /**
     * Allows a musician to sell an instrument by adding funds and
        removing it from his/her/its collection
     * @param soldInstrument              The instrument being sold
     * @throws LastInstrumentException    If the musician tries to sell
        his/her/its last instrument
     * @throws DontOwnInstrumentException If musician doesn't
        own the instrument trying to be sold
     */

    public void sellInstrument(Instrument soldInstrument)
        throws LastInstrumentException, DontOwnInstrumentException {
        int instrumentPosition = -1;
        for (Instrument instrument : instruments) {
            if (instrument.equals(soldInstrument)) {
                instrumentPosition = instruments.indexOf(instrument);
            }
        }
        if (instrumentPosition == -1) {
            throw new DontOwnInstrumentException("This musician does"
                + " not own this instrument");
        }
        if (instruments.size() == 1) {
            throw new LastInstrumentException("This musician cannot sell"
                + " his/her/its last instrument");
        }
        int currentFunds;
        currentFunds = this.getFunds() + soldInstrument.getPrice();
        setFunds(currentFunds);
        int loopCounter;
        instruments.remove(instrumentPosition);
    }
}
