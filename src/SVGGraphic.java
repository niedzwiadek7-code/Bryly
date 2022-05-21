import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SVGGraphic extends JPanel {
    Point[] points = new Point[10000];
    int iterator = 0;
    int pointSize = 5;
    BufferedImage svg;

    public SVGGraphic() {
        super();
        setSize(new Dimension(600, 600));
        clear();
    }

    public void setSize(Dimension r)
    {
        svg = new BufferedImage((int)r.getWidth(), (int)r.getHeight(), BufferedImage.TYPE_INT_RGB);
        setPreferredSize(r);
        setMaximumSize(r);
    }

    public void clear()
    {
        Graphics2D g = (Graphics2D) svg.getGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, svg.getWidth(), svg.getHeight());
        //ustalenie obramowania
        setBorder(BorderFactory.createLineBorder(Color.black));
        repaint();
    }

    private void drawLine(Point from, Point to) {
        Graphics2D g = (Graphics2D) svg.getGraphics();
        g.setColor(Color.black);
        g.drawLine(from.x, from.y, to.x, to.y);
        repaint();
    }

    public void drawPoint(Point p) {
        Graphics2D g = (Graphics2D) svg.getGraphics();
        g.setColor(Color.black);
        g.fillOval(p.x - pointSize, p.y - pointSize, 2 * pointSize, 2 * pointSize);
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //wyrysowanie naszego płótna na panelu
        g2d.drawImage(svg, 0, 0, this);
    }
}