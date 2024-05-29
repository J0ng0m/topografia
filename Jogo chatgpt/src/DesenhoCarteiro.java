import javax.swing.*;
import java.awt.*;

public class DesenhoCarteiro extends JFrame {
    
    public DesenhoCarteiro() {
        setTitle("Desenho de um Carteiro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharCarteiro(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharCarteiro(Graphics g) {
        // Corpo
        g.setColor(Color.BLUE);
        g.fillRect(150, 200, 100, 150);
        
        // Cabeça
        g.setColor(Color.YELLOW);
        g.fillOval(170, 150, 60, 60);
        
        // Olhos
        g.setColor(Color.BLACK);
        g.fillOval(185, 170, 10, 10);
        g.fillOval(205, 170, 10, 10);
        
        // Nariz
        g.setColor(Color.ORANGE);
        int[] xNariz = {200, 195, 205};
        int[] yNariz = {180, 190, 190};
        g.fillPolygon(xNariz, yNariz, 3);
        
        // Boca
        g.setColor(Color.RED);
        g.fillArc(190, 200, 20, 20, 180, 180);
        
        // Braços
        g.setColor(Color.BLUE);
        g.fillRect(100, 200, 50, 20);
        g.fillRect(250, 200, 50, 20);
        
        // Perna
        g.fillRect(150, 350, 20, 50);
        g.fillRect(230, 350, 20, 50);
        
        // Mala
        g.setColor(Color.GREEN);
        g.fillRect(200, 250, 50, 50);
        
        // Chapéu
        g.setColor(Color.BLUE);
        int[] xChapeu = {170, 230, 190, 210};
        int[] yChapeu = {150, 150, 170, 170};
        g.fillPolygon(xChapeu, yChapeu, 4);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DesenhoCarteiro();
            }
        });
    }
}