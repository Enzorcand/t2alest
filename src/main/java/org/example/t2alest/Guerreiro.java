package org.example.t2alest;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Data
public class Guerreiro {

    Guerreiro pai;
    int land;
    int nSons;
    String name;
    ArrayList<Guerreiro> children;

        /*
        public Guerreiro(Guerreiro pai, int land, String name) {
            this.land = land;
            this.name = name;
            this.pai = pai;
            children = new ArrayList<>();
        }


         */
        /*
        public Guerreiro(int land, String name) {
            this.land = land;
            this.name = name;
            this.pai = null;
            children = new ArrayList<>();
        }

         */

    public Guerreiro (String name) {
        this.name = name;
        children = new ArrayList<>();
    }


    public void giveLand(){
        int heranca = pai.land/pai.nSons;
        land = land + heranca;
    }


    public void addChild (Guerreiro x) {

    }