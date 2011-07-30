package nantes1900.models.basis;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.vecmath.Vector3d;

import nantes1900.models.Polyline;

/**
 * Implement an edge : two points, and the triangles it belongs to.
 * 
 * @author Daniel Lefevre
 */
public class Edge {

	/**
	 * Implement a class used when the polyline is bad formed.
	 * 
	 * @author Daniel Lefevre
	 */
	public static class BadFormedPolylineException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	public static class MoreThanTwoTrianglesPerEdgeException extends Exception {
		private static final long serialVersionUID = 1L;
	}

	private transient List<Triangle> triangles = new ArrayList<Triangle>(2);

	private transient Point[] points = new Point[2];

	/**
	 * Copy constructor. Caution : use it very cautiously because it creates new
	 * Edges with same values and not the same references.
	 * 
	 * @param edge
	 *            the polyline to copy
	 */
	public Edge(final Edge edge) {
		this.points[0] = edge.getP1();
		this.points[1] = edge.getP2();
		this.triangles = new ArrayList<Triangle>(edge.triangles);
	}

	/**
	 * Constructor
	 * 
	 * @param p1
	 *            the first point
	 * @param p2
	 *            the second point
	 */
	public Edge(final Point point1, final Point point2) {
		this.points[0] = point1;
		this.points[1] = point2;
	}

	/**
	 * On many edges, return the one which is the most at the left.
	 * 
	 * @param weirdEdges
	 *            the list of edges to choose in.
	 * @param weirdPoint
	 *            the point shared by all these edges.
	 * @param normalFloor
	 *            the normal to the floor.
	 * @return the edge which is at the left.
	 */
	private Edge returnTheLeftOne(final List<Edge> weirdEdges,
			final Point weirdPoint, final Vector3d normalFloor) {

		final Vector3d vector = new Vector3d();

		vector.x = -this.returnOther(weirdPoint).getX() + weirdPoint.getX();
		vector.y = -this.returnOther(weirdPoint).getY() + weirdPoint.getY();
		vector.z = -this.returnOther(weirdPoint).getZ() + weirdPoint.getZ();

		final Vector3d cross = new Vector3d();
		cross.cross(normalFloor, vector);

		cross.normalize();

		Edge ref = null;
		double max = Double.NEGATIVE_INFINITY;
		final Vector3d vect = new Vector3d();

		for (Edge edge : weirdEdges) {
			if (edge != this) {
				vect.x = edge.returnOther(weirdPoint).getX()
						- weirdPoint.getX();
				vect.y = edge.returnOther(weirdPoint).getY()
						- weirdPoint.getY();
				vect.z = edge.returnOther(weirdPoint).getZ()
						- weirdPoint.getZ();

				vect.normalize();

				if (vector.angle(vect) * cross.dot(vect)
						/ Math.abs(cross.dot(vect)) > max) {
					max = vector.angle(vect) * cross.dot(vect)
							/ Math.abs(cross.dot(vect));
					ref = edge;
				}
			}
		}

		return ref;
	}

	/**
	 * Add a triangle to the edge
	 * 
	 * @param triangle
	 *            the triangle to add
	 * @throws MoreThanTwoTrianglesPerEdgeException
	 *             if the edge already contains 2 triangles
	 * 
	 */
	public void addTriangle(final Triangle triangle)
			throws MoreThanTwoTrianglesPerEdgeException {
		if (!this.triangles.contains(triangle)) {
			if (this.triangles.size() >= 2) {
				throw new MoreThanTwoTrianglesPerEdgeException();
			} else {
				this.triangles.add(triangle);
			}
		}
	}

	/**
	 * Create another edge with the opposite points of the two parameters
	 * 
	 * @param edge
	 *            the edge to compose with
	 * @return a new edge formed with the opposite points of the two parameters
	 */
	public Edge compose(final Edge edge) {
		final Point point = this.sharedPoint(edge);
		return new Edge(this.returnOther(point), edge.returnOther(point));
	}

