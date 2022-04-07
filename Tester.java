package assignment;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;

import org.junit.jupiter.api.Test;



class Tester {
	//Vertex.java test
	@Test
	void testHashcode() {
		Vertex p1 = new Vertex(1,2,3);
		assertTrue(p1.equals(p1));
	}
	
	@Test
	void testNullobject() {
		Vertex p1 = new Vertex(1,2,3);
		
		assertFalse(p1.equals(null));
	}
	
	@Test
	void testDiffobject() {
		Vertex p1 = new Vertex(2,2,4);
		Vertex p2 = new Vertex(4,3,2);
		
		assertFalse(p1.equals(p2));
	}
	@Test
	void testDifferent() {
		Vertex p1 = new Vertex(1,2,3);
		
		assertFalse(p1.equals(6));
	}
	
	@Test
	void testX() {
		Vertex p1 = new Vertex(1,2,4);
		Vertex p2 = new Vertex(1,4,3);
		
		
		assertFalse(p1.equals(p2));
	}
	
	@Test
	void testY() {
		Vertex p1 = new Vertex(3,4,5);
		Vertex p2 = new Vertex(3,4,5);
		
		
		assertTrue(p1.equals(p2));
	}
	@Test
	void testz() {
		Vertex p1 = new Vertex(3,4,6);
		Vertex p2 = new Vertex(3,4,5);
		
		
		assertFalse(p1.equals(p2));
	}
	
	@Test
	void testtoString() {
		Vertex p1 = new Vertex(3,4,5);
		assertEquals(p1.toString(),"3.0 4.0 5.0");
	}
	@Test
	void testhashV() {
		Vertex p1 = new Vertex(3,4,5);
		assertEquals(p1.hashCode(),64);
	}
	
	@Test
	void testrX() {
		Vertex p1 = new Vertex(1,0,0);
		p1.rotateXAxis(Math.PI);
		
		Vertex p2 = new Vertex(1,0,0);
		assertEquals(p1,p2);
	}
	@Test
	void testrY() {
		Vertex p1 = new Vertex(0,1,0);
		p1.rotateYAxis(Math.PI);
		
		Vertex p2 = new Vertex(0,1,0);
		assertEquals(p1,p2);
	}
	@Test
	void testrZ() {
		Vertex p1 = new Vertex(0,0,1);
		p1.rotateZAxis(Math.PI);
		
		Vertex p2 = new Vertex(0,0,1);
		assertEquals(p1,p2);
	}
	
	@Test
	void testrMeshEquals() {
		Vertex p1 = new Vertex(0,0,1);
		Vertex p2 = new Vertex(3,0,1);
		Vertex p3 = new Vertex(0,2,1);
		LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
		v.add(p1);
		v.add(p2);
		v.add(p3);
		
		Polygon s1 = new Polygon(v);
		
		HashSet<Polygon> p = new HashSet<Polygon>();
		p.add(s1);
		
		Vertex p4 = new Vertex(4,0,1);
		Vertex p5 = new Vertex(2,0,1);
		Vertex p6 = new Vertex(2,2,1);
		LinkedHashSet<Vertex> v2 = new LinkedHashSet<Vertex>();
		v2.add(p4);
		v2.add(p5);
		v2.add(p6);
		
		Polygon s2 = new Polygon(v2);
		
		Vertex p7 = new Vertex(0,5,1);
		Vertex p8 = new Vertex(3,6,1);
		Vertex p9 = new Vertex(0,7,1);
		LinkedHashSet<Vertex> v3 = new LinkedHashSet<Vertex>();
		v3.add(p7);
		v3.add(p8);
		v3.add(p9);
		
		Polygon s3 = new Polygon(v3);
		
		HashSet<Polygon> poly = new HashSet<Polygon>();
		poly.add(s2);
		poly.add(s1);
		Mesh m2 = new Mesh();
		m2.polygons = poly;
		
		Mesh m = new Mesh();
		m.polygons = p;
		
		
		assertTrue(m.equals(m));
		assertFalse(m.equals(null));
		assertFalse(m.equals(6));
		assertFalse(m2.equals(m));
		p.add(s2);
		assertTrue(m2.equals(m));
		p.remove(s2);
		p.add(s3);
		assertFalse(m2.equals(m));
		
		
		
	}
	@Test
	void testsetr() {
		OBJMeshReader r = new OBJMeshReader();
		
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		assertNotSame(mesh.reader,r);
		
	}
	@Test
	void testsetw() {
		OBJMeshWriter r = new OBJMeshWriter();
		
		Mesh mesh = new Mesh();
		mesh.setWriter(new OBJMeshWriter());
		assertNotSame(mesh.reader,r);
		
	}
	
