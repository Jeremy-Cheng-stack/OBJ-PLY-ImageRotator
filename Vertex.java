package assignment;

public  class Vertex extends GraphicalObject{
	double x;
	double y;
	double z;
	
	public Vertex(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	
	void transform(double[][] m){//Person calls rotate with angle-> which uses transform here

		double dx = (this.x*m[0][0]) + (this.y*m[0][1]) + (this.z*m[0][2]);
		double dy = (this.x*m[1][0]) + (this.y*m[1][1]) + (this.z*m[1][2]);
		double dz = (this.x*m[2][0]) + (this.y*m[2][1]) + (this.z*m[2][2]);
		this.x = dx;
		this.y = dy;
		this.z = dz;
	}
	
	@Override
	public int hashCode() {
		return (int)(x*3 + y*5 +z*7);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertex other = (Vertex) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		if (z != other.z)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return (x + " " + y + " " + z);
 	}
	
}