	public Point computeMiddle() {
		return new Point((this.getP1().getX() + this.getP2().getX()) / 2, (this
				.getP1().getY() + this.getP2().getY()) / 2, (this.getP1()
				.getZ() + this.getP2().getZ()) / 2);
	}

	/**
	 * Contains method
	 * 
	 * @param point
	 *            the point to check
	 * @return true if p is contained, and false otherwise
	 */
	public boolean contains(final Point point) {
		return (this.points[0] == point || this.points[1] == point);
	}

	public Vector3d convertToVector3d() {
		return new Vector3d(this.getP2().getX() - this.getP1().getX(), this
				.getP2().getY() - this.getP1().getY(), this.getP2().getZ()
				- this.getP1().getZ());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		return (((Edge) obj).contains(this.points[0]) && ((Edge) obj)
				.contains(this.points[1]));
	}

	/**
	 * Return the number of triangles
	 * 
	 * @return the number of triangles
	 */
	public int getNumberTriangles() {
		return this.triangles.size();
	}

	/**
	 * Returns the number of neighbours of this contained in the polyline p.
	 * 
	 * @param polyline
	 *            the polyline in which the edges have to be
	 * @return the number of neighbours
	 */
	public int getNumNeighbours(final Polyline polyline) {
		if (!polyline.contains(this)) {
			throw new InvalidParameterException();
		}
		int counter = 0;
		for (Edge e : polyline.getEdgeList()) {
			if (this.isNeighboor(e)) {
				counter++;
			}
		}
		return counter;
	}

	/**
	 * Getter.
	 * 
	 * @return the first point
	 */
	public Point getP1() {
		return this.points[0];
	}

	/**
	 * Getter.
	 * 
	 * @return the second point
	 */
	public Point getP2() {
		return this.points[1];
	}

	/**
	 * Getter.
	 * 
	 * @return a list of points with the two points of the edge
	 */
	public List<Point> getPoints() {
		return Arrays.asList(this.points);
	}

	/**
	 * Getter
	 * 
	 * @return the list of triangles the edge belongs to
	 */
	public List<Triangle> getTriangles() {
		return this.triangles;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return ((this.points[0] == null) ? 0 : this.points[0].hashCode())
				+ ((this.points[1] == null) ? 0 : this.points[1].hashCode());
	}

