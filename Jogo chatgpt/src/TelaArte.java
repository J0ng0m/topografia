import javax.swing.*;
import java.awt.*;

public class TelaArte extends JFrame {
    
    public TelaArte() {
        setTitle("Tela com Arte para Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharArte(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharArte(Graphics g) {
        // Desenhar o fundo
        g.setColor(new Color(135, 206, 235)); // Azul claro
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Desenhar o sol
        g.setColor(Color.YELLOW);
        g.fillOval(50, 50, 80, 80);
        
        // Desenhar nuvens
        g.setColor(Color.WHITE);
        g.fillOval(200, 100, 100, 50);
        g.fillOval(250, 120, 100, 50);
        g.fillOval(300, 100, 100, 50);
        g.fillOval(350, 120, 100, 50);
        
        // Desenhar árvores
        g.setColor(new Color(139, 69, 19)); // Marrom escuro
        g.fillRect(550, 200, 20, 100);
        g.setColor(new Color(0, 128, 0)); // Verde escuro
        g.fillOval(520, 140, 80, 80);
        g.fillOval(500, 170, 80, 80);
        g.fillOval(580, 170, 80, 80);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaArte();
            }
        });
    }
}