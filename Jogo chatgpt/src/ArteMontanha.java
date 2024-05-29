import javax.swing.*;
import java.awt.*;

public class ArteMontanha extends JFrame {
    
    public ArteMontanha() {
        setTitle("Arte: Pôr do Sol nas Montanhas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenharMontanha(g);
            }
        };
        
        add(painel);
        setVisible(true);
    }
    
    private void desenharMontanha(Graphics g) {
        // Céu
        g.setColor(new Color(255, 153, 51)); // Laranja claro
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Sol
        g.setColor(Color.YELLOW);
        g.fillOval(650, 50, 100, 100);
        
        // Montanhas
        g.setColor(new Color(139, 69, 19)); // Marrom escuro
        int[] xMontanha1 = {150, 300, 450};
        int[] yMontanha1 = {400, 100, 400};
        g.fillPolygon(xMontanha1, yMontanha1, 3);
        
        int[] xMontanha2 = {250, 400, 550};
        int[] yMontanha2 = {400, 200, 400};
        g.fillPolygon(xMontanha2, yMontanha2, 3);
        
        // Árvores
        g.setColor(new Color(0, 128, 0)); // Verde escuro
        g.fillRect(100, 450, 20, 100);
        g.fillRect(130, 450, 20, 100);
        g.fillRect(110, 400, 20, 100);
        
        g.fillRect(600, 450, 20, 100);
        g.fillRect(630, 450, 20, 100);
        g.fillRect(610, 400, 20, 100);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ArteMontanha();
            }
        });
    }
}