	/**
	 * Check if p is contained in the cylinder which axis is this edge, which
	 * bounds are the two points of this edge, and which radius is error.
	 * 
	 * @param point
	 *            the point to check
	 * @param error
	 *            the radius of the cylinder
	 * @return true if p is contained in the cylinder and false otherwise
	 */
	public boolean isInCylinder3D(Point point, double error) {

		final double x1 = this.getP1().getX(), x2 = this.getP2().getX(), x3 = point
				.getX();
		final double y1 = this.getP1().getY(), y2 = this.getP2().getY(), y3 = point
				.getY();
		final double z1 = this.getP1().getZ(), z2 = this.getP2().getZ(), z3 = point
				.getZ();

		final double lambda = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1) + (z3 - z1)
				* (z2 - z1))
				/ ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1)
						* (z2 - z1));

		final double x4 = lambda * (x2 - x1) + x1, y4 = lambda * (y2 - y1) + y1, z4 = lambda
				* (z2 - z1) + z1;

		return (lambda >= 0 && lambda <= 1 && point.distance(new Point(x4, y4,
				z4)) <= error);
	}

	/**
	 * Check if p is contained in the frame constitued by two segments parallels
	 * to this edge with a coefficient. Caution : this method expects to be in
	 * the plane (x,y). Thus a change base must be made before.
	 * 
	 * @param point
	 *            the point to check
	 * @param error
	 *            the distance between this edge and its two parallel segments
	 *            in which p must be
	 * @return true if p is contained between those segments and false otherwise
	 */
	public boolean isInInfiniteCylinder2D(final Point point, final double error) {
		double a, b, c, cPlus, cMinus;

		final Point p1 = this.getP1();
		final Point p2 = this.getP2();

		// We calculate the equation of the segment, and of the two lines
		// parallels to it and which frame the line
		if (p1.getX() == p2.getX()) {
			a = 1;
			b = 0;
			c = -p1.getX();
		} else {
			a = -(p2.getY() - p1.getY()) / (p2.getX() - p1.getX());
			b = 1;
			c = -p1.getY() - a * p1.getX();
		}

		cPlus = -c + error;
		cMinus = -c - error;

		return (a * point.getX() + b * point.getY() < cPlus && a * point.getX()
				+ b * point.getY() > cMinus);
	}

	/**
	 * Check if p is contained in the infinite cylinder which axis is this edge,
	 * and which radius is error.
	 * 
	 * @param point
	 *            the point to check
	 * @param error
	 *            the radius of the cylinder
	 * @return true if p is contained in the infinite cylinder and false
	 *         otherwise
	 */
	public boolean isInInfiniteCylinder3D(final Point point, final double error) {

		double x1 = this.getP1().getX(), x2 = this.getP2().getX(), x3 = point
				.getX();
		double y1 = this.getP1().getY(), y2 = this.getP2().getY(), y3 = point
				.getY();
		double z1 = this.getP1().getZ(), z2 = this.getP2().getZ(), z3 = point
				.getZ();

		double lambda = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1) + (z3 - z1)
				* (z2 - z1))
				/ ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1)
						* (z2 - z1));

		double x4 = lambda * (x2 - x1) + x1, y4 = lambda * (y2 - y1) + y1, z4 = lambda
				* (z2 - z1) + z1;

		Point p4 = new Point(x4, y4, z4);

		return (point.distance(p4) <= error);
	}

	/**
	 * Check if an edge is a neighboor of this
	 * 
	 * @param e
	 *            the edge to check
	 * @return true if e shares one point with this, false if e is this, and if
	 *         it is not neighboor
	 */
	public boolean isNeighboor(Edge e) {
		if (this == e) {
			return false;
		} else {
			return (this.contains(e.points[0]) || this.contains(e.points[1]));
		}
	}

	/**
	 * Compute the length of the edge
	 * 
	 * @return the length of the edge
	 */
	public double length() {
		return this.points[0].distance(this.points[1]);
	}

	/**
	 * Check if this is oriented as another edge, with an orientation error.
	 * 
	 * @param e
	 *            the other edge
	 * @param error
	 *            the orientation error
	 * @return true if it oriented correctly, false otherwise
	 */
	public boolean orientedAs(Edge e, double error) {
		Vector3d vect1 = new Vector3d(e.getP2().getX() - e.getP1().getX(), e
				.getP2().getY() - e.getP1().getY(), e.getP2().getZ()
				- e.getP1().getZ());
		vect1.normalize();
		Vector3d vect2 = new Vector3d(
				this.getP2().getX() - this.getP1().getX(), this.getP2().getY()
						- this.getP1().getY(), this.getP2().getZ()
						- this.getP1().getZ());
		vect2.normalize();
		return (vect1.angle(vect2) < ((error / 180) * Math.PI) || vect1
				.angle(vect2) > (((180 - error) / 180) * Math.PI));
	}

	/**
	 * Project a point on the edge.
	 * 
	 * @param point
	 *            the point to project
	 * @return the point projected
	 */
	public Point project(Point point) {

		Point p1 = this.getP1(), p2 = this.getP2();
		Point p3 = point;

		double x1 = p1.getX(), x2 = p2.getX(), x3 = p3.getX();
		double y1 = p1.getY(), y2 = p2.getY(), y3 = p3.getY();
		double z1 = p1.getZ(), z2 = p2.getZ(), z3 = p3.getZ();

		double lambda = ((x3 - x1) * (x2 - x1) + (y3 - y1) * (y2 - y1) + (z3 - z1)
				* (z2 - z1))
				/ ((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1)
						* (z2 - z1));

		double x4 = lambda * (x2 - x1) + x1, y4 = lambda * (y2 - y1) + y1, z4 = lambda
				* (z2 - z1) + z1;

		return new Point(x4, y4, z4);
	}

	/**
	 * Returns the edge neighbour of this which contains p and which belongs to
	 * b. If there is a point which belongs to 4 edges, the method will take the
	 * left one, using vector considerations.
	 * 
	 * @param p
	 *            the point shared by the two edges
	 * @param b
	 *            the polyline in which must be the edge returned
	 * @param normalFloor
	 *            the normal to the floor, to select the left edge
	 * @return the edge belonging to b which contains p
	 * @throws BadFormedPolylineException
	 *             if a point in the polyline belongs nor to 2 edge neither to 4
	 *             edges
	 */
	public Edge returnLeftNeighbour(Polyline b, Point p, Vector3d normalFloor)
			throws BadFormedPolylineException {

		ArrayList<Edge> list = b.getNeighbours(p);

		if (list.size() > 3) {
			return this.returnTheLeftOne(b.getNeighbours(p), p, normalFloor);
		} else if (list.size() < 2 || list.size() == 3) {
			throw new BadFormedPolylineException();
		} else {
			list.remove(this);
			return list.get(0);
		}
	}

	/**
	 * Returns the edge neighbour of this which contains p and which belongs to
	 * b. If there is a point which does not belong to 2 edges, throw an
	 * exception.
	 * 
	 * @param p
	 *            the point shared by the two edges
	 * @param b
	 *            the polyline in which must be the edge returned
	 * @return the edge belonging to b which contains p
	 * @throws BadFormedPolylineException
	 *             if a point in the polyline does not belong to 2 edges
	 */
	public Edge returnNeighbour(Polyline b, Point p)
			throws BadFormedPolylineException {

		ArrayList<Edge> list = b.getNeighbours(p);

		if (list.size() == 2) {
			list.remove(this);
			return list.get(0);
		} else {
			throw new BadFormedPolylineException();
		}
	}

	/**
	 * Return the other point of the edge
	 * 
	 * @param p
	 *            one point of the edge
	 * @return the other point which forms the edge
	 * @throws Exception
	 */
	public Point returnOther(Point p) {
		if (this.getP1() == p) {
			return this.getP2();
		} else if (this.getP2() == p) {
			return this.getP1();
		} else {
			throw new InvalidParameterException();
		}
	}

	/**
	 * Return the other triangle this belongs to
	 * 
	 * @param t
	 *            one triangle which contains the edge
	 * @return the other triangle which contains the edge Return an exception if
	 *         the edge is bad-formed : ie it contains more than two triangles
	 * @throws MoreThanTwoTrianglesPerEdgeException
	 *             if the edge is badly formed
	 */
	public Triangle returnOther(Triangle t)
			throws MoreThanTwoTrianglesPerEdgeException {
		if (this.triangles.size() > 2) {
			throw new MoreThanTwoTrianglesPerEdgeException();
		}
		if (this.triangles.size() < 2) {
			return null;
		}
		if (this.triangles.get(0) == t) {
			return this.triangles.get(1);
		} else if (this.triangles.get(1) == t) {
			return this.triangles.get(0);
		} else {
			return null;
		}
	}

	/**
	 * Setter
	 * 
	 * @param point
	 *            the first point
	 */
	public void setP1(Point point) {
		this.points[0] = point;

	}

	/**
	 * Setter
	 * 
	 * @param point
	 *            the second point
	 */
	public void setP2(Point point) {
		this.points[1] = point;

	}

	/**
	 * Return the point shared by the two edges. Return null if the two edges
	 * don't share any point.
	 * 
	 * @param e
	 *            the edge to search in
	 * @return the point shared by this and e
	 */
	public Point sharedPoint(Edge e) {
		if (this.contains(e.getP1())) {
			return e.getP1();
		} else if (this.contains(e.getP2())) {
			return e.getP2();
		} else {
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return new String("(" + this.getP1() + ", " + this.getP2() + ")");
	}
}
