package stos;

import org.junit.*;
import static org.junit.Assert.assertEquals;


public class StackTest {

	private Stack sut;

	@Before
    public void setUp() {
        sut = new Stack();
    }

    @After
    public void tearDown() {
        sut = null;
    }

    @Test
    public void testGetStackArray() {
        assertEquals("Tablica 10 znaków", 10, sut.getStackArray());
    }

    @Test
    public void testGetBaseSize() {
        assertEquals("Wartość bazowa = 10 ", 10, sut.getBaseSize());
    }

    @Test
    public void testTopofStack() {
        sut.setTopOfStack(4);
        assertEquals("Wartość 4", 4, sut.getTopOfStack());
    }

    @Test
    public void testIsNotFull() {
        assertEquals("Stos ma miejsce - true", true, sut.isNotFull());
        for (int i = 0; i < 10; i++) {
            sut.push(i);
        }
        assertEquals("Stos pelen - false", false, sut.isNotFull());
    }

    @Test
    public void testPeek() {
        sut.push(20);
        assertEquals("Wartość na górze stosu = 20", 20, sut.peek());
        sut.push(100);
        assertEquals("Wartość na górze stosu = 100", 100, sut.peek());
    }

    @Test
    public void testPush() {
        sut.push(5);
        assertEquals("Wartość na stosie = 5", 5, sut.peek());
        assertEquals("Wartość TopOfStack = 0", 0, sut.getTopOfStack());
    }

    @Test
    public void testIsNotEmpty() {
        sut.push(1);
        assertEquals("Stos nie jest pusty - true", true, sut.isNotEmpty());
    }

    @Test(expected = RuntimeException.class)
	public void testFailNotEmpy() {
        sut.setTopOfStack(-1);
        sut.isNotEmpty();
		assertEquals(false, false);
    }

    @Test
    public void testPop() {
        sut.push(10);
        sut.push(20);
        assertEquals("Zdjęcie ze stosu wartości 20", 20, sut.pop());
        assertEquals("Wartość na górze stosu = 10", 10, sut.peek());
    }

    @Test
    public void testResize() {
        for (int i = 0; i < 10; i++) {
            sut.push(i);
        }
        assertEquals("Stos jest pełny", false, sut.isNotFull());
        sut.resize();
        assertEquals("Powiększona wartość stosu = 20", 20, sut.getStackArray());
        assertEquals("Stos nie jest pełny po resize", true, sut.isNotFull());
    }

    @Test
    public void testCheckAndPushWithResize() {
        for (int i = 0; i < 10; i++) {
            sut.checkAndPush(i);
        }
        assertEquals("Wielkość stosu = 10", 10, sut.getTopOfStack() + 1);
        sut.checkAndPush(100);
        assertEquals("Dodano wartość i powiększono stos do 20", 20, sut.getStackArray());
        assertEquals("Ostaeni element stosu = 100", 100, sut.peek());
    }

    @Test(expected = RuntimeException.class)
	public void testFailChceckAndPush() {
		sut.setTopOfStack(-2);
        sut.checkAndPush(10);
		assertEquals(false, false);
    }

}