package com.manage.matches.matches;

/**
 * Sport Enumeration
 * Keeps Sport's type
 * */
public enum Sport {
    Football("Football", "1"),
    Basketball("Basketball", "2");

    String sportCode;
    String sportName;

    /**
     * Constructor
     * */
    Sport(String sportName, String sportCode){
        this.sportCode = sportCode;
        this.sportName=sportName;
    }
    /**
     * Method that get the sport name and return its code
     * @param sportName
     * */
    public static String getSportCodeByName(String sportName){
       for(Sport sport : Sport.values()){
           if(sport.sportName.equals(sportName)){
               return sport.sportCode;
           }
       }
        return null;
    }
    /**
     * Method that get the sport code and return its name
     * @param sportCode
     * */
    public static String getSportNameByCode(String sportCode){
        for(Sport sport : Sport.values()){
            if(sport.sportCode.equals(sportCode)){
                return sport.sportName;
            }
        }
        return null;
    }
}
