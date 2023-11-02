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
    HashMap<String, Guerreiro> children;

    public Guerreiro(Guerreiro pai, int land, String name) {
        this.land = land;
        this.name = name;
        this.pai = pai;
        children = new HashMap<>();
    }

    public Guerreiro(int land, String name) {
        this.land = land;
        this.name = name;
        this.pai = null;
        children = new HashMap<>();
    }

    public void giveLand(){
        int heranca = pai.land/pai.nSons;
        land = land + heranca;
    }

    public void addFilho(Guerreiro g){
        children.put(g.getName(), g);
    }

    public void giveLandTest(){
        for (String g: children.keySet()) {
            Guerreiro atual = children.get(g);

        }

        int heranca = pai.land/pai.nSons;
        land = land + heranca;
    }
}


