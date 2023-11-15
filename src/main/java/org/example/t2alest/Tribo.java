package org.example.t2alest;

import lombok.Data;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

@Data
public class Tribo {
    private String nomeTribo;
    private Guerreiro raiz;
    private int terrasRaiz;
    private HashMap<String, Guerreiro> povo;

    public Tribo(int lands, String name) {
        raiz = new Guerreiro(name);
        povo = new HashMap<>();
        povo.put(raiz.getName(), raiz);
    }
    @SneakyThrows
    public Tribo() {
        nomeTribo = null;
        raiz = null;
        povo = new HashMap<>();
        registerPovo();
        getTriboDepth();
        distributeLand();
    }

    @SneakyThrows
    public Tribo(String nomeTribo) {
        this.nomeTribo = nomeTribo;
        raiz = null;
        povo = new HashMap<>();
        //registerPovo();
        registerOtherPovo();
        getTriboDepth();
        distributeLand();
    }



    public void registerPovo () throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream("src/main/java/org/example/t2alest/tribo.txt"));
        terrasRaiz = scan.nextInt();

        while(scan.hasNext()){
            String pai = scan.next();
            String filho = scan.next();
            int terrasFilho = scan.nextInt();
            if (povo.get(pai) != null) {
                Guerreiro g1 = povo.get(pai);
                Guerreiro g2 = new Guerreiro(g1, terrasFilho, filho);
                g1.addFilho(g2);
                g2.setPai(g1);
                povo.put(filho, g2);

            } else {

                Guerreiro g1 = new Guerreiro(pai);
                Guerreiro g2 = new Guerreiro(g1, terrasFilho, filho);
                g2.setPai(g1);
                g1.addFilho(g2);
                povo.put(pai, g1);
                povo.put(filho, g2);

            }
        }
        addRaiz();
    }


    public void registerOtherPovo () throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream("src/main/java/org/example/t2alest/OtherTribo.txt"));
        terrasRaiz = scan.nextInt();

        while(scan.hasNext()){
            String pai = scan.next();
            String filho = scan.next();
            int terrasFilho = scan.nextInt();
            if (povo.get(pai) != null) {
                Guerreiro g1 = povo.get(pai);
                Guerreiro g2 = new Guerreiro(g1, terrasFilho, filho);
                g1.addFilho(g2);
                g2.setPai(g1);
                povo.put(filho, g2);

            } else {

                Guerreiro g1 = new Guerreiro(pai);
                Guerreiro g2 = new Guerreiro(g1, terrasFilho, filho);
                g2.setPai(g1);
                g1.addFilho(g2);
                povo.put(pai, g1);
                povo.put(filho, g2);
            }
        }
        addRaiz();

    }


    public void distributeLand(){

        if(!raiz.getChildren().isEmpty()){
            raiz.giveLand();
            Set<String> set = raiz.getChildren().keySet();
            Guerreiro g;
            for (String s:
                 set) {
                g = raiz.getChildren().get(s);
                distributeLand0(g);
            }

        }
    }

    public void distributeLand0(Guerreiro g){

        if(!g.getChildren().isEmpty()){
            g.giveLand();
            Set<String> set = g.getChildren().keySet();
            Guerreiro g2;
            for (String s:
                    set) {
                g2 = g.getChildren().get(s);
                distributeLand0(g2);
            }
        }
    }


    public void getTriboDepth(){
        Set<String> people = povo.keySet();
        Guerreiro g;
        for (String s: people) {
            g = povo.get(s);
            g.getDepthValue();
        }
    }



    public void addPeople(Guerreiro g){
        povo.put(g.getName(), g);
        g.getPai().addFilho(g);
    }

    public void addRaiz () {
        for (String raiz1 : povo.keySet()) {
            Guerreiro g = povo.get(raiz1);
            if (g.pai == null) {
                this.raiz = g;
                g.setLand(terrasRaiz);
            }
        }
    }

    public Guerreiro getMostRich(){
        Guerreiro richest = raiz;
        Guerreiro g;
        int maxLand = 0;
        int maxDepth = raiz.getDepth();
        Set<String> set = povo.keySet();
        for (String s : set) {
            g = povo.get(s);
            if(g.getLand() > maxDepth){
                maxDepth = g.getDepth();
            }
        }
        for (String s : set) {
            g = povo.get(s);
            if(g.getDepth() == maxDepth && g.getLand() > maxLand){
                maxLand = g.getLand();
                richest = g;
            }
        }
        return richest;
    }

    public void printMostRich(){
        povo.get("Deldriralex").printLandDepth();
    }




    public void printSons(String s){

        Guerreiro g = povo.get(s);
        for (String s1 : g.getChildren().keySet()) {
            System.out.print(g.getChildren().get(s1).getName() + " ");
            System.out.println(g.getChildren().get(s1).getLand());
        }
        System.out.println(g.getNSons());
        System.out.println(g.getLand());
    }
}
