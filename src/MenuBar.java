import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;

public class MenuBar extends JMenuBar
{
    JMenu file = new JMenu("Plik");
    JMenu operation = new JMenu("Operacje");

    // file
    JMenuItem read = new JMenuItem("Wczytaj bryłę");

    // edit
    JMenuItem point = new JMenuItem("Wskaż punkty odniesienia");
    JMenuItem wire = new JMenuItem("Wyświetl w modelu drucianym");
    JMenuItem perspective = new JMenuItem("Wyświetl w perspektywie");

    public MenuBar()
    {
        file.add(read);
        add(file);

        operation.add(point);
        operation.add(new JSeparator());
        operation.add(wire);
        operation.add(perspective);
        add(operation);
    }
}
