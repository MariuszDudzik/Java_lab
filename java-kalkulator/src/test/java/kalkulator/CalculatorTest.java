package kalkulator;

import org.junit.*;
import static org.junit.Assert.assertEquals;

public class CalculatorTest {

	private Calculator sut;

	@Before
    public void setUp() {
        sut = new Calculator();
    }

	@Test
	public void testAddOne(){
		// Arrange
		// sut = System Under Test
		// Act
		sut.add(1);
		// Assert
		assertEquals("0+1 = 1", 1, sut.getState(), 0.00001);
	}

	@Test
	public void testMultOneByTwo(){
		sut.setState(1);
		sut.mult(2);
		assertEquals("1*2 = 2", 2, sut.getState(), 0.00001);
	}

	@Test
	public void testAddZero(){
		sut.add(0);
		assertEquals("0+0 = 0", 0, sut.getState(), 0.00001);
	}

	@Test
	public void testAddminusOne(){
		sut.add(-1);
		assertEquals("0-1 = -1", -1,  sut.getState(), 0.00001);
	}

	@Test
	public void testMultbyZero(){
		sut.setState(2);
		sut.mult(0);
		assertEquals("2*0 = 0", 0, sut.getState(), 0.00001);
	}

	@Test
	public void testMulbytminusTwo(){
		sut.setState(2);
		sut.mult(-2);
		assertEquals("2*-2 = -4", -4,sut.getState(), 0.00001);
	}
	/* 
	@Test
	public void testMaxIntAddFour(){
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE); // 2147483647
		sut.add(4	);
		assertEquals("Przepelnienie", Integer.MIN_VALUE + 3, sut.getState());
	}

	@Test
	public void testMaxIntMultFour(){
		Calculator sut = new Calculator();
		sut.setState(Integer.MAX_VALUE); // 2147483647
		sut.mult(4	);
		// przepelnie zwroci maxint czyli 2147483647 * 4 bo mnozymy przez 4 modulo 2^32 
		assertEquals("Przepelnienie", (int)(Integer.MAX_VALUE * 4 % (long)Math.pow(2, 32)), sut.getState());
	}
	

	@Test
	public void testDoubleOverflowMultiplication() {
		sut.setState(Double.MAX_VALUE);
		sut.mult(2.0);

		assertEquals("Infinity", Double.POSITIVE_INFINITY, sut.getState(), 0.00001);
	}

	*/

	@Test(expected = RuntimeException.class)
	public void testDoubleOverflowMultiplication() {
		sut.setState(Double.MAX_VALUE);
		sut.mult(2.0);
		assertEquals("Przekroczono zakres po mnożeniu", Double.POSITIVE_INFINITY);
	}

	@Test
	public void testDivVbyTwo() {
		sut.setState(8);
		sut.div(2);
		assertEquals("8:2 = 4", 4.0, sut.getState(), 0.00001);
	}

	@Test(expected = RuntimeException.class)
	public void testDivByZero() {
		sut.setState(10);
		sut.div(0);
		assertEquals(true, true);
	}

	@Test
	public void testDivNegativeTwo() {
		sut.setState(7); 
		sut.div(-2);
		assertEquals("7:(-2) = -3.5", -3.5, sut.getState(), 0.00001);
	}

	@Test
	public void tesPowBySix() {
		sut.setState(2); 
		sut.pow(6);
		assertEquals("2^6 = 64", 64, sut.getState(), 0.00001);
	}

	@Test
	public void tesPowByZero() {
		sut.setState(2); 
		sut.pow(0);
		assertEquals("2^0 = 1", 1, sut.getState(), 0.00001);
	}

	@Test
	public void tesPowByNegativeTwo() {
		sut.setState(2); 
		sut.pow(-2);
		assertEquals("2^(-2) = 0.25", 0.25, sut.getState(), 0.00001);
	}

	@Test
	public void tesSetMemory() {
		sut.setState(2);
		sut.setMemory();
		assertEquals("2", 2, sut.getMemory(), 0.00001);
	}

	@Test
	public void tesGetMemory() {
		sut.setState(7);
		sut.setMemory();
		sut.getMemory();
		assertEquals("7", 7, sut.getMemory(), 0.00001);
	}

	@Test
	public void testclearMemory() {
		sut.setState(7);
		sut.setMemory();
		sut.clearMemory();
		assertEquals("0", 0, sut.getMemory(), 0.00001);
	}

	@Test
    public void testSetError() {
        sut.setError();
        assertEquals(true, sut.isError());
    }

    @Test
    public void testClearError() {
        sut.setError(); 
        sut.clearError(); 
        assertEquals(false, sut.isError());
    }


	@Test(expected = RuntimeException.class)
	public void testAddOverflowInfinityError() {
		sut.setState(Double.MAX_VALUE);
		sut.add(Double.MAX_VALUE);
		assertEquals(true, true);
	}
 
	@Test(expected = RuntimeException.class)
	public void testPowOverflowInfinityError() {
		sut.setState(Double.MAX_VALUE);
		sut.pow(2);
		assertEquals(true, true);
	}
 
	@Test(expected = RuntimeException.class)
	public void testAddThrowsErrorWhenInErrorState() {
		sut.setError();
		sut.add(10);
		assertEquals(true, true);
	}
 
	 
	@Test(expected = RuntimeException.class)
	public void testMultThrowsErrorWhenInErrorState() {
		sut.setError();
		sut.mult(10);
		assertEquals(true, true);
	}
 
	@Test(expected = RuntimeException.class)
	public void testPowThrowsErrorWhenInErrorState() {
		 sut.setError();
		 sut.pow(2);
		 assertEquals(true, true);
	 }

	@Test(expected = RuntimeException.class)
	public void testiddigit() {
		 sut.isdigit(null);
		 assertEquals(true, true);
	 }
	
}
