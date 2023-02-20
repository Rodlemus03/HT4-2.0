import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Tests {
    
    @Test
    public void testCalculate() {

        String sum = "5 2 +";
        assertEquals(7, calculadora.evaluar(sum));

        String rest = "5 2 -";
        assertEquals(3, calculadora.evaluar(rest));

        
        String mult = "5 2 *";
        assertEquals(10, calculadora.evaluar(mult));

        String divison = "10 2 /";
        assertEquals(5, calculadora.evaluar(divison));

    }
}
