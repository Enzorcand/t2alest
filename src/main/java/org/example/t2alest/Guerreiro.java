package org.example.t2alest;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

@Data
public class Guerreiro {
    Guerreiro pai;
    private int land;
    private int nSons;
    private int depth;
    private String name;
    private HashMap<String, Guerreiro> children;

    public Guerreiro(Guerreiro pai, int land, String name) {
        this.land = land;
        this.name = name;
        this.pai = pai;
        nSons = 0;
        children = new HashMap<>();
    }

    public Guerreiro(String name) {
        this.land = 0;
        this.name = name;
        this.pai = null;
        nSons = 0;
        children = new HashMap<>();
    }

    public void getDepthValue(){
        depth = 0;
        Guerreiro top = pai;
        while(top != null){
            depth++;
            top = top.getPai();
        }
    }

    public void giveLand(){
        int heranca = land/nSons;
        Guerreiro g;
        Set<String> child = children.keySet();
        for (String s: child) {
            g = children.get(s);
            g.setLand(g.getLand() + heranca);
        }
    }


    public void addFilho(Guerreiro g){
        nSons++;
        children.put(g.getName(), g);
    }

    public void printLandDepth(){
        System.out.println(land);
        System.out.println(depth);
        System.out.println(name);
        System.out.println(pai.name);
        System.out.println(nSons);
    }
}


