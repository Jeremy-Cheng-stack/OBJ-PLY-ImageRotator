package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class OBJMeshWriter implements MeshWriter {
	@Override
	public void write(String fileName, HashSet<Polygon> polygons) throws IOException {
		LinkedHashSet<Vertex> al = new LinkedHashSet<Vertex>();
		
		File out_file = new File(fileName);

		out_file.createNewFile();

		FileWriter fi = new FileWriter(out_file.getAbsolutePath());

		for (Polygon p : polygons) {

			for (Vertex v : p.vertices) {
				al.add(v);

			}

		}
		for (Vertex v : al) {
			fi.write("v " + v.toString() + "\n");

		}

		List<Vertex> ll = new ArrayList<Vertex>(al);
	
		for (Polygon p1 : polygons) {
			fi.write("f");
			for (Vertex v : p1.vertices) {
				int hold = ll.indexOf(v);

				fi.write(" " + Integer.toString(hold + 1));
			}
			fi.write("\n");

		}
		fi.close();

	}
}
