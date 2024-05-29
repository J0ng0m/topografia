import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EntregaCorrespondencias extends JFrame implements ActionListener {
    private int jogadorX = 200; // posição inicial do jogador (coordenada x)
    private int jogadorY = 300; // posição inicial do jogador (coordenada y)
    private int cartaX = 0; // posição inicial da carta (coordenada x)
    private int cartaY = 100; // posição inicial da carta (coordenada y)
    private Timer timer;
    private boolean gameOver = false;

    public EntregaCorrespondencias() {
        setTitle("Entrega de Correspondências");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null); // centralizar na tela

        JPanel painel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                desenhar(g);
            }
        };

        timer = new Timer(10, this);

        painel.setFocusable(true);
        painel.requestFocusInWindow();
        painel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                moverJogador(e);
            }
        });

        add(painel);
        setVisible(true);
        timer.start();
    }

    private void desenhar(Graphics g) {
        if (!gameOver) {
            // Desenhar o fundo
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, getWidth(), getHeight());

            // Desenhar o jogador
            g.setColor(Color.BLUE);
            g.fillRect(jogadorX, jogadorY, 50, 50);

            // Desenhar a carta
            g.setColor(Color.RED);
            g.fillRect(cartaX, cartaY, 20, 20);
        } else {
            // Se o jogo acabou, exibir mensagem de fim de jogo
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            g.drawString("Game Over", 150, 250);
        }
    }

    private void moverJogador(KeyEvent e) {
        int tecla = e.getKeyCode();
        switch (tecla) {
            case KeyEvent.VK_UP:
                jogadorY -= 10;
                break;
            case KeyEvent.VK_DOWN:
                jogadorY += 10;
                break;
            case KeyEvent.VK_LEFT:
                jogadorX -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                jogadorX += 10;
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            // Movimentar a carta
            cartaX += 1;

            // Verificar colisão entre jogador e carta
            Rectangle jogadorBounds = new Rectangle(jogadorX, jogadorY, 50, 50);
            Rectangle cartaBounds = new Rectangle(cartaX, cartaY, 20, 20);
            if (jogadorBounds.intersects(cartaBounds)) {
                gameOver = true;
                timer.stop();
            }

            // Verificar se a carta saiu da tela
            if (cartaX > getWidth()) {
                cartaX = 0;
            }

            repaint();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new EntregaCorrespondencias();
            }
        });
    }
}