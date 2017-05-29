package com.company;
import java.io.*;

import static com.company.Parser.Data;
/**
 * Created by palah on 28.05.17.
 */
public class Main {
    public static void main(String[] args) {
        Parser parser = new Parser();

        Data parse = parser.parse("par.txt");
        try {
            OutputStream out = new FileOutputStream(new File("output.txt")) ;
            for(int i = 0 ; i<parse.getTheNumberOfPathsToFind(); i++){


               out.write(String.valueOf(Algorithm.Deijxtra(parser.parse("par.txt"),i)).getBytes());
               out.write((byte)'\n');



            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
