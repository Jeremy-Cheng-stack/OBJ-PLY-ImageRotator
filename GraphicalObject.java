package assignment;

public abstract class GraphicalObject {
	
	//PLY start at line 1
	//OBJ start at line 0
	abstract void transform(double[][] m);
	
	public void rotateXAxis(double theta) {
		double m[][] = {
				{1,0,0},
				{0,Math.cos(theta),-Math.sin(theta)},
				{0,Math.sin(theta),Math.cos(theta)}
		};
		transform(m);
		
	}
	
	public void rotateYAxis(double theta) {
		double m[][] = {
				{Math.cos(theta),0,Math.sin(theta)},
				{0,1,0},
				{-Math.sin(theta),0,Math.cos(theta)}
		};
		transform(m);
		
	}
	public void rotateZAxis(double theta) {
		double m[][] = {
				{Math.cos(theta),-Math.sin(theta),0},
				{Math.sin(theta),Math.cos(theta),0},
				{0,0,1}
		};
		transform(m);
		
		
	}
	
	
	
}
