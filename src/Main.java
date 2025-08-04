import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args){
        
        ArrayList<FieldRecord> records = new ArrayList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("file1.txt"))){
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null){
                String[] recordFormat = specialSpliter(line).toArray(new String[0]);
                if (recordFormat.length >= 15){
                    try{
                        records.add(new FieldRecord(recordFormat));
                    }catch(Exception e){
                        System.out.println("Error"+ Arrays.toString(recordFormat));
                        e.printStackTrace();
                    }
                }
            } 

            RecordSearch search = new RecordSearch(records);

            //System.out.println(search.HowManyCountryEndInA());
            //System.out.println(search.citiesWithHighestPop());
            //System.out.println(search.HowManyCountriesInd());
            //System.out.println(search.WhichCountriesInd());
            System.out.println(search.CountriesEndInA());

        }catch(IOException e){
            System.out.println("Error reading file " + e.getMessage());
        }
    }

    public static List<String> specialSpliter(String line){
        List<String> recordList = new ArrayList<>();
        StringBuilder currentField = new StringBuilder();
        boolean quote = false;

        for(int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if(c == '"'){
                quote = !quote; 
            }else if (c == ',' && !quote ){
                recordList.add(currentField.toString());
                currentField.setLength(0); 
            }else{
                currentField.append(c);
            }
        }

        recordList.add(currentField.toString());
        return recordList;
    }
    
}
