package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by palah on 28.05.17.
 */
public class City {
    private String name; //City's name
    private List<Neighbour> neighbours = new ArrayList<Neighbour>(); //Array of neighbours
    private int countofNeighbours;
    public City(String name) {  // Конструктор города, город обязан иметь имя в каждый момент выполения программы
        this.name = name;
    }

    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    public void setCountofNeighbours(int countofNeighbours) {
        this.countofNeighbours = countofNeighbours;
    }

    public int getCountofNeighbours() {
        return countofNeighbours;
    }

    public void addNeighbour(Neighbour neighbour)   //Add neihgbour to neighbour's array of this instance of city

    {
        neighbours.add(neighbour);
    }

    public Neighbour getNeighbour(int index) //Return neighbour , Index start with 1
    {
        return neighbours.get(index);
    }

    public String getName()         // return city's name
    {
        return name;
    }

}
