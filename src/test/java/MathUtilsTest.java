
import org.example.MathUtils;
import org.junit.jupiter.api.Test;
import org.example.t2alest.Guerreiro;
import org.example.t2alest.Main;
import org.example.t2alest.Tribo;


import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MathUtilsTest {

    @Test
    void test(){
        MathUtils math = new MathUtils();
        int expected = 2;
        int actual = math.add(1, 1);
        assertEquals(expected, actual);
    }


    //Verifico se na lista nova ele registrou 1 guerreiro a menos como esperado

    @Test
    void differentRegister () throws FileNotFoundException {

        Tribo tribo = new Tribo("TesteDoRegistro");

        int expected = 15;

        tribo.getPovo().size();

        assertEquals(expected,tribo.getPovo().size());

    }

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
