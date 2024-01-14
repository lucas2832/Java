import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Janela extends JFrame
{
    private static ImageIcon mapa = new ImageIcon("graficos/mapa.png");
    private static ImageIcon GameOver = new ImageIcon("graficos/final.jpeg");
    private static ImageIcon pt = new ImageIcon("graficos/G.O-PT.jpeg");
    private static ImageIcon hungryed = new ImageIcon("graficos/G.O-fome.jpeg");
    
    public static JLabel mapaLabel = new JLabel(mapa);
    public static JLabel GameOverLabel = new JLabel(GameOver);
    public static JLabel fomeLabel = new JLabel(hungryed);
    public static JLabel PTLabel = new JLabel(pt);
    
    public Janela (JLabel cenario) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600,600);
        setVisible(true);
        add(cenario);
    }
}
