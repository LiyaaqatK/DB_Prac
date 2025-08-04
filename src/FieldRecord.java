//Group name: “Not found”
// DB Assignment 1
//Group Leader: Lesedi Lebopa(4276507)
//Group members: 
//Liyaaqat Kamish(4270300), Furrell Meas(4397252), Ryan Henry(4388206), Makhanani Mlambo(4270025), Sphesihle Ngubane(4202730)
//FieldRecord.java



public class FieldRecord{
    
    private String cityName, countryName, continent, region, government, headOfState, capital,language;
    private int cityPop, indepYear,countryPop;
    private float landMass,lifeExpectancy, GNP, percentage;

//CityName,CityPopulation,CountryName,Continent,Region,LandMass,IndepYear,CountryPopulation,LifeExpectancy,GNP,GovernmentForm,HeadOfState,Capital,Language,Percentage

    public FieldRecord(String [] format){

        this.cityName = format[0];
        this.cityPop = changeToInt(format[1]);
        this.countryName = format[2];
        this.continent= format[3];
        this.region = format[4];
        this.landMass = changeToFloat(format[5]);
        this.indepYear = changeToInt(format[6]);
        this.countryPop = changeToInt(format[7]);
        this.lifeExpectancy = changeToFloat(format[8]);
        this.GNP = changeToFloat(format[9]);
        this.government = format[10];
        this.headOfState = format[11];
        this.capital = format[12];
        this.language = format[13];
        this.percentage = changeToFloat(format[14]);



    }
    public int changeToInt(String word){
        if ( word.equals("NULL")){
            return -1;
        }
        return Integer.parseInt(word);
    }
    public float changeToFloat(String word){
        if ( word.equals("NULL")){
            return -1f;
        }
        return Float.parseFloat(word);
    }


    public String getCityName(){
        return this.cityName;
    }
    public String getCountryName(){
        return this.countryName;
    }
    public String getContinent(){
        return this.continent;
    }
    public String getRegion(){
        return this.region;
    }
    public String getGoverment(){
        return this.government;
    }
    public String getHeadOfState(){
        return this.headOfState;
    }
    public String getCapital(){
        return this.capital;
    }
    public String getLanguage(){
        return this.language;
    }

    public int getCityPop(){
        return this.cityPop;
    }
    public int getIndepYear(){
        return this.indepYear;
    }
    public int getCountryPop(){
        return this.countryPop;
    }

    public float getLandMass(){
        return this.landMass;
    }
    public float getLifeExp(){
        return this.lifeExpectancy;
    }
    public float getGNP(){
        return this.GNP;
    }
    public float getPercentage(){
        return this.percentage;
    }


  

}