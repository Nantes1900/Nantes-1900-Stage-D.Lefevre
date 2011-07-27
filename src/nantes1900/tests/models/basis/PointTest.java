package nantes1900.tests.models.basis;

import static org.junit.Assert.*;

import javax.vecmath.Vector3d;

import nantes1900.models.basis.Point;
import nantes1900.utils.MatrixMethod;
import nantes1900.utils.MatrixMethod.SingularMatrixException;

import org.junit.Test;

/**
 * A set of tests for the class Point.
 * 
 * @author Daniel Lefevre
 * 
 */
public class PointTest {
	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#changeBase(double[][])}.
	 */
	@Test
	public void testChangeBase() {
		Vector3d vect = new Vector3d(0, 0, 1);

		try {

			double[][] matrix = MatrixMethod.createOrthoBase(vect);

			double x = 1.2366646772;
			double y = 435.23134144;
			double z = -210.35681944;
			Point p = new Point(x, y, z);

			p.changeBase(matrix);

			Point pChanged = new Point(0, 0, 0);
			double[] coords = { x, y, z };
			pChanged.set(MatrixMethod.changeBase(coords, matrix));

			assertTrue(p.equals(pChanged));

		} catch (SingularMatrixException e) {
			fail();
		}
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#distance(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testDistance() {
		Point p1 = new Point(0, 0, 0);
		double x = 1.2366646772;
		double y = 435.23134144;
		double z = -210.35681944;
		Point p2 = new Point(x, y, z);
		assertTrue(p1.distance(p2) == Math.pow(
				Math.pow(p2.getX() - p1.getX(), 2)
						+ Math.pow(p2.getY() - p1.getY(), 2)
						+ Math.pow(p2.getZ() - p1.getZ(), 2), 0.5));
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#equals(java.lang.Object)}.
	 */
	@Test
	public void testEquals() {
		Point p1 = new Point(0, 0, 0);
		Point p2 = p1;
		assertTrue(p2.equals(p1));

		p2 = new Point(p1);
		assertTrue(p2.equals(p1));

		p2.setX(1.0);
		assertFalse(p2.equals(p1));
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#equals(java.lang.Object)}.
	 */
	@Test
	public void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#getPointAsCoordinates()}.
	 */
	@Test
	public void testGetPointAsCoordinates() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#getX()}.
	 */
	@Test
	public void testGetX() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#getY()}.
	 */
	@Test
	public void testGetY() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#getZ()}.
	 */
	@Test
	public void testGetZ() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#hashCode()}.
	 */
	@Test
	public void testHashCode() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#Point(double, double, double)}.
	 */
	@Test
	public void testPointDoubleDoubleDouble() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#Point(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testPointPoint() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#set(double[])}.
	 */
	@Test
	public void testSet() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#set(double[])}.
	 */
	@Test
	public void testSetDoubleArray() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.basis.Point#set(double, double, double)}.
	 */
	@Test
	public void testSetDoubleDoubleDouble() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#setX(double)}.
	 */
	@Test
	public void testSetX() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#setY(double)}.
	 */
	@Test
	public void testSetY() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#setZ(double)}.
	 */
	@Test
	public void testSetZ() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.basis.Point#toString()}.
	 */
	@Test
	public void testToString() {
		fail("Not yet implemented"); // TODO
	}

}
