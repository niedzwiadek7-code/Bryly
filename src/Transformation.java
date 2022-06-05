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
        this.matrix = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
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

    public void translation() {
        double tx = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej x:")
        );
        double ty = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej y:")
        );
        double tz = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej z:")
        );

        double[][] me = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {tx, ty, tz, 1}};
        this.matrix = MatrixOperation.multiply(this.matrix, me);

        printMatrix();
    }

    public void scale() {
        double sx = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej x:")
        );
        double sy = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej y:")
        );
        double sz = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla współrzędnej z:")
        );

        double[][] me = new double[][]{{sx, 0, 0, 0}, {0, sy, 0, 0}, {0, 0, sz, 0}, {0, 0, 0, 1}};
        this.matrix = MatrixOperation.multiply(this.matrix, me);

        printMatrix();
    }

    public void rotation() {
        double angle = Double.parseDouble(
                JOptionPane.showInputDialog("Podaj dane dla kąta:")
        );
        String axis = JOptionPane.showInputDialog("Podaj oś: (x, y, z)");

        double[][] me = new double[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        switch (axis) {
            case "x" -> me = new double[][]{{1, 0, 0, 0}, {0, Math.cos(angle), Math.sin(angle), 0}, {0, -Math.sin(angle), Math.cos(angle), 0}, {0, 0, 0, 1}};
            case "y" -> me = new double[][]{{Math.cos(angle), 0, -Math.sin(angle), 0}, {0, 1, 0, 0}, {Math.sin(angle), 0, Math.cos(angle), 0}, {0, 0, 0, 1}};
            case "z" -> me = new double[][]{{Math.cos(angle), Math.sin(angle), 0, 0}, {-Math.sin(angle), Math.cos(angle), 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        }

        this.matrix = MatrixOperation.multiply(this.matrix, me);

        printMatrix();
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

        for (double[] doubles : this.matrix) {
            for (double aDouble : doubles) {
                textArea.append(String.format("%5f", aDouble) + "    ");
            }
            textArea.append("\n");
        }
    }
}
