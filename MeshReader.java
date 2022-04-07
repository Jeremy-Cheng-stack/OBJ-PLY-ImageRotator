package assignment;

import java.io.IOException;
import java.util.HashSet;

public interface MeshReader {
	public HashSet<Polygon> read(String fileName) throws IOException;
}
