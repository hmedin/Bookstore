// Name :Horacio Medina
// LSUID: 890951584
package bookstore;

public class Author implements Comparable<Author> {

    protected String firstName;
    protected String lastName;
    protected String institution;

    //constructor
    public Author(String Firstname, String Lastname) {
        firstName = Firstname;
        lastName = Lastname;
    }

    //sets institution
    public void setInstitution(String ins) {
        institution = ins;
    }

    //compares auhtor based on last name
    @Override
    public int compareTo(Author other) {

        return lastName.compareTo(other.lastName);

    }

}