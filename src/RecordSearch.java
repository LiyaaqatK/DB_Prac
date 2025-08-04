import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class RecordSearch{


    private ArrayList<FieldRecord> info;

    public RecordSearch (ArrayList<FieldRecord> info){
        this.info = info;
    }
    

    //Question A
    public int HowManyCountryEndInA(){
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
            
        return list.size();
    
    }


    //Question B incomplete
    /* 
    public String citiesWithHighestPop(){
        HashMap<String, Integer> cities = new HashMap<>();
        for (FieldRecord fr: info){
            if(!cities.containsKey(fr.getCityName())){
                cities.put(fr.getCityName(), fr.getCityPop());
            }
            
        }

        ArrayList<HashMap.Entry<String, Integer>> cityList = new ArrayList<>(cities.entrySet());
        return null;
        
    }*/

    //Question C incomplete

    //Quetion D
    public int HowManyCountriesInd(){

        
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
        return countries.size();
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
        return ans;
    }
    
    //question f: incomplete


    //question  g:incomlete


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
                            //countries += "" + ", "
                            
                        }
                        
                    }
                
                
            }
            for( String namess : list){
                countries += namess + ", " ;
            }
           // System.out.println(list);
            
        return countries;
    
    }
}