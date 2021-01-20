// Name :Horacio Medina
// LSUID: 890951584
package bookstore;

import java.util.ArrayList;
import java.util.Collections;

public class Publication implements Comparable<Publication>, Citeable {

    private ArrayList<Author> author;
    private Publisher publisher;
    private String venue;
    private String title;
    protected int startingPage;
    protected int endPage;
    protected int year;

    //constructor
    public Publication(ArrayList authorNames, String Title, String Venue, Publisher Pub, int startPage, int lastPage, int Year) {
        author = authorNames;
        title = Title;
        venue = Venue;
        publisher = Pub;
        startingPage = startPage;
        endPage = lastPage;
        year = Year;

    }

    /* sorts authors based on last name in arraylist & splits arraylist of authors for each publication as separate authors 
       returns first letter of first name and last name for each author */
    public String getAuthorlist(ArrayList<Author> authorList) {

        Collections.sort(authorList);

        String authorsNames = "";

        for (Author a : authorList) {
            authorsNames += a.firstName.charAt(0) + ". " + a.lastName + ", ";
        }
        return authorsNames;
    }

    //returns the beginning of the citation as well as creates acronym for venue inside
    @Override
    public String Cite() {

        StringBuilder acronym = new StringBuilder();
        String[] acro = venue.split(" ");
        for (String word : acro) {
            acronym.append(word.substring(0, 1));
        }
        String Acronym = acronym.toString();

        return (getAuthorlist(author) + " \"" + title + "\", " + venue + " (" + Acronym.toUpperCase() + "), " + publisher + ", ");
    }

    //orders the citations based on author last name, then venue, then year
    @Override
    public int compareTo(Publication other) {
        Collections.sort(author);

        if ((author.get(0).lastName.compareTo(other.author.get(0).lastName)) != 0) {

            return (author.get(0).lastName.compareTo(other.author.get(0).lastName));

        } else if (venue.compareTo(other.venue) != 0) {

            return venue.compareTo(other.venue);

        } else {

            return Integer.compare(other.year, year);
        }

    }

}