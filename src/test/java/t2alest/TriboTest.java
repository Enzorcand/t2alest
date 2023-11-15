package t2alest;

import org.example.t2alest.Tribo;
import org.example.t2alest.Guerreiro;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriboTest {


    //Verifica se quantidade de filhos está correta
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


    //Verifico se no novo arquivo  ele registrou 1 guerreiro a menos como esperado
    @Test
    void differentRegister () throws FileNotFoundException {

        Tribo tribo = new Tribo("TesteDoRegistro");

        int expected = 15;

        tribo.getPovo().size();

        assertEquals(expected,tribo.getPovo().size());

    }

    //Verifico se no novo arquivo o método funciona com raiz diferente  como esperado
    @Test
    void differentRoots () {

        Tribo tribo = new Tribo("TesteDoRaizDiferente");

        boolean r = false;

        if (tribo.getRaiz() == tribo.getPovo().get("Klodrimanrix")) {
            r = true;
        } else {
            r = false;
        }

        boolean expected = true;

        assertEquals(true,r);

    }

    //Verifico se o guerreiro mais rico da nova lista é encontrado
    @Test
    void mostRichWarrior () {

        Tribo tribo = new Tribo("TesteGuerreiroMaisRico");

        boolean b = false;

        if (tribo.getMostRich() == tribo.getPovo().get("Thorgestax")) {
            b = true;
        } else {
            b = false;
        }

        boolean expected = true;

        assertEquals(true,b);

    }




}