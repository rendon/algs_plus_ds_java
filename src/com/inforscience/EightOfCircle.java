import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
public class EightOfCircle extends JFrame {
    public EightOfCircle()
    {
        super("Drawing");
        setSize(800, 800);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(new Drawing());
    }


    class Drawing extends JPanel {
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            //drawEightOfCircle(50, g);
            drawEightOfCircle2(200, g);
        }

        public void drawEightOfCircle(int radius, Graphics g)
        {
            int x = 0;
            int y = radius;
            while (x <= y) {
                y = (int) (Math.sqrt(radius * radius - x * x) + 0.5);
                g.drawLine(x + 100, -y + 100, x + 100, -y + 100);
                x++;
            }

            g.drawLine(5, 5, 100, 100);
        }

        public void drawEightOfCircle2(int radius, Graphics g)
        {
            double length = 2 * Math.PI * radius * 0.125;
            double delta = Math.PI / (4 * length);
            for (double theta = Math.PI * 0.25; theta <= Math.PI * 0.5; theta += delta) {
                int x = (int) (radius * Math.cos(theta) + 0.5);
                int y = (int) (radius * Math.sin(theta) + 0.5);
                g.drawLine(x + 300, -y + 300, x + 300, -y + 300);
            }
        }
    }

    public static void main(String[] args)
    {
        new EightOfCircle();
    }
}
