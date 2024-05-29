import javax.swing.*;
import java.awt.*;

public class DesenhoHomemMascara extends JFrame {
    
    public DesenhoHomemMascara() {
        setTitle("Desenho: Homem Loiro com Máscara Cirúrgica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharHomem(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharHomem(Graphics g) {
        // Rosto
        g.setColor(new Color(255, 228, 196)); // Tom de pele
        g.fillOval(150, 100, 100, 120);
        
        // Olhos
        g.setColor(Color.WHITE);
        g.fillOval(165, 125, 30, 30);
        g.fillOval(205, 125, 30, 30);
        
        // Íris
        g.setColor(new Color(102, 51, 0)); // Marrom
        g.fillOval(175, 140, 10, 10);
        g.fillOval(215, 140, 10, 10);
        
        // Sobrancelhas
        g.setColor(Color.BLACK);
        g.drawLine(170, 115, 190, 115);
        g.drawLine(210, 115, 230, 115);
        
        // Nariz
        g.drawLine(200, 140, 200, 160);
        
        // Boca
        g.setColor(Color.BLACK);
        g.drawArc(185, 165, 30, 20, 180, 180);
        
        // Cabelo
        g.setColor(new Color(255, 204, 153)); // Loiro
        g.fillOval(150, 70, 100, 60);
        
        // Máscara
        g.setColor(Color.BLUE);
        g.fillRect(160, 180, 80, 30);
        g.setColor(Color.WHITE);
        g.fillRect(180, 170, 40, 20);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DesenhoHomemMascara();
            }
        });
    }
}