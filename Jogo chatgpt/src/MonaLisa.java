import javax.swing.*;
import java.awt.*;

public class MonaLisa extends JFrame {
    
    public MonaLisa() {
        setTitle("Mona Lisa Simplificada");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 800);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharMonaLisa(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharMonaLisa(Graphics g) {
        // Fundo
        g.setColor(new Color(220, 220, 220)); // Cinza claro
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Rosto
        g.setColor(new Color(255, 221, 184)); // Tom de pele
        g.fillOval(150, 100, 300, 400);
        
        // Olhos
        g.setColor(Color.WHITE);
        g.fillOval(220, 220, 50, 70);
        g.fillOval(330, 220, 50, 70);
        g.setColor(Color.BLACK);
        g.fillOval(235, 250, 20, 20);
        g.fillOval(345, 250, 20, 20);
        
        // Sobrancelhas
        g.setColor(new Color(100, 80, 50)); // Marrom escuro
        g.fillRect(230, 200, 40, 5);
        g.fillRect(340, 200, 40, 5);
        
        // Boca
        g.setColor(new Color(238, 130, 154)); // Vermelho claro
        g.fillOval(250, 340, 150, 50);
        
        // Cabelo
        g.setColor(new Color(76, 38, 0)); // Marrom escuro
        g.fillOval(150, 90, 300, 140);
        
        // Véu
        g.setColor(new Color(240, 240, 240)); // Branco
        g.fillRect(150, 120, 300, 40);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MonaLisa();
            }
        });
    }
}