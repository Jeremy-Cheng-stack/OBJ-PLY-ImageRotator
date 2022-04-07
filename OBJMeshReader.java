package assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class OBJMeshReader implements MeshReader {
	// grab the polygon's values with vertices and store them into a hash set
	@Override
	public HashSet<Polygon> read(String fileName) throws IOException {
		File nf = new File(fileName);
		HashSet<Polygon> poly = new HashSet<Polygon>();
		ArrayList<Vertex> ver = new ArrayList<Vertex>();

		Scanner s1 = null;

		s1 = new Scanner(nf);

		while (s1.hasNextLine()) {// infinite loop

			String h = "j";
			if (s1.hasNext()) {
				h = s1.next();
			}

			// Strip the data and store in a HashSet<Polygon>
			if (h.equals("v")) {
				Vertex v1 = new Vertex(Double.parseDouble(s1.next()), Double.parseDouble(s1.next()),
						Double.parseDouble(s1.next()));
				ver.add(v1);// Add all vertices into array list first

			}

			else if (h.equals("f")) {// Picking the certain vertices from array list
				LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
				v.add(ver.get(Integer.parseInt(s1.next()) - 1));
				v.add(ver.get(Integer.parseInt(s1.next()) - 1));
				v.add(ver.get(Integer.parseInt(s1.next()) - 1));
				Polygon plyy = new Polygon(v);// Create new polygon from vertices
				poly.add(plyy);

			}
			if(s1.hasNextLine()){
				s1.nextLine();
			}

		}

		s1.close();
		return poly;

	}

}
