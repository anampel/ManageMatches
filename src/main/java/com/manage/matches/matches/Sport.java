package com.manage.matches.matches;

public enum Sport {
    Football("Football", "1"),
    Basketball("Basketball", "2");

    String sportCode;
    String sportName;

    Sport(String sportName, String sportCode){
        this.sportCode = sportCode;
        this.sportName=sportName;
    }

    public static String getSportCodeByName(String sportName){
       for(Sport sport : Sport.values()){
           if(sport.sportName.equals(sportName)){
               return sport.sportCode;
           }
       }
        return null;
    }

    public static String getSportNameByCode(String sportCode){
        for(Sport sport : Sport.values()){
            if(sport.sportCode.equals(sportCode)){
                return sport.sportName;
            }
        }
        return null;
    }
}
