import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class Window extends JFrame implements ActionListener {

    SVGGraphic svg = new SVGGraphic();
    MenuBar menu = new MenuBar();
    Block block;
    Transformation transformationMatrix = new Transformation(svg);

    public Window() {
        super("Grafika komputerowa");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
        setJMenuBar(menu);
        add(svg);
        matchTheContent();
        setUpListener();
        setVisible(true);
    }

    public void actionPerformed(java.awt.event.ActionEvent e) {
        switch (e.getActionCommand()) {
            case "Wczytaj bryłę" -> openFile();
            case "Rotacja" -> transformationMatrix.rotation();
            case "Skalowanie" -> transformationMatrix.scale();
            case "Przesunięcie" -> transformationMatrix.translation();
            case "Odległość od rzutni" -> this.block.setDistance();
            case "Wyświetl w modelu drucianym" -> System.out.println("Wyświetl w modelu drucianym");
            case "Wyświetl w perspektywie" -> System.out.println("Wyświetl w perspektywie");
        }
    }

    public void matchTheContent() {
        pack();
        setLocationRelativeTo(null);
    }

    public void setUpListener() {
        menu.read.addActionListener(this);

        menu.rotation.addActionListener(this);
        menu.scale.addActionListener(this);
        menu.translation.addActionListener(this);

        menu.distance.addActionListener(this);
        menu.wire.addActionListener(this);
        menu.perspective.addActionListener(this);
    }

    private void openFile() {
        JFileChooser open = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JSON files", "json");
        open.setFileFilter(filter);
        int result = open.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            String selectedFile = open.getSelectedFile().getAbsolutePath();
            block = new Block(selectedFile);
        }
    }
}
