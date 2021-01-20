  
// Name :Horacio Medina
// LSUID: 890951584
package bookstore;

import java.util.ArrayList;

public class Proceeding extends Publication implements Citeable {

    private String city;

    //constructor
    public Proceeding(ArrayList authorNames, String Title, String Venue, Publisher Pub, int startPage, int lastPage, int Year, String City) {
        super(authorNames, Title, Venue, Pub, startPage, lastPage, Year);
        city = City;
    }

    ////adds the rest of the citation specifcally for conference proceedings
    public String Cite() {

        return (super.Cite() + city + ", " + year + ", pp:" + startingPage + "-" + endPage);
    }

}