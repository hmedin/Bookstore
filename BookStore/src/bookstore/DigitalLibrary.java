// Name :Horacio Medina
// LSUID: 890951584
package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;

//Enumeration with all allowed publisher names
enum Publisher {
    ELSEVIER, SPRINGER, IEEE, TAYLORFRANCIS, WILEY, ACM
};

public class DigitalLibrary {

    private ArrayList<Publication> publications = new ArrayList<>();

    //adds all authors for a publication into an arraylist
    private ArrayList<Author> getAuthors(String Auth) {
        String[] authorArray = Auth.split(",");
        ArrayList<Author> r = new ArrayList<>();
        for (String a : authorArray) {
            r.add(new Author(a.split(" ")[0], a.split(" ")[1]));
        }

        return r;
    }

    //reads publications from publications.txt and splits them into fields
    public void loadPublications() throws FileNotFoundException {

        File input = new File("publications.txt");
        Scanner in = new Scanner(input);

        while (in.hasNext()) {
            String[] fields = in.nextLine().split(";");

            if (fields.length == 9) {

                publications.add(new Journal(getAuthors(fields[0]), fields[1], fields[2],
                        Publisher.valueOf(fields[3].toUpperCase()),
                        Integer.valueOf(fields[6]),
                        Integer.valueOf(fields[7]),
                        Integer.valueOf(fields[8]),
                        Integer.valueOf(fields[4]),
                        Integer.valueOf(fields[5])
                ));

            } else if (fields.length == 8) {
                publications.add(new Proceeding(getAuthors(fields[0]), fields[1], fields[2],getPublisher(fields[3]),
                        Integer.valueOf(fields[5]), Integer.valueOf(fields[6]), Integer.valueOf(fields[7]), fields[4]));
            }

            //COMPLETE: read each line of the file, based on the number of fields, decide whether it is a journal or a proceeding. Extarct the fields and add the publication to the publications ArrayList
        }

    }
    
    //reads publisher field and returns it if its approved or throws illegal arguement exception
    private Publisher getPublisher(String pubs){
        try{
            return Publisher.valueOf(pubs.toUpperCase());
        }
        catch (IllegalArgumentException e) {
            throw e;
        }
    }

    //prints out citation in order and numbers them
    public void listPublications() {

        int i = 1;
        Collections.sort(publications);

        for (Publication a : publications) {
            System.out.println("[" + i + "]" + a.Cite());
            i++;
        }

//COMPLETE: sort publications and print them. Add the numbers [1], [2], etc. at the begining of each line 
    }

    ////prints out citation in order and numbers them into a file
    public void saveCitations(String fileName) throws FileNotFoundException {
        PrintWriter prw = new PrintWriter(fileName + ".txt");
        Collections.sort(publications);

        int i = 1;

        for (Publication a : publications) {
            prw.println("[" + i + "]" + a.Cite());
            i++;
        }
        prw.close();

        //COMPLETE: Save citations to the file "fileName"
        System.out.println(publications.size() + " citations have been saved to the file " + new File(fileName + ".txt").getAbsolutePath());
    }

}