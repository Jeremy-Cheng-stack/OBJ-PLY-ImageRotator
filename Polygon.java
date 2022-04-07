package assignment;

import java.util.LinkedHashSet;

public class Polygon extends GraphicalObject {
	LinkedHashSet<Vertex> vertices;
	//{{1,2,3}, {3,2,1}, {9,8,7}} vertex.transform
	//vertices.get[i]
	
	public Polygon (LinkedHashSet<Vertex> v) {
		this.vertices = v;
	}
	
	
	void transform(double[][] m){
		for (Vertex v: vertices) {
			v.transform(m);
		}
	}
	
	@Override
	public int hashCode() {
		return vertices.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Polygon other = (Polygon) obj;
		if (vertices.size() != other.vertices.size()) {
			return false;
		};
		if(vertices.containsAll(other.vertices)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}