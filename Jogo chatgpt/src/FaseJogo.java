import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FaseJogo extends JFrame {
    private int playerX = 100; // posição inicial do jogador (coordenada x)
    private int playerY = 100; // posição inicial do jogador (coordenada y)
    
    public FaseJogo() {
        setTitle("Fase de Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenhar(g);
            }
        };
        
        painel.setFocusable(true);
        painel.requestFocusInWindow();
        painel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moverJogador(e);
                painel.repaint();
            }
        });
        
        add(painel);
        setVisible(true);
    }
    
    private void desenhar(Graphics g) {
        // Desenhar o fundo
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        // Desenhar o jogador
        g.setColor(Color.RED);
        g.fillRect(playerX, playerY, 50, 50);
    }
    
    private void moverJogador(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                playerY -= 10;
                break;
            case KeyEvent.VK_DOWN:
                playerY += 10;
                break;
            case KeyEvent.VK_LEFT:
                playerX -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                playerX += 10;
                break;
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FaseJogo();
            }
        });
    }
}