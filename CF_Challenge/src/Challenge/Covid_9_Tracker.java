package Challenge;


import java.io.File;
import java.util.Scanner;

public class Covid_9_Tracker {


    public static void main(String[] args){
        Covid covid = new Covid();
        Country country = new Country();
        String file1 = "C:\\Users\\Eugene Daniels\\Desktop\\population_data.csv";
        String file2 = "C:\\Users\\Eugene Daniels\\Desktop\\covid_data.csv";

        //country.readPopulationData(file1);
        //covid.read_Covid_Data(file2);
        File infile = null;
        if( 0 < args.length){
            infile = new File(args[0]);
            country.readPopulationData(String.valueOf(infile));
        }
        else{
            System.out.println("Invalid arguments: "+ args.length);
            System.exit(1);
        }


/**
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file name: ");
        System.out.flush();
        String filename = sc.nextLine();
        File file = new File(filename);
         */
    }
}
