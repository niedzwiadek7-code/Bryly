import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class MenuBar extends JMenuBar
{
    JMenu file = new JMenu("Plik");
    JMenu transform = new JMenu("Transformacja");
    JMenu operation = new JMenu("Operacje");

    // file
    JMenuItem read = new JMenuItem("Wczytaj bryłę");

    // transform
    JMenuItem rotation = new JMenuItem("Rotacja");
    JMenuItem scale = new JMenuItem("Skalowanie");
    JMenuItem translation = new JMenuItem("Przesunięcie");

    // edit
    JMenuItem distance = new JMenuItem("Odległość od rzutni");
    JMenuItem wire = new JMenuItem("Wyświetl w modelu drucianym");
    JMenuItem perspective = new JMenuItem("Wyświetl w perspektywie");

    public MenuBar()
    {
        file.add(read);
        add(file);

        transform.add(rotation);
        transform.add(scale);
        transform.add(translation);
        add(transform);

        operation.add(distance);
        operation.add(new JSeparator());
        operation.add(wire);
        operation.add(perspective);
        add(operation);
    }
}
