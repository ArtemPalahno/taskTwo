package com.company;

/**
 * Created by palah on 28.05.17.
 */
public class Path {     //immutable
    private String nameOfStartCity; //index of city-source
    private String nameOfFinishCity; //index of city-outlet

    public Path(String nameOfStartCity, String nameFinishCity) {   //Constructor of path
        this.nameOfStartCity = nameOfStartCity;        // set city-source
        this.nameOfFinishCity = nameFinishCity; // set city-outlet
    }

    public String getNameOfStartCity() { // возвращает город исток
        return nameOfStartCity;
    }

    public String getNameOfFinishCity() { //возвращает город сток
        return nameOfFinishCity;
    }
}
