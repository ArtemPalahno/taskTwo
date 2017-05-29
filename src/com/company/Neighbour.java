package com.company;

import java.util.ArrayList;

/**
 * Created by palah on 28.05.17.
 */
public class Neighbour {
    private int cost;   //стоимость перехода к экземпляру соседа
    private String name; // имя соседа

    public Neighbour(String name,int cost ) {
        this.cost = cost;
        this.name = name;
    }

    public int getCost() {          //возвращает стоиомость перехода к экземпляру соседа
        return cost;
    }

    public String getName() {   //возвращает имя соседа
        return name;
    }
}
