package t2alest;

import org.example.t2alest.Main;
import org.example.t2alest.Tribo;
import org.example.t2alest.Guerreiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TriboTest {

    @Test
    void raizExists(){
        Tribo tribo = new Tribo(10, "x");
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

}