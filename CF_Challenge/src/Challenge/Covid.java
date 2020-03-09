package Career_Fair_Challenge;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Covid {
    private String DateRep;
    private String country;
    private String Geold;
    private int newconfDeaths;
    private int newConfCases;
    private String Highest_name;
    private int highest = 0;



    public Covid() {
    }

    /**
    public String getHighest_name() {
        return Highest_name;
    }

    public void setHighest_name(String highest_name) {
        Highest_name = highest_name;
    }
*/
    public Covid(String Highest_name){
        this.Highest_name = Highest_name;
    }

    public Covid(String dateRep, String country, String geold, int newconfDeaths, int newConfCases) {
        DateRep = dateRep;
        this.country = country;
        Geold = geold;
        this.newconfDeaths = newconfDeaths;
        this.newConfCases = newConfCases;

    }

    public String getDateRep() {
        return DateRep;
    }

    public void setDateRep(String dateRep) {
        DateRep = dateRep;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGeold() {
        return Geold;
    }

    public void setGeold(String geold) {
        Geold = geold;
    }

    public int getNewconfDeaths() {
        return newconfDeaths;
    }

    public void setNewconfDeaths(int newconfDeaths) {
        this.newconfDeaths = newconfDeaths;
    }

    public int getNewConfCases() {
        return newConfCases;
    }

    public void setNewConfCases(int newConfCases) {
        this.newConfCases = newConfCases;
    }


    public void read_Covid_Data(String filename){

        MultiMap<String, Covid> multimap = new MultiMap<String, Covid>();

        Inter it = new Inter();


        try{
            /**

             Scanner sc = new Scanner(System.in);
             System.out.println("Enter the file name: ");
             System.out.flush();
             String filename = sc.nextLine();
            */
            File file = new File(filename);

            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = "";
            String [] Array; // an array of string of empty sting objects

            br.readLine(); // This will read the heading of the cvs file
            String first_line = null; // Ignoring the heading of the csv which contains the field names


            // The loop will start from line 2 of the csv file
            while((line = br.readLine()) != null) {
                Array = line.split(",");  // the comma delimiter for the csv file

                if(Array.length == 5) {


                    this.setDateRep(Array[0]);
                    this.setCountry(Array[1]);
                    this.setNewConfCases(Integer.parseInt(Array[2]));
                    this.setNewconfDeaths(Integer.parseInt(Array[3]));
                    this.setGeold(Array[4]);

                    multimap.put(this.getCountry(),new Covid(this.getDateRep(),this.getCountry(),this.getGeold(),this.getNewconfDeaths(),this.getNewConfCases()));

                }
            }
            //find_highest_infestion(multimap);
            //find_second_highest(multimap);
            //find_death_highest(multimap);
            Find_country_highest(multimap);
            int num1 = Overall_deaths(multimap);
            int num2 = Overall_Infections(multimap);
            //System.out.println("The Death ratio is "+ (float) num1 / num2  + "\n" +"Or The death ratio is " + num1 + " : "+num2);

            //System.out.println(it.printh());
            /**
            for(String key : multimap.keySet()) {
                ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multimap.get(key);
                for(int i=0; i < covidArrayList.size(); i++){
                    highest += covidArrayList.get(i).getNewConfCases();
                    mappy.put(key,highest);
                }
                highest = 0;
            }

            Collection<Integer> Values = mappy.values();
            ArrayList<Integer> al = new ArrayList<>();
            int n =0;
            for(Integer num : Values){
                if(n < num){
                    n = num;
                    al.add(n);
                }
            }
            Collections.sort(al);
            for(Map.Entry m: mappy.entrySet()){
                if(m.getValue().equals(al.get(al.size() - 2))){
                    System.out.println("The second country with the highest number is "+ m.getKey() + " Num of infections : "+al.get(al.size() - 2));

                }
                else if (m.getValue().equals(n)){
                    System.out.println("The country with the highest number of infections is " + m.getKey()  + " Num of infections : "+ al.get(al.size() - 1));
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
        Covid that = (Covid) o;
        return newconfDeaths == that.newconfDeaths &&
                newConfCases == that.newConfCases &&
                Objects.equals(DateRep, that.DateRep) &&
                Objects.equals(country, that.country) &&
                Objects.equals(Geold, that.Geold);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DateRep, country, Geold, newconfDeaths, newConfCases);
    }

    @Override
    public String toString() {
        return "Covid{" +
                "DateRep='" + DateRep + '\'' +
                ", country='" + country + '\'' +
                ", Geold='" + Geold + '\'' +
                ", newconfDeaths=" + newconfDeaths +
                ", newConfCases=" + newConfCases +
                '}';
    }

    public void add_covids(MultiMap<String,Covid> multiMap){
        Covid covid = new Covid();
        multiMap.put(covid.getCountry(),covid);

    }


    public void find_highest_infestion(MultiMap<String,Covid> multiMap){
        int highest = 0;
        HashMap<String, Integer> mappy = new HashMap<>();
        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewConfCases();
                mappy.put(key,highest);
            }
            highest = 0;
        }

        Collection<Integer> Values = mappy.values();
        ArrayList<Integer> al = new ArrayList<>();
        int n =0;
        for(Integer num : Values){
            if(n < num){
                n = num;
                al.add(n);
            }
        }
        Collections.sort(al);
        for(Map.Entry m: mappy.entrySet()){
            if(m.getValue().equals(n)){
                System.out.println("The country with the highest number of infections is " + m.getKey()  + " Num of infections : "+ al.get(al.size() - 1));
            }
        }

    }

    public void  find_second_highest(MultiMap<String,Covid> multiMap){
        int highest = 0;
        HashMap<String, Integer> mappy = new HashMap<>();

        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewConfCases();
                mappy.put(key,highest);
            }
            highest = 0;
        }

        Collection<Integer> Values = mappy.values();
        ArrayList<Integer> al = new ArrayList<>();
        int n =0;
        for(Integer num : Values){
            if(n < num){
                n = num;
                al.add(n);
            }
        }
        Collections.sort(al);
        for(Map.Entry m: mappy.entrySet()){
            if(m.getValue().equals(al.get(al.size() - 2))){
                System.out.println("The second country with the highest number is " + m.getKey() + " Num of infections : "+ al.get(al.size() - 2));
            }
        }

       // System.out.println(this.getHighest_name());
    }


    public void find_death_highest(MultiMap<String, Covid> multiMap){
        int highest = 0;
        HashMap<String, Integer> mappy = new HashMap<>();
        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewconfDeaths();
                mappy.put(key,highest);
            }
            highest = 0;
        }

        Collection<Integer> Values = mappy.values();
        ArrayList<Integer> al = new ArrayList<>();
        int n =0;
        for(Integer num : Values){
            if(n < num){
                n = num;
                al.add(n);
            }
        }
        Collections.sort(al);
        for(Map.Entry m: mappy.entrySet()){
            if(m.getValue().equals(n)){
                System.out.println("The highest death is " + m.getKey()  + " Num of deaths : "+ al.get(al.size() - 1));
            }
        }
    }
    public String hn(){
        return country;
    }

    public int  Overall_deaths(MultiMap<String,Covid> multiMap){
        int highest = 0;
        HashMap<String, Integer> mappy = new HashMap<>();

        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewconfDeaths();
            }
        }
        return highest;
    }
    public int  Overall_Infections(MultiMap<String,Covid> multiMap){
        int highest = 0;
        HashMap<String, Integer> mappy = new HashMap<>();

        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewConfCases();
            }
        }
        return highest;
    }

    public String Find_country_highest(MultiMap<String,Covid> multiMap){
        int highest = 0;
        String name = null;
        HashMap<String, Integer> mappy = new HashMap<>();
        add_covids(multiMap);

        for(String key : multiMap.keySet()) {
            ArrayList<Covid> covidArrayList = (ArrayList<Covid>) multiMap.get(key);
            for(int i=0; i < covidArrayList.size(); i++){
                highest += covidArrayList.get(i).getNewConfCases();
                mappy.put(key,highest);
            }
            highest = 0;
        }

        Collection<Integer> Values = mappy.values();
        ArrayList<Integer> al = new ArrayList<>();
        int n =0;
        for(Integer num : Values){
            if(n < num){
                n = num;
                al.add(n);
            }
        }
        Collections.sort(al);
        for(Map.Entry m: mappy.entrySet()){
            if(m.getValue().equals(n)){
                System.out.println("The country with the highest number of infections is " + m.getKey()  + " Num of infections : "+ al.get(al.size() - 1));
                name += String.valueOf(m.getKey());
                return name;
            }
        }
        return name;
    }
}
