import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Window extends JFrame implements ActionListener {

    SVGGraphic svg = new SVGGraphic();
    MenuBar menu = new MenuBar();
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
            case "Wczytaj bryłę" -> System.out.println("Wczytaj bryłę");
            case "Wskaż punkty odniesienia" -> System.out.println("Wskaż punkty odniesienia");
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
        menu.point.addActionListener(this);
        menu.wire.addActionListener(this);
        menu.perspective.addActionListener(this);
    }
}
