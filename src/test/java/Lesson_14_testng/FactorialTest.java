package Lesson_14_testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.math.BigInteger;
import static org.testng.Assert.*;

public class FactorialTest {

    @DataProvider(name = "numbers")
    public static Object[][] evenNumbers() {
        return new Object[][]{
                {5, BigInteger.valueOf(120)},
                {18, new BigInteger("6402373705728000")},
                {0, BigInteger.ONE},
                {1, BigInteger.ONE},
        };
    }
    @Test(dataProvider = "numbers", description = "Проверка на расчет факториала")
    void testFactorial(int actual, BigInteger expected) {
        Factorial factorial = new Factorial();
        assertEquals(expected, factorial.factorial(actual));
    }

    @Test(description = "Проверка на отрицательное число")
    void testFactorialIsNotNegative() {
        Factorial factorial = new Factorial();
        assertThrows(IllegalArgumentException.class, () -> {
            factorial.factorial(-5);
        });
    }

    @Test(description = "Проверка на null")
    void testFactorialIsNotNull(){
        Factorial factorial = new Factorial();
        assertNotNull(factorial.factorial(46));
    }
}