	@Test
	void testrMeshT() {
		Vertex p1 = new Vertex(1,0,0);
		Vertex p2 = new Vertex(0,1,0);
		Vertex p3 = new Vertex(0,0,1);
		LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
		v.add(p1);
		v.add(p2);
		v.add(p3);
		
		Polygon s1 = new Polygon(v);
		
		HashSet<Polygon> p = new HashSet<Polygon>();
		p.add(s1);
		
		Vertex p4 = new Vertex(7,4,7);
		Vertex p5 = new Vertex(1,0,0);
		Vertex p6 = new Vertex(0,5,1);
		LinkedHashSet<Vertex> v2 = new LinkedHashSet<Vertex>();
		v2.add(p4);
		v2.add(p5);
		v2.add(p6);
		
		Polygon s2 = new Polygon(v2);
		
		Vertex p7 = new Vertex(1,0,0);
		Vertex p8 = new Vertex(0,5,0);
		Vertex p9 = new Vertex(0,0,7);
		LinkedHashSet<Vertex> v3 = new LinkedHashSet<Vertex>();
		v3.add(p7);
		v3.add(p8);
		v3.add(p9);
		
		Polygon s3 = new Polygon(v3);
		
		HashSet<Polygon> poly = new HashSet<Polygon>();
		poly.add(s2);
		poly.add(s3);
		Mesh m2 = new Mesh();
		m2.polygons = poly;
		
		
		Mesh m = new Mesh();
		m.polygons = p;
		
		m2.rotateYAxis(Math.PI/3);
		assertEquals(m.hashCode(),15);
		
		
		
	}
	
	@Test
	void testpoly() {
		Vertex p4 = new Vertex(7,4,7);
		Vertex p5 = new Vertex(1,0,0);
		Vertex p6 = new Vertex(0,5,1);
		LinkedHashSet<Vertex> v2 = new LinkedHashSet<Vertex>();
		v2.add(p4);
		v2.add(p5);
		v2.add(p6);
		
		Polygon s2 = new Polygon(v2);
		
		Vertex p1 = new Vertex(7,4*Math.cos(Math.PI/3)-7*Math.sin(Math.PI/3),7*Math.cos(Math.PI/3)+4*Math.sin(Math.PI/3));
		Vertex p2 = new Vertex(1,0*Math.cos(Math.PI/3)-0*Math.sin(Math.PI/3),0*Math.cos(Math.PI/3)+0*Math.sin(Math.PI/3));
		Vertex p3 = new Vertex(0,5*Math.cos(Math.PI/3)-1*Math.sin(Math.PI/3),1*Math.cos(Math.PI/3)+5*Math.sin(Math.PI/3));
		LinkedHashSet<Vertex> v1 = new LinkedHashSet<Vertex>();
		v1.add(p1);
		v1.add(p2);
		v1.add(p3);
		
		Polygon s1 = new Polygon(v1);
		
		s2.rotateXAxis(Math.PI/3);
		
		assertTrue(s1.equals(s2));
	}
	
	
	@Test
	void testpoly2() {
		Vertex p4 = new Vertex(7,4,7);
		Vertex p5 = new Vertex(1,0,0);
		Vertex p6 = new Vertex(0,5,1);
		LinkedHashSet<Vertex> v2 = new LinkedHashSet<Vertex>();
		v2.add(p4);
		v2.add(p5);
		v2.add(p6);
		
		Vertex p1 = new Vertex(1,0,0);
		Vertex p2 = new Vertex(0,1,0);
		Vertex p3 = new Vertex(0,0,1);
		v2.add(p1);
		v2.add(p2);
		v2.add(p3);
		
		Polygon s2 = new Polygon(v2);
		
		Vertex p7 = new Vertex(1,0,0);
		Vertex p8 = new Vertex(0,5,0);
		Vertex p9 = new Vertex(0,0,7);
		LinkedHashSet<Vertex> v3 = new LinkedHashSet<Vertex>();
		v3.add(p7);
		v3.add(p8);
		v3.add(p9);
		
		Polygon s3 = new Polygon(v3);
		
		assertTrue(s2.equals(s2));
		assertFalse(s2.equals(null));
		assertFalse(s2.equals(6));
		assertFalse(s2.equals(s3));
	}
	
