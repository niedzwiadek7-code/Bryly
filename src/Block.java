import com.google.gson.Gson;

import javax.swing.*;
import java.awt.*;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Map;

public class Block extends JFrame {
    ArrayList<ArrayList<Integer>> vertices;
    ArrayList<ArrayList<Integer>> walls;

    double distance = 0;

    JTextArea textArea;

    public Block(String selectedFile) {
        super("Dane figury");

        Gson gson = new Gson();
        Reader reader;
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

        // implement JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));

        // create text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        printData();

        matchTheContent();
        setVisible(true);
    }

    public void printData() {
        this.textArea.setText(null);
        StringBuilder sb = new StringBuilder();
        sb.append("Odległość obserwatora od środka: " + this.distance + "\n\n");
        sb.append("Wierzchołki: \n");

        int i = 1;
        for (ArrayList<Integer> vertex : vertices) {
            sb.append(i++).append(". ").append(vertex.get(0)).append(" ").append(vertex.get(1)).append(" ").append(vertex.get(2)).append("\n");
        }

        sb.append("\n");
        sb.append("Sciany: \n");

        i = 1;
        for (ArrayList<Integer> wall : walls) {
            sb.append(i++).append(". ").append(wall.get(0)).append(" ").append(wall.get(1)).append(" ").append(wall.get(2)).append("\n");
        }

        sb.append("\n");
        textArea.setText(sb.toString());
    }

    public void setDistance() {
        this.distance = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj odległość:")
        );
        this.printData();
    }

    public void matchTheContent() {
        pack();
        setLocationRelativeTo(null);
    }
}
