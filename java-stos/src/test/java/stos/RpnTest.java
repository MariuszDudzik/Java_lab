package stos;

import org.junit.Test;
import static org.junit.Assert.*;

public class RpnTest {


    @Test
    public void testIsCorrectToFalse() {
        String[] elements = {};
        Rpn rpn = new Rpn(elements);
        rpn.setIsCorrectToFalse();
        assertEquals("isCorrect = false", false, rpn.getIsCorrect());
    }


    @Test
    public void testCalculateCorrectAddition() {
        String[] elements = {"3", "4", "+"};
        Rpn rpn = new Rpn(elements);
        rpn.calculate("+", 3, 4);
        assertEquals("Wynik dodawania = 7", 7, rpn.stack.peek());
    }


    @Test
    public void testResultTrue() {
        String[] elements = {"3", "4", "+"};
        Rpn rpn = new Rpn(elements);
        rpn.stack.push(7);
        rpn.result();
        assertEquals("Wynik: 7", 7, rpn.stack.peek());
    }

    @Test(expected = RuntimeException.class)
    public void testResultFalse() {
        String[] elements = {"3", "4", "+"};
        Rpn rpn = new Rpn(elements);
        rpn.stack.push(7);
        rpn.stack.push(7);
        rpn.result();
        assertEquals("Błąd w wyrażeniu", false, false);
    }


    @Test
    public void testCalculaceValidExpressionSubtraction() {
        String[] expression = {"4", "10", "-"};
        Rpn rpn = new Rpn(expression);
        rpn.calculate("-", 4, 10);
        assertEquals("Wynik odejmowanai = 6", 6, rpn.stack.peek());
    }


    @Test
    public void testCalculateValidExpressionMultiplication() {
        String[] expression = {"3", "4", "*"};
        Rpn rpn = new Rpn(expression);
        rpn.calculate("*", 3, 4);
        assertEquals("Wynik mnożenia = 12", 12, rpn.stack.peek());
    }
  

    @Test
    public void testCorrectAddition() {
        String[] elements = {"3", "4", "+"};
        Rpn rpn = new Rpn(elements);
        rpn.stackHandling();
        assertEquals("Wynik dodawania = 7", 7, rpn.stack.peek());
    }


    @Test
    public void testValidExpressionSubtraction() {
        String[] expression = {"4", "10", "-"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Wynik odejmowanai = -6", -6, rpn.stack.peek());
    }


    @Test
    public void testValidExpressionMultiplication() {
        String[] expression = {"3", "4", "*"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Wynik mnożenia = 12", 12, rpn.stack.peek());
    }

    @Test
    public void testMultipleOperations() {
        String[] expression = {"3", "4", "+", "2", "*"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Wynik działania = 14", 14, rpn.stack.peek());
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectExpressionTooFewOperands() {
        String[] expression = {"3", "+"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Za mało liczb na stosie", false, false);
    }

    @Test(expected = RuntimeException.class)
    public void testIncorrectExpressionInvalidElement() {
        String[] expression = {"3", "a", "+"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Nieporawna wartosc", false, false);
    }

    @Test(expected = RuntimeException.class)
    public void testIsEmpty() {
        String[] expression = {"+"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Stos jest pusty", false, false);
    }


    @Test(expected = RuntimeException.class)
    public void testIncorrectExpressionTooManyOperands() {
        String[] expression = {"3", "4", "5", "+"};
        Rpn rpn = new Rpn(expression);
        rpn.stackHandling();
        assertEquals("Nieporawna wartosc", false, false);
    }

}