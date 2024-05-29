import javax.swing.*;
import java.awt.*;

public class DesenhoCachorro extends JFrame {
    
    public DesenhoCachorro() {
        setTitle("Desenho de um Cachorro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharCachorro(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharCachorro(Graphics g) {
        // Corpo
        g.setColor(new Color(139, 69, 19)); // Marrom escuro
        g.fillRect(100, 200, 200, 100);
        
        // Cabeça
        g.fillRect(240, 150, 60, 60);
        
        // Olhos
        g.setColor(Color.BLACK);
        g.fillOval(255, 170, 10, 10);
        g.fillOval(275, 170, 10, 10);
        
        // Orelhas
        g.fillPolygon(new int[]{240, 260, 280}, new int[]{150, 120, 150}, 3);
        g.fillPolygon(new int[]{260, 280, 300}, new int[]{120, 100, 120}, 3);
        
        // Pernas
        g.fillRect(110, 300, 30, 80);
        g.fillRect(170, 300, 30, 80);
        g.fillRect(230, 300, 30, 80);
        g.fillRect(290, 300, 30, 80);
        
        // Rabo
        g.fillPolygon(new int[]{90, 70, 70}, new int[]{250, 260, 240}, 3);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DesenhoCachorro();
            }
        });
    }
}