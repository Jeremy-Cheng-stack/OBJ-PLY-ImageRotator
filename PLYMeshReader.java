package assignment;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class PLYMeshReader implements MeshReader {
	// grab the polygon's values with vertices and store them into a hash set
	@Override
	public HashSet<Polygon> read(String fileName) throws IOException {
		File nf = new File(fileName);
		HashSet<Polygon> poly = new HashSet<Polygon>();
		ArrayList<Vertex> ver = new ArrayList<Vertex>();
		int count = 0;
		int count2 = 0;
		Scanner s1 = null;

		s1 = new Scanner(nf);
		s1.nextLine();
		s1.nextLine();
		s1.next();
		s1.next();
		int hold1 = Integer.parseInt(s1.next());
		s1.nextLine();
		s1.nextLine();
		s1.nextLine();
		s1.nextLine();
		s1.next();
		s1.next();
		int hold2 = Integer.parseInt(s1.next());
		s1.nextLine();
		s1.nextLine();
		s1.nextLine();

		while (s1.hasNextLine()) {

			// Strip the data and store in a HashSet<Polygon>
			if (count < hold1) {
				Vertex v1 = new Vertex(Double.parseDouble(s1.next()), Double.parseDouble(s1.next()),
						Double.parseDouble(s1.next()));
				ver.add(v1);// Add all vertices into array list first
				count++;

			}

			else if (count2 < hold2 & count == hold1) {// Picking the certain vertices from array list
				int want = Integer.parseInt(s1.next());
				LinkedHashSet<Vertex> v = new LinkedHashSet<Vertex>();
				for (int i = 0; i < want; i++) {
					v.add(ver.get(Integer.parseInt(s1.next())));
				}
				Polygon plyy = new Polygon(v);// Create new polygon from vertices
				poly.add(plyy);
				
				count2++;
			}
			if(s1.hasNextLine()) {
				s1.nextLine();
			}

		}

		s1.close();
		return poly;

	}

}
