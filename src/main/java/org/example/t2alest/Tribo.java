package org.example.t2alest;

import lombok.Data;

import java.util.HashMap;

@Data
public class Tribo {
    private Guerreiro raiz;
    private HashMap<String, Guerreiro> povo;

    public Tribo(int lands, String name) {
        raiz = new Guerreiro(lands, name);
        povo = new HashMap<>();
        povo.put(raiz.getName(), raiz);
    }


    public void addPeople(Guerreiro g){
        povo.put(g.name, g);
        g.getPai().nSons =+ 1;
        g.getPai().addFilho(g);
    }
}
