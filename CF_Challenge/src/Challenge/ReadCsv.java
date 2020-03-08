package Challenge;


import java.io.*;
import java.util.*;


public class ReadCsv {

    public void read_into_observatory(String filecsv1){

        try{

            File file = new File(filecsv1);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            String [] Array; // an array of string of empty sting objects

            br.readLine(); // This will read the heading of the cvs file
            String first_line = null; // Ignoring the heading of the csv which contains the field names


            // The loop will start from line 2 of the csv file
            while((line = br.readLine()) != null) {
                Array = line.split(",");  // the comma delimiter for the csv file
            }

            br.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }




    }


    public static void main(String [] args) {
        ReadCsv bn = new ReadCsv(); // Creating an instance of the Reader_Csv class

        // Create a file path directory of the csv(comma delimited) file
        // Example of a csv file path directory
        String file_galamsey = "C:\\Users\\Eugene Daniels\\Desktop\\Galamsey.csv";
        String file_observatory = "C:\\Users\\Eugene Daniels\\Desktop\\Observatory.csv";

    }
}



