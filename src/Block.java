import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Block {
    ArrayList<ArrayList<Integer>> vertices;
    ArrayList<ArrayList<Integer>> walls;

    public Block(String selectedFile) {
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get(selectedFile));

            Map<?, ?> map = gson.fromJson(reader, Map.class);

            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey().equals("vertices")) {
                    vertices = (ArrayList<ArrayList<Integer>>) entry.getValue();
                } else if (entry.getKey().equals("walls")) {
                    walls = (ArrayList<ArrayList<Integer>>) entry.getValue();
                }
            }

            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
