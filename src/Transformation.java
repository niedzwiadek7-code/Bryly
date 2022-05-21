import javax.swing.*;
import java.awt.*;

public class Transformation extends JFrame {
    private double[][] matrix;

    SVGGraphic svg;
    JTextArea textArea;

    public Transformation(SVGGraphic svg) {
        super("Macierz przekształceń");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 400);
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        this.matrix = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        this.svg = svg;

        // create text area
        textArea = new JTextArea();
        textArea.setEditable(false);
        add(textArea);
        textArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        printMatrix();

        matchTheContent();
        setVisible(true);
    }

    public void reset() {
        this.matrix = new double[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
        printMatrix();
    }

    public void matchTheContent() {
        pack();
        setLocationRelativeTo(null);
    }

    public void printMatrix() {
        textArea.setText(null);
        textArea.append("Macierz:\n");

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                textArea.append(String.format("%5f", matrix[i][j]) + "    ");
            }
            textArea.append("\n");
        }
    }
}
