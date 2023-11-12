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
        raiz = null;
        povo = new HashMap<>();
        registerPovo();
    }

    public void registerPovo () throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream("src/main/java/org/example/t2alest/tribo.txt"));
        terrasRaiz = scan.nextInt();

        while(scan.hasNext()){
            String pai = scan.next();
            String filho = scan.next();
            int terrasFilho = Integer.parseInt(scan.next());
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
                povo.put(pai, g1);
                povo.put(filho, g2);

            }
        }
        addRaiz();
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
        povo.put(g.name, g);
        g.getPai().nSons++;
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
}
