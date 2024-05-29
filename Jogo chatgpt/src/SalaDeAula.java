import javax.swing.*;
import java.awt.*;

public class SalaDeAula extends JFrame {
    
    public SalaDeAula() {
        setTitle("Arte: Sala de Aula");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharSalaDeAula(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharSalaDeAula(Graphics g) {
        // Piso
        g.setColor(new Color(184, 115, 51)); // Marrom
        g.fillRect(0, 400, getWidth(), 200);
        
        // Paredes
        g.setColor(new Color(224, 207, 175)); // Bege
        g.fillRect(0, 0, getWidth(), 400);
        
        // Lousa
        g.setColor(Color.BLACK);
        g.fillRect(50, 50, 200, 150);
        
        // Mesa
        g.setColor(new Color(139, 69, 19)); // Marrom escuro
        g.fillRect(500, 250, 200, 100);
        
        // Cadeiras
        g.setColor(new Color(0, 128, 0)); // Verde escuro
        for (int i = 0; i < 5; i++) {
            g.fillRect(50 + i * 100, 300, 50, 50);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new SalaDeAula();
            }
        });
    }
}