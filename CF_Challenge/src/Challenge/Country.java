package Career_Fair_Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class Country {
    private String country_name;
    private long population;
    private int year;
    private String country_code;
    private long num_population;

    public Country(){}


    public Country(String country_name, long population, int year,  String country_code ) {
        this.country_name = country_name;
        this.population = population;
        this.year = year;
        this.country_code = country_code;
    }

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public String getCountry_code() {
        return country_code;
    }

    public void setCountry_code(String country_code) {
        this.country_code = country_code;
    }


    public void readPopulationData(String filename){
        HashMap<String, Country> myMap = new HashMap<>();
        Inter it = new Inter();
        Covid covid = new Covid();

        try{
            /**
             Scanner sc = new Scanner(System.in);
             System.out.println("Enter the file name: ");
             System.out.flush();
             String filename = sc.nextLine();*/

            File file = new File(filename);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            String [] Array; // an array of string of empty sting objects

            br.readLine(); // This will read the heading of the cvs file
            String first_line = null; // Ignoring the heading of the csv which contains the field names


            // The loop will start from line 2 of the csv file
            while((line = br.readLine()) != null) {
                Array = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");  // the comma delimiter for the csv file

                if(Array.length == 4) {
                    this.setCountry_name(Array[0]);
                    this.setCountry_code(Array[1]);
                    this.setPopulation((Long.parseLong(Array[2])));
                    this.setYear(Integer.parseInt(Array[3]));

                    myMap.put(this.getCountry_name(), new Country(this.getCountry_name(), this.getPopulation(), this.getYear(),this.getCountry_code()));

                }
            }

            System.out.println(covid.hn());
            //it.add_countries(myMap);
            //it.find_highest_ratio(myMap);
            //System.out.println(it.printh());
            //System.out.println("the boy is" );
            //System.out.println(it.getHighest_country_infection());

            /**
            for(Map.Entry m: myMap.entrySet()){

                if(m.getKey().equals(name)){
                    System.out.println("Hello");
                    System.out.println("Key: " + m.getKey() + " " + "Value " + m.getValue());
                }

            }
    */
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return population == country.population &&
                year == country.year &&
                country_name.equals(country.country_name) &&
                country_code.equals(country.country_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country_name, population, year, country_code);
    }

    @Override
    public String toString() {
        return "Country{" +
                "country_name='" + country_name + '\'' +
                ", population=" + population +
                ", year=" + year +
                ", country_code='" + country_code + '\'' +
                '}';
    }


}
