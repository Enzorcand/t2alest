
import org.example.MathUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MathUtilsTest {

    @Test
    void test(){
        MathUtils math = new MathUtils();
        int expected = 2;
        int actual = math.add(1, 1);
        assertEquals(expected, actual);
    }

}
