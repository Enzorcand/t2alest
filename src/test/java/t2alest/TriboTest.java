package t2alest;

import org.example.t2alest.Main;
import org.example.t2alest.Tribo;
import org.example.t2alest.Guerreiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriboTest {

    @Test
    void raizExists(){
        Tribo tribo = new Tribo();
        assert(tribo.getRaiz() != null);
    }

    @Test
    void newWarriorGetLand(){
        Tribo tribo = new Tribo(5, "x");
        Guerreiro pai = tribo.getPovo().get("x");
        Guerreiro y = new Guerreiro(pai, 5, "y");
        tribo.addPeople(y);
        y.giveLand();
        Assertions.assertEquals(10, y.getLand());
    }

    @Test
    void rootHas3Sons(){
        Tribo tribo = new Tribo(5, "x");
        Guerreiro pai = tribo.getPovo().get("x");
        Guerreiro w = new Guerreiro(pai, 5, "w");
        tribo.addPeople(w);
        Guerreiro y = new Guerreiro(pai, 5, "y");
        tribo.addPeople(y);
        Guerreiro z = new Guerreiro(pai, 5, "z");
        tribo.addPeople(z);
        Assertions.assertEquals(3, tribo.getRaiz().getNSons());
    }

    @Test
    void finalTest(){
        Tribo tribo = new Tribo();
        Guerreiro g = tribo.getMostRich();
        g.printLandDepth();
        tribo.printMostRich();
    }

}