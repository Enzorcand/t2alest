package org.example.t2alest;

import lombok.Data;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Tribo tribo = new Tribo(10, "x");


        Tribo tribo = new Tribo("Tribo 2");


        for (String s : tribo.getPovo().keySet()) {
            System.out.println("chave = " + s);
        }



    }
}