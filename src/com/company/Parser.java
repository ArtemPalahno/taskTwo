package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by palah on 24.05.17.
 */
public class Parser {
    public Parser() {

    }

    public Data parse(File file)
    {
        try {
            Data data = new Data();

            Scanner scanner = new Scanner(new FileInputStream(file));

            data.setTheNumberOfTests(Integer.valueOf(scanner.nextLine())); //set numbers of tests
            data.setTheNumberOfCities(Integer.valueOf(scanner.nextLine()));//set numbers of cities
            if(data.getTheNumberOfTests()>=10 || data.getTheNumberOfCities()>=10000)//check value of cities and tests
            {
                throw new IncorrectValueException() ;
            }

            for (int i = 0; i <data.getTheNumberOfCities() ; i++) {
                City city = new City(scanner.nextLine()); //create instance of city with name which was read

                city.setCountofNeighbours(Integer.valueOf(scanner.nextLine())); // set number of nieghbours
                for (int j = 0; j < city.getCountofNeighbours(); j++) {
                    String str = scanner.nextLine();
                    String nameOfNeighbour = str.substring(0,str.indexOf(" ")) ;
                    String costOfNeighbour = str.substring(str.lastIndexOf(" ")+1);

                    city.addNeighbour(new Neighbour(nameOfNeighbour,Integer.valueOf(costOfNeighbour))); //add Neighbour to city
                }
                data.addCitiy(city);
            }

            data.setTheNumberOfPathsToFind(Integer.valueOf(scanner.nextLine()));
            if(data.getTheNumberOfPathsToFind()>=100) // check number of path
            {
                throw new IncorrectValueException() ;
            }

            for (int i = 0; i < data.getTheNumberOfPathsToFind(); i++) {
                String str =  scanner.nextLine();
                String startIndex = str.substring(0,str.indexOf(" ")) ;
                String finishIndex = str.substring(str.lastIndexOf(" ")+1);
                data.addPathToFind(new Path(startIndex,finishIndex));
            }
            return data;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }

    }

    public Data parse(String path)
    {
        return this.parse(new File(path));
    }

    public static class Data
    {
        private int theNumberOfTests; //number of test
        private int TheNumberOfCities; //number of cities
        private List<City> cities = new ArrayList<City>();  //Cities array
        private List<Path> pathsToFind = new ArrayList<Path>(); //Array with sources and outlets
        private int theNumberOfPathsToFind; //number of path

        private Data() {

        }

        public List<City> getCities() {
            return cities;
        }

        private void setTheNumberOfTests(int theNumberOfTests) {
            this.theNumberOfTests = theNumberOfTests;
        }

        private void setTheNumberOfCities(int theNumberOfCities) {
            this.TheNumberOfCities = theNumberOfCities;
        }

        private void addCitiy(City city) {
            this.cities.add(city);
        }

        private void addPathToFind(Path pathToFind) {
            this.pathsToFind.add(pathToFind);
        }

        private void setTheNumberOfPathsToFind(int theNumberOfPathsToFind) {
            this.theNumberOfPathsToFind = theNumberOfPathsToFind;
        }

        public int getTheNumberOfTests() {
            return theNumberOfTests;
        }

        public int getTheNumberOfCities() {
            return TheNumberOfCities;
        }

        public City getCity(int index) {    //индексация с единицы
            return cities.get(index);
        }

        public Path getPathToFind(int index) {
            return pathsToFind.get(index);
        }

        public int getTheNumberOfPathsToFind() {
            return theNumberOfPathsToFind;
        }
    }

}
class IncorrectValueException  extends RuntimeException//Special exception class
{
    @Override
    public String getMessage() {
        return "Incorrect value " ;
    }
}

