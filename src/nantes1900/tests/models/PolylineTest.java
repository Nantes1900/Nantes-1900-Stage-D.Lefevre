package nantes1900.tests.models;

import static org.junit.Assert.*;
import nantes1900.models.Polyline;
import nantes1900.models.basis.Edge;
import nantes1900.models.basis.Point;

import org.junit.Test;

/**
 * A set of tests for the class Polyline.
 * 
 * @author Daniel Lefevre
 * 
 */
public class PolylineTest {

	private Point p1 = new Point(1, 0, -1);
	private Point p2 = new Point(0, 1, 0);
	private Point p3 = new Point(-1, 2, 1);
	private Point p4 = new Point(2, 2, 2);

	private Edge e1 = new Edge(p1, p2);
	private Edge e2 = new Edge(p2, p3);
	private Edge e3 = new Edge(p3, p1);
	private Edge e4 = new Edge(p1, p4);
	private Edge e5 = new Edge(p2, p4);

	private Polyline p = new Polyline();

	/**
	 * Constructor of the PolylineTest object : create a polyline by adding 3
	 * edges.
	 */
	public PolylineTest() {
		p.add(e1);
		p.add(e2);
		p.add(e3);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#addAll(java.util.List)}
	 * .
	 */
	@Test
	public void testAddAll() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#add(nantes1900.models.basis.Edge)}.
	 */
	@Test
	public void testAddEdge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#addNeighbour(nantes1900.models.Polyline)}
	 * .
	 */
	@Test
	public void testAddNeighbour() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#add(nantes1900.models.basis.Point)}.
	 */
	@Test
	public void testAddPoint() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#changeBase(double[][])}
	 * .
	 */
	@Test
	public void testChangeBase() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#clear()}.
	 */
	@Test
	public void testClear() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#contains(nantes1900.models.basis.Edge)}
	 * .
	 */
	@Test
	public void testContainsEdge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#contains(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testContainsPoint() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#determinateSingularPoints(double)} .
	 */
	@Test
	public void testDeterminateSingularPoints() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#edgeSize()}.
	 */
	@Test
	public void testEdgeSize() {
		assertTrue(p.edgeSize() == 3);
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#getCylinder(nantes1900.models.basis.Edge, double)}
	 * .
	 */
	@Test
	public void testGetCylinder() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#getEdgeList()}.
	 */
	@Test
	public void testGetEdgeList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#getID()}.
	 */
	@Test
	public void testGetID() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#getNeighbours(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testGetNeighbours() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#getNeighbours(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testGetNeighboursPoint() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#getNumNeighbours(nantes1900.models.basis.Point)}
	 * .
	 */
	@Test
	public void testGetNumNeighbours() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#getOne()}.
	 */
	@Test
	public void testGetOne() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#getPointList()}.
	 */
	@Test
	public void testGetPointList() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#getPointsAsCoordinates()}.
	 */
	@Test
	public void testGetPointsAsCoordinates() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#isInCylinder2D(nantes1900.models.basis.Point, nantes1900.models.basis.Point, nantes1900.models.basis.Point, double)}
	 * .
	 */
	@Test
	public void testIsInCylinder2D() {
		Point p1 = new Point(0, 0, 0);
		Point p2 = new Point(1, 1, 0);
		Point p3 = new Point(2.2, 2, 0);
		Edge e = new Edge(p1, p2);
		double error = 0.3;
		assertTrue(e.isInCylinder2D(p3, error));

		p3 = new Point(3, 2, 0);
		assertFalse(e.isInCylinder2D(p3, error));
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#isNeighbour(nantes1900.models.Polyline)}
	 * .
	 */
	@Test
	public void testIsNeighbour() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#length()}.
	 */
	@Test
	public void testLength() {
		assertTrue(p.length() == 4.0 * Math.pow(3.0, 0.5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#lengthAverage()}.
	 */
	@Test
	public void testLengthAverage() {
		double d = Math.pow(4.0 / 3.0, 2) * 3.0;
		assertTrue(p.lengthAverage() == Math.pow(d, 0.5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#order()}.
	 */
	@Test
	public void testOrder() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#orientedAs(nantes1900.models.basis.Edge, double)}
	 * .
	 */
	@Test
	public void testOrientedAs() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#pointSize()}.
	 */
	@Test
	public void testPointSize() {
		assertTrue(p.pointSize() == 3);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#Polyline()}.
	 */
	@Test
	public void testPolyline() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#Polyline(java.util.List)}.
	 */
	@Test
	public void testPolylineListOfEdge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#refresh()}.
	 */
	@Test
	public void testRefresh() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#remove(nantes1900.models.basis.Edge)}.
	 */
	@Test
	public void testRemoveEdge() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#remove(nantes1900.models.Polyline)}.
	 */
	@Test
	public void testRemovePolyline() {
		Polyline pol2 = new Polyline();
		pol2.add(e1);
		pol2.add(e2);
		pol2.add(e3);
		pol2.add(e4);
		pol2.add(e5);
		pol2.remove(p);
		assertFalse(pol2.contains(e1));
		assertFalse(pol2.contains(e2));
		assertFalse(pol2.contains(e3));
		assertTrue(pol2.contains(e4));
		assertTrue(pol2.contains(e5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#returnCentroidMesh()}.
	 */
	@Test
	public void testReturnCentroidMesh() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#returnExistingMesh(nantes1900.models.Mesh)}
	 * .
	 */
	@Test
	public void testReturnExistingMesh() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#writeCentroidMesh(java.lang.String)}.
	 */
	@Test
	public void testWriteCentroidMesh() {
		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#xAverage()}.
	 */
	@Test
	public void testXAverage() {
		assertTrue(p.xAverage() == 0);
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#xBetween(double, double)}.
	 */
	@Test
	public void testXBetween() {
		Polyline p2 = new Polyline();
		p2.add(e1);
		p2.add(e2);
		p2.add(e3);
		p2.add(e4);
		p2.add(e5);
		Polyline p3 = p2.xBetween(-1.1, 1.1);
		assertTrue(p3.contains(e1));
		assertTrue(p3.contains(e2));
		assertTrue(p3.contains(e3));
		assertFalse(p3.contains(e4));
		assertFalse(p3.contains(e5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#xLengthAverage()}.
	 */
	@Test
	public void testXLengthAverage() {
		assertTrue(p.xLengthAverage() == 4.0 / 3.0);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#xMax()}.
	 */
	@Test
	public void testXMax() {
		assertTrue(p.xMax() == 1);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#xMin()}.
	 */
	@Test
	public void testXMin() {
		assertTrue(p.xMin() == -1);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#yAverage()}.
	 */
	@Test
	public void testYAverage() {
		assertTrue(p.yAverage() == 1);
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#yBetween(double, double)}.
	 */
	@Test
	public void testYBetween() {
		Polyline p2 = new Polyline();
		p2.add(e1);
		p2.add(e2);
		p2.add(e3);
		p2.add(e4);
		p2.add(e5);
		Polyline p3 = p2.yBetween(-1.1, 1.1);
		assertTrue(p3.contains(e1));
		assertFalse(p3.contains(e2));
		assertFalse(p3.contains(e3));
		assertFalse(p3.contains(e4));
		assertFalse(p3.contains(e5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#yLengthAverage()}.
	 */
	@Test
	public void testYLengthAverage() {
		assertTrue(p.yLengthAverage() == 4.0 / 3.0);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#yMax()}.
	 */
	@Test
	public void testYMax() {
		assertTrue(p.yMax() == 2);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#yMin()}.
	 */
	@Test
	public void testYMin() {
		assertTrue(p.yMin() == 0);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zAverage()}.
	 */
	@Test
	public void testZAverage() {
		assertTrue(p.zAverage() == 0);
	}

	/**
	 * Test method for
	 * {@link nantes1900.models.Polyline#zBetween(double, double)}.
	 */
	@Test
	public void testZBetween() {
		Polyline p2 = new Polyline();
		p2.add(e1);
		p2.add(e2);
		p2.add(e3);
		p2.add(e4);
		p2.add(e5);
		Polyline p3 = p2.zBetween(-1.1, 1.1);
		assertTrue(p3.contains(e1));
		assertTrue(p3.contains(e2));
		assertTrue(p3.contains(e3));
		assertFalse(p3.contains(e4));
		assertFalse(p3.contains(e5));
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zLengthAverage()}.
	 */
	@Test
	public void testZLengthAverage() {
		assertTrue(p.zLengthAverage() == 4.0 / 3.0);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zMax()}.
	 */
	@Test
	public void testZMax() {
		assertTrue(p.zMax() == 1);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zMaxPoint()}.
	 */
	@Test
	public void testZMaxPoint() {
		assertTrue(p.zMaxPoint() == p3);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zMin()}.
	 */
	@Test
	public void testZMin() {
		assertTrue(p.zMin() == -1);
	}

	/**
	 * Test method for {@link nantes1900.models.Polyline#zProjection(double)}.
	 */
	@Test
	public void testZProjection() {
		fail("Not yet implemented"); // TODO
	}

}
