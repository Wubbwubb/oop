package uebung02.aufgabe08;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestKomplexeZahl {

	@Test(expected = ArithmeticException.class)
	public void test() {

		double re1 = 6.4;
		double im1 = 7.8;

		KomplexeZahl zahl1 = new KomplexeZahl(re1, im1);
		assertEquals(re1, zahl1.getRe(), 0.0);
		assertEquals(im1, zahl1.getIm(), 0.0);

		KomplexeZahl zahl2 = new KomplexeZahl(re1, im1);
		assertTrue(zahl1.equals(zahl2));

		double re2 = 2.3;
		double im2 = 1.9;

		zahl2 = new KomplexeZahl(re2, im2);
		KomplexeZahl zahl4 = zahl1.add(zahl2);
		assertEquals(re1 + re2, zahl4.getRe(), 0.0);
		assertEquals(im1 + im2, zahl4.getIm(), 0.0);

		zahl4 = zahl1.sub(zahl2);
		assertEquals(re1 - re2, zahl4.getRe(), 0.0);
		assertEquals(im1 - im2, zahl4.getIm(), 0.0);

		zahl4 = zahl1.mul(zahl2);
		assertEquals(re1 * re2 - im1 * im2, zahl4.getRe(), 0.0);
		assertEquals(re1 * im2 + re2 * im1, zahl4.getIm(), 0.0);

		zahl4 = zahl1.div(zahl2);
		double denom = re2 * re2 + im2 * im2;
		assertEquals((re1 * re2 + im1 * im2) / denom, zahl4.getRe(), 0.0);
		assertEquals((im1 * re2 - im2 * re1) / denom, zahl4.getIm(), 0.0);

		zahl2 = new KomplexeZahl(0.0, 0.0);
		zahl1.div(zahl2);

	}

}
