package assignment;

import java.io.IOException;

public class Driver {
	public static void main(String[] args) throws IOException {
		Mesh mesh = new Mesh();
		mesh.setReader(new OBJMeshReader());
		mesh.readFromFile("/Users/NAME/object.obj");
		mesh.rotateYAxis(Math.PI / 3);
		mesh.setWriter(new OBJMeshWriter());
		mesh.writeToFile("/Users/NAME/object.obj");
		mesh.setWriter(new PLYMeshWriter());
		mesh.writeToFile("/Users/NAME/object.ply");
	}
}
