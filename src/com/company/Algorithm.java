package com.company;

/**
 * Created by palah on 28.05.17.
 */
public class Algorithm {
    public static int infinity = Integer.MAX_VALUE;
      //realization of Deijxtra's algoritm
    public static int Deijxtra(Parser.Data data,int indexOfPathToFind)
    {

          class DeijxtraInfo
        {
            int where;
            int cost;
            int indexOfCity;

            public DeijxtraInfo(int where, int cost,int indexOfCity) {
                this.where = where;
                this.cost = cost;
                this.indexOfCity = indexOfCity;
            }

            public void setWhere(int where) {
                this.where = where;
            }

            public void setIndexOfCity(int indexOfCity) {
                this.indexOfCity = indexOfCity;
            }

            public int getIndexOfCity() {
                return indexOfCity;
            }

            public void setCost(int cost) {
                this.cost = cost;
            }

            public int getWhere() {
                return where;
            }

            public int getCost() {
                return cost;
            }
        }

        DeijxtraInfo[] line =   new DeijxtraInfo[data.getCities().size()];



        for (int i = 0; i < data.getCities().size(); i++) {
            if(data.getCities().get(i).getName().equals(data.getPathToFind(indexOfPathToFind).getNameOfStartCity()))
                line[i] =  new DeijxtraInfo(0,0,i);
            else
                line[i] = new DeijxtraInfo(infinity,infinity,i);
        }
        boolean doWhile = true;

        String str= null;
        for (int i = 0; i < data.getCities().size(); i++) {
            if(data.getCities().get(i).getName().equals(data.getPathToFind(indexOfPathToFind).getNameOfFinishCity()))
                str = String.valueOf(i);
        }


        for (;;)
        for (int i = 0; i < line.length; i++) {
            if(line[i].getCost()<infinity)
            {
                for (int j = 0; j < data.getCities().get(i).getNeighbours().size(); j++) {
                    if(j==data.getCities().get(i).getNeighbours().size()-1 && i==line.length-1)
                        return line[Integer.valueOf(str)].getCost();
                    int cost = line[i].getCost();
                    Neighbour neighbour = data.getCities().get(i).getNeighbours().get(j);
                    cost = cost + neighbour.getCost();
                    if(cost<line[Integer.valueOf(neighbour.getName())-1].getCost())
                    {
                        line[Integer.valueOf(neighbour.getName())-1].setWhere(i);
                        line[Integer.valueOf(neighbour.getName())-1].setCost(cost);
                    }
                }

            }
        }
    }


    public static int Deijxtra(Parser.Data data)
    {
        return Deijxtra(data,0);
    }

}
