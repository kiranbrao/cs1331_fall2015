import java.util.ArrayList;

/**
 * Represents a place where musicians can buy and sell instruments
 * @author Kiran Rao
 * @version 1.0 Oct. 20 2015
 */
public class MusicStore {

    /**
     * Main method
     * @param args          Default parameter for main method
     */
    public static void main(String[] args) {
        Instrument squidwardsClarinet = new Clarinet(750, "CL0987");
        System.out.println("squidwardsClarinet.getPrice() = "
            + squidwardsClarinet.getPrice());
        System.out.println("squidwardsClarinet.getSerialNumber() = "
            + squidwardsClarinet.getSerialNumber());
        if (squidwardsClarinet instanceof Woodwind) {
            Woodwind squidwardsClarinetCasted = (Woodwind) squidwardsClarinet;
            System.out.println("squidwardsClarinetCasted.getNumReeds() = "
                + squidwardsClarinetCasted.getNumReeds());
        }
        System.out.println("squidwardsClarinet.play() = "
            + squidwardsClarinet.play());
        System.out.println("squidwardsClarinet.toString() = "
            + squidwardsClarinet.toString());


        Instrument fancyTrombone = new Trombone(1200, "TR0002");
        System.out.println("fancyTrombone.getPrice() = "
            + fancyTrombone.getPrice());
        System.out.println("fancyTrombone.getSerialNumber() = "
            + fancyTrombone.getSerialNumber());
        if (fancyTrombone instanceof Brass) {
            Brass fancyTromboneCasted = (Brass) fancyTrombone;
            System.out.println("fancyTromboneCasted.getHasSlide() = "
                + fancyTromboneCasted.getHasSlide());
        }
        System.out.println("fancyTrombone.play() = "
            + fancyTrombone.play());
        System.out.println("fancyTrombone.toString() = "
            + fancyTrombone.toString());

        Instrument acousticGuitar = new Guitar(1500, "GR2345");
        System.out.println("acousticGuitar.getPrice() = "
            + acousticGuitar.getPrice());
        System.out.println("acousticGuitar.getSerialNumber() = "
            + acousticGuitar.getSerialNumber());
        if (acousticGuitar instanceof Stringed) {
            Stringed acousticGuitarCasted = (Stringed) acousticGuitar;
            System.out.println("acousticGuitarCasted.getNumStrings() = "
                + acousticGuitarCasted.getNumStrings());
        }
        System.out.println("acousticGuitar.play() = "
            + acousticGuitar.play());
        System.out.println("acousticGuitar.toString() = "
            + acousticGuitar.toString());

        Instrument marchersSnare = new Snare(450, "SN1738");
        System.out.println("marchersSnare.getPrice() = "
            + marchersSnare.getPrice());
        System.out.println("marchersSnare.getSerialNumber() = "
            + marchersSnare.getSerialNumber());
        if (marchersSnare instanceof Percussion) {
            Percussion marchersSnareCasted = (Percussion) marchersSnare;
            System.out.println("marchersSnareCasted.getDrumDiameter() = "
                + marchersSnareCasted.getDrumDiameter());
        }
        System.out.println("marchersSnare.play() = "
            + marchersSnare.play());
        System.out.println("marchersSnare.toString() = "
            + marchersSnare.toString());

        ArrayList<Instrument> squidwardsInstruments
            = new ArrayList<Instrument>();
        squidwardsInstruments.add(squidwardsClarinet);
        squidwardsInstruments.add(marchersSnare);

        ArrayList<Instrument> edsInstruments = new ArrayList<Instrument>();
        edsInstruments.add(acousticGuitar);
        edsInstruments.add(fancyTrombone);


        System.out.println("Squidward's starting instruments"
            + " by serial number:");
        for (Instrument i : squidwardsInstruments) {
            System.out.println(i.getSerialNumber());
        }

        System.out.println("Ed Sheeran's starting instruments by "
            + "serial number:");
        for (Instrument i : edsInstruments) {
            System.out.println(i.getSerialNumber());
        }

        Musician squidward = new Musician("Squidward"
            , squidwardsInstruments, 5000);
        System.out.println("New musician Squidward has appeared!");
        System.out.println("squidward.getName() = " + squidward.getName());
        System.out.println("squidward.getFunds() = " + squidward.getFunds());

        Musician edSheeran = new Musician("Ed Sheeran", edsInstruments, 120500);
        System.out.println("New musician Ed Sheeran has appeared!");
        System.out.println("edSheeran.getName() = " + edSheeran.getName());
        System.out.println("edSheeran.getFunds() = " + edSheeran.getFunds());

        try {
            squidward.buyInstrument(new Clarinet(3000, "CL5003"));
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (SameSerialNumberException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Squidward bought a new $3000 clarinet! His new"
            + " funds are: " + squidward.getFunds());

        System.out.println("Squidward's instruments by serial number:");
        squidward.getInstruments();

        System.out.println("This is what happens when Squidward tries to"
            + " buy the squidwardsClarinet he already owns: ");
        try {
            squidward.buyInstrument(squidwardsClarinet);
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (SameSerialNumberException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("This is what happens when Squidward"
            + " doesn't have enough money to buy a new instrument: ");
        try {
            squidward.buyInstrument(new Guitar(3500, "GR1212"));
        } catch (NotEnoughFundsException e) {
            System.out.println(e.getMessage());
        } catch (SameSerialNumberException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Squidward's funds are still: "
            + squidward.getFunds());

        System.out.println("Squidward's instruments are still:"
            + " (by serial number)");
        squidward.getInstruments();

        System.out.println("Let's look at Ed Sheeran's instruments now"
            + " (by serial number):");
        edSheeran.getInstruments();

        System.out.println("Ed decides he doesn't want his trombone"
            + " anymore and wants to sell it.");
        System.out.println("Ed's current funds: " + edSheeran.getFunds());

        try {
            edSheeran.sellInstrument(fancyTrombone);
        } catch (DontOwnInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (LastInstrumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Ed just sold his fancyTrombone! His current"
            + " funds are: " + edSheeran.getFunds());

        System.out.println("Ed's instruments by serial number:");
        edSheeran.getInstruments();

        System.out.println("This is what happens when Ed Sheeran tries to"
            + " sell an instrument (fancyTrombone) he doesn't have: ");

        try {
            edSheeran.sellInstrument(fancyTrombone);
        } catch (DontOwnInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (LastInstrumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("This is what happens when Ed Sheeran"
            + " tries to sell his last instrument (acousticGuitar): ");

        try {
            edSheeran.sellInstrument(acousticGuitar);
        } catch (DontOwnInstrumentException e) {
            System.out.println(e.getMessage());
        } catch (LastInstrumentException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Ed Sheeran's funds are still: "
            + edSheeran.getFunds());

        System.out.println("Ed Sheeran's instruments are still:"
            + " (by serial number)");
        edSheeran.getInstruments();

        System.out.println("Let's look at the overridden"
            + " equals() method in the Instrument class.");
        System.out.println("The new equals method compares the two instruments"
            + " and returns true\n if they have the same serial number.");

        System.out.println("We'll make a new guitar called copyGuitar");
        Instrument copyGuitar = new Guitar(10703080, "GR2345");
        System.out.println("copyGuitar.getSerialNumber() = "
            + copyGuitar.getSerialNumber());
        System.out.println("Note that copyGuitar has the same serial number"
            + " as acousticGuitar (GR2345)");
        System.out.println("acousticGuitar.equals(copyGuitar) = "
            + acousticGuitar.equals(copyGuitar));

        System.out.println("Even if we compare acousticGuitar to a snare"
            + " that has the same serial number\n the equals method"
            + " will return true.");
        System.out.println("We'll make a new snare called copySnare");
        Instrument copySnare = new Snare(42595, "GR2345");
        System.out.println("copySnare.getSerialNumber() = "
            + copySnare.getSerialNumber());
        System.out.println("Note that copySnare has the same serial"
            + " number as acousticGuitar (GR2345)");
        System.out.println("acousticGuitar.equals(copySnare) = "
            + acousticGuitar.equals(copySnare));

        System.out.println("However, if we compare acousticGuitar to an"
            + " instrument with a different serial number\n the"
            + " equals method will return false.");
        System.out.println("We'll make a new trombone called originalTrombone");
        Instrument originalTrombone = new Trombone(3, "TR2468");
        System.out.println("originalTrombone.getSerialNumber() = "
            + originalTrombone.getSerialNumber());
        System.out.println("Note that originalTrombone has"
            + " a different serial number than acousticGuitar");
        System.out.println("acousticGuitar.equals(originalTrombone) = "
            + acousticGuitar.equals(originalTrombone));

        System.out.println("The music store is now closed!");
    }
}
