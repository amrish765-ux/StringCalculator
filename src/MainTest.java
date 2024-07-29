import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MainTest {

    @Test
    public void testEmptyString() {
        Main calculator = new Main();
        assertEquals(0, calculator.add(""));
    }

    @Test
    public void testSingleNumber() {
        Main calculator = new Main();
        assertEquals(1, calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        Main calculator = new Main();
        assertEquals(6, calculator.add("1,5"));
    }

    @Test
    public void testNewLineBetweenNumbers() {
        Main calculator = new Main();
        assertEquals(6, calculator.add("1\n2,3"));
    }

    @Test
    public void testCustomDelimiter() {
        Main calculator = new Main();
        assertEquals(3, calculator.add("//;\n1;2"));
    }

    @Test
    public void testNegativeNumbers() {
        Main calculator = new Main();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.add("1,-2,3,-4");
        });
        assertEquals("Negative numbers not allowed: [-2, -4]", exception.getMessage());
    }

    @Test
    public void testMultipleNumbers() {
        Main calculator = new Main();
        assertEquals(15, calculator.add("1,2,3,4,5"));
    }

    @Test
    public void testCustomDelimiterWithMultipleNumbers() {
        Main calculator = new Main();
        assertEquals(10, calculator.add("//;\n1;2;3;4"));
    }
}

