package assignment;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;


public class Mesh extends GraphicalObject{
	HashSet<Polygon> polygons;
	MeshReader reader;
	MeshWriter writer;
	
	void setReader(MeshReader r) {
		reader = r;
	}
	
	void setWriter(MeshWriter w) {
		writer = w;
	}
	
	void readFromFile(String fn) throws IOException {
		//search string name for the . type (.obj or .ply)
		this.polygons = reader.read(fn);
	}
	void writeToFile(String fn) throws IOException {
		writer.write(fn, polygons);
	}
	
	void transform(double m[][]) {
		ArrayList<Vertex> vl = new ArrayList<Vertex>();
		for(Polygon p: polygons) {
			for (Vertex v: p.vertices) {
				if (!vl.contains(v)) {
					vl.add(v);
					v.transform(m);
				}
			}
		}
	}

	@Override
	public int hashCode() {
		return polygons.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mesh other = (Mesh) obj;
		if (polygons.size() != other.polygons.size()) {
			return false;
		};
		if(polygons.containsAll(other.polygons)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	
}