	@Test
	void testpoly3() {
		Vertex p1 = new Vertex(1,0,0);
		Vertex p2 = new Vertex(0,1,0);
		Vertex p3 = new Vertex(0,0,1);
		LinkedHashSet<Vertex> v1 = new LinkedHashSet<Vertex>();
		v1.add(p1);
		v1.add(p2);
		v1.add(p3);
		Polygon s1 = new Polygon(v1);
		
		Vertex p4 = new Vertex(1,0,0);
		Vertex p5 = new Vertex(0,5,0);
		Vertex p6 = new Vertex(0,0,7);
		LinkedHashSet<Vertex> v2 = new LinkedHashSet<Vertex>();
		v2.add(p4);
		v2.add(p5);
		v2.add(p6);
		
		Polygon s2 = new Polygon(v2);
		
		Vertex p7 = new Vertex(1,0,0);
		Vertex p8 = new Vertex(0,5,0);
		Vertex p9 = new Vertex(0,0,7);
		LinkedHashSet<Vertex> v3 = new LinkedHashSet<Vertex>();
		v3.add(p7);
		v3.add(p8);
		v3.add(p9);
		
		Polygon s3 = new Polygon(v3);
		
		assertTrue(s2.equals(s3));
		assertFalse(s1.equals(s2));
	}
	
	@Test
	void testobj() throws IOException {
		Mesh mesh=new Mesh();
		Mesh mesh2 = new Mesh();
		Mesh mesh3 = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("/Users/jeremycheng/Bruh/test.obj");
		mesh.rotateYAxis(Math.PI/3);
		mesh.setWriter(new OBJMeshWriter());
		mesh.writeToFile("/Users/jeremycheng/Bruh/output.obj");
		
		mesh2.setReader(new OBJMeshReader());
		mesh2.readFromFile("/Users/jeremycheng/Bruh/output.obj");
		
		mesh3.setReader(new OBJMeshReader());
		mesh3.readFromFile("/Users/jeremycheng/Bruh/testR.obj");
		
		assertTrue(mesh3.equals(mesh2));
	}
	
	@Test
	void testply() throws IOException {
		Mesh mesh=new Mesh();
		Mesh mesh2 = new Mesh();
		Mesh mesh3 = new Mesh();
		mesh.setReader(new PLYMeshReader());
		mesh.readFromFile("/Users/jeremycheng/Bruh/testPLY.ply");
		mesh.rotateYAxis(Math.PI/3);
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile("/Users/jeremycheng/Bruh/outputply.ply");
		
		mesh2.setReader(new PLYMeshReader());
		mesh2.readFromFile("/Users/jeremycheng/Bruh/outputply.ply");
		
		mesh3.setReader(new PLYMeshReader());
		mesh3.readFromFile("/Users/jeremycheng/Bruh/testRply.ply");
		
		assertTrue(mesh3.equals(mesh2));
	}
	
}
