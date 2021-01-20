// Name :Horacio Medina
// LSUID: 890951584
package bookstore;

import java.util.ArrayList;

public class Journal extends Publication implements Citeable {

    private int volume;
    private int number;

    //constructor
    public Journal(ArrayList authorNames, String Title, String Venue, Publisher Pub, int startPage, int lastPage, int Year, int Vol, int volNum) {
        super(authorNames, Title, Venue, Pub, startPage, lastPage, Year);
        volume = Vol;
        number = volNum;
    }

    //adds the rest of the citation specifcally for journals
    public String Cite() {
        return (super.Cite() + volume + "(" + number + "): " + startingPage + "-" + endPage + ", " + year);
    }
}