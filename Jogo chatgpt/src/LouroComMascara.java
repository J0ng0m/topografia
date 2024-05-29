import javax.swing.*;
import java.awt.*;

public class LouroComMascara extends JPanel {
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Definindo a cor de fundo
        this.setBackground(Color.WHITE);
        
        // Desenhar o corpo do louro
        g.setColor(Color.YELLOW);
        g.fillOval(100, 100, 200, 300);
        
        // Desenhar a máscara preta
        g.setColor(Color.BLACK);
        g.fillOval(150, 200, 100, 150);
        
        // Desenhar os olhos
        g.setColor(Color.WHITE);
        g.fillOval(150, 150, 50, 50);
        g.fillOval(250, 150, 50, 50);
        
        // Desenhar as pupilas
        g.setColor(Color.BLACK);
        g.fillOval(165, 165, 20, 20);
        g.fillOval(265, 165, 20, 20);
        
        // Desenhar o bico
        g.setColor(Color.ORANGE);
        int[] xPoints = {200, 220, 240};
        int[] yPoints = {250, 280, 250};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Retrato de Louro com Máscara");
        LouroComMascara panel = new LouroComMascara();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.add(panel);
        frame.setVisible(true);
    }
}