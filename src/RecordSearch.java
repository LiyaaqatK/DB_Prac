//Group name: “Not found”
// DB Assignment 1
//Group Leader: Lesedi Lebopa(4276507)
//Group members: 
//Liyaaqat Kamish(4270300), Furrell Meas(4397252), Ryan Henry(4388206), Makhanani Mlambo(4270025), Sphesihle Ngubane(4202730)
//RecordSearch.java


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RecordSearch{


    private ArrayList<FieldRecord> info;

    public RecordSearch (ArrayList<FieldRecord> info){
        this.info = info;
    }
    

    //Question A
    public String HowManyCountryEndInA(){
            ArrayList<String> list = new ArrayList<>();
            for(FieldRecord rec: info){
                String country = rec.getCountryName();
                String[] characters = country.split("");
             
                    if (!list.contains(country)){
                        if (characters[characters.length - 1].equals("a") ){
                            list.add(country);
                            
                        }
                    }
                
                
            }
           // System.out.println(list);
            String attach = "Number of countries ending in 'a'\n";
        return attach + Integer.toString(list.size())+"\n";
    
    }


    //Question B complete
      public String citiesWithHighestPop(){
        HashMap<String, FieldRecord> cities = new HashMap<>();


        for (FieldRecord fr: info){
            String City = fr.getCityName();
            int population = fr.getCityPop();

            if(!cities.containsKey(City) || population > cities.get(City).getCityPop()){
                cities.put(City, fr); //Replacing city with another city that has greater population
            }
            
        }
    

    List<FieldRecord> sortedCityList = new ArrayList<>(cities.values());
    sortedCityList.sort((a, b) -> Integer.compare(b.getCityPop(), a.getCityPop()));
//this sorts the list in descending order
    StringBuilder top5 = new StringBuilder("The top 5 cities with the Biggest Populations \n");
    int count = 5;//this gets the 5 biggest cities
    for(int i = 0; i < count; i++){
        FieldRecord city = sortedCityList.get(i);
        top5.append(city.getCityName()).append(" - ").append(city.getCityPop()).append("\n");
    }
    return top5.toString();

}

    //Question C complete
public String CountriesLargestLandMass(){
        HashMap<String, FieldRecord> cities = new HashMap<>();

        for (FieldRecord fr:info){
            String City = fr.getCityName();
            float landMass = fr.getLandMass();

             if(!cities.containsKey(City) || landMass > cities.get(City).getLandMass()){
                cities.put(City, fr); //Replacing city with another city that has greater LandMass
            }
        }
            
        
        
    List<FieldRecord> sortedCityList = new ArrayList<>(cities.values());
    sortedCityList.sort((a, b) -> Float.compare(b.getLandMass(), a.getLandMass()));
//this sorts the list in descending order
    StringBuilder top5 = new StringBuilder("The top 5 cities with the Biggest Land Mass \n");
    int count = 5;//this gets the 5 biggest cities
    for(int i = 0; i < count; i++){
        FieldRecord city = sortedCityList.get(i);
        top5.append(city.getCityName()).append(" (").append(city.getCountryName()+ ")").append(" - ").append(city.getLandMass()).append("\n");
    }
    return top5.toString();

}
    
    //Quetion D
    public String HowManyCountriesInd(){

        
        HashMap<String,Integer> countries = new HashMap<>();
        for (FieldRecord fr: info){
            if(!countries.containsKey(fr.getCountryName()) ){
                int indYear = fr.getIndepYear();
                if(indYear>= 1960 && indYear <= 1980 ){
                    countries.put(fr.getCountryName(), fr.getIndepYear());
                }
            }
            
        }
        //System.out.println(countries);
        String attach = "How many countries gained independence between the years 1960 and 1980 (inclusive)\n";
        return attach + Integer.toString(countries.size())+"\n";
    }

    //Question E
    public String WhichCountriesInd(){

        
        HashMap<String,Integer> countries = new HashMap<>();
        for (FieldRecord fr: info){
            if(!countries.containsKey(fr.getCountryName()) ){
                int indYear = fr.getIndepYear();
                if(indYear>= 1830 && indYear <= 1850 && indYear != -1){
                    countries.put(fr.getCountryName(), fr.getIndepYear());
                }
            } 
        }
        String ans = "";
        for (Map.Entry<String, Integer> country : countries.entrySet()){
            ans += country.getKey()+ ": "+ country. getValue()+ "\n";
        }

        //System.out.println(countries);
        String attach = "Which countries gained independence between the years 1830 and 1850 (inclusive)?\n";
        return attach + ans;
    }
    
    //question f: complete

    public String AfricanCountryLE(){
        HashMap<String, FieldRecord> countries = new HashMap<>();

        for (FieldRecord fr: info){
            if (fr.getContinent().equalsIgnoreCase("Africa")){//checks to see if the continent is Africa
                String Country = fr.getCountryName();
                float LE = fr.getLifeExp();

                if (!countries.containsKey(Country) || LE > countries.get(Country).getLifeExp()){
                    countries.put(Country, fr);

                }

            }
            
        }

        List<FieldRecord> sortedLE = new ArrayList<>(countries.values());
        sortedLE.sort((a, b) -> Float.compare(b.getLifeExp(), a.getLifeExp()));

        StringBuilder top5LE = new StringBuilder("The top 5 African Countries with the Highest Life Expectancy \n");
        int count = 5;

        for (int i = 0 ; i < count; i++){
            FieldRecord Country = sortedLE.get(i);
            top5LE.append(Country.getCountryName()).append(" - ").append(Country.getLifeExp()).append("\n");//this adds Country - lifeEXP
        }

        return top5LE.toString();

    }


    //question  g: complete

    public String mostCommonLang(){
        HashMap<String,Integer> lang = new HashMap<>();

        for (FieldRecord fr:info){
            String Lang = fr.getLanguage();
            int population = fr.getCountryPop();

            lang.put(Lang, lang.getOrDefault(Lang, 0) + population );

        }

        List<Map.Entry<String, Integer>> sortedLang = new ArrayList<>(lang.entrySet());
        sortedLang.sort((a,b) -> Integer.compare(b.getValue(), a.getValue()));

        StringBuilder top5lang = new StringBuilder("The top 5 Most Commonly Spoken Languages \n");
        int count = 5;
        for(int i = 0;i<count;i++){
            Map.Entry<String, Integer> entry = sortedLang.get(i);
            top5lang.append(entry.getKey()).append(" - ").append(entry.getValue()).append("\n");
        }

        return top5lang.toString();
    }


    //question h
    public String  CountriesEndInA(){
            ArrayList<String> list = new ArrayList<>();
            String countries = "";
            for(FieldRecord rec: info){
                String country = rec.getCountryName();
                String[] characters = country.split("");
             
                    if (!list.contains(country)){
                        if (characters[characters.length - 1].equals("a") ){
                            list.add(country);
                            
                        }
                        
                    }
                
                
            }
            for( String namess : list){
                countries += namess + "\n" ;
            }
           // System.out.println(list);
            String attach = "List the country names that end with the letter ‘a’, without any repetitions.\n";
        return attach + countries;
    
    }
}