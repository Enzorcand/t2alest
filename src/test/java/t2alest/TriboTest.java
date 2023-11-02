package t2alest;

import org.example.t2alest.Main;
import org.example.t2alest.Tribo;
import org.example.t2alest.Guerreiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


    @Data
    public class Tribo {
        private Guerreiro raiz;
        private HashMap<String, Guerreiro> povo;

        public Tribo() {
            povo = new HashMap<>();
        }

    /*
    public void addPeople(Guerreiro g) {
        povo.put(g.name, g);
        g.getPai().nSons = +1;
    }
     */

        public void add2 (String pai, String filho, int terrasFilho) {

            for (String chave : povo.keySet()) {
                if (chave.equals(pai)) {
                    Guerreiro g1 = povo.get(pai);
                    Guerreiro g2 = new Guerreiro(filho);
                    g1.addChild(g2);
                    g2.setPai(g1);
                    g2.setLand(g2.getLand() + terrasFilho);
                    povo.remove(pai);
                    povo.put(pai, g1);

                } else {
                    Guerreiro g1 = new Guerreiro(pai);
                    Guerreiro g2 = new Guerreiro(filho);

                    g2.setLand(g2.getLand() + terrasFilho);
                    g2.setPai(g1);

                    povo.put(pai,g1);
                    povo.put(filho,g2);

                }
            }



        }

        public void addRaiz () {
            for (String raiz1 : povo.keySet()) {
                Guerreiro g = povo.get(raiz1);
                if (g.pai == null) {
                    this.raiz = g;
                }
            }
        }
    }
