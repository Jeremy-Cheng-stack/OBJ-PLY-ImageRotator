package assignment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class PLYMeshWriter implements MeshWriter {
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
		fi.write("ply\n");
		fi.write("format ascii 1.0\n");
		fi.write("element vertex "+ al.size() +"\n");
		fi.write("property float32 x\n");
		fi.write("property float32 y\n");
		fi.write("property float32 z\n");
		fi.write("element face "+ polygons.size()+ "\n");
		fi.write("property list uint8 int32 vertex_indices\n");
		fi.write("end_header\n");
		
		
		for (Vertex v : al) {
			fi.write(v.toString() + "\n");

		}

		List<Vertex> ll = new ArrayList<Vertex>(al);
	
		for (Polygon p1 : polygons) {
			fi.write(p1.vertices.size()+ " ");
			for (Vertex v : p1.vertices) {
				int hold = ll.indexOf(v);

				fi.write(Integer.toString(hold)+" ");
			}
			fi.write("\n");

		}
		fi.close();

	}
}
