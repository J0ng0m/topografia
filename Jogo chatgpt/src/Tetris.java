import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Tetris extends JFrame implements ActionListener {
    private final int larguraBloco = 30;
    private final int alturaBloco = 30;
    private final int larguraTabuleiro = 10;
    private final int alturaTabuleiro = 20;
    private final int delay = 500;

    private Timer timer;
    private boolean jogoAtivo = true;
    private int[][] tabuleiro;
    private ArrayList<int[]> pecaAtual;
    private int pecaX, pecaY;
    private Random rand;

    public Tetris() {
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(larguraBloco * larguraTabuleiro, alturaBloco * alturaTabuleiro);
        setLocationRelativeTo(null); // centralizar na tela

        tabuleiro = new int[larguraTabuleiro][alturaTabuleiro];
        pecaAtual = new ArrayList<>();
        rand = new Random();

        timer = new Timer(delay, this);
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (jogoAtivo) {
                    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                        moverPeca(-1, 0);
                    } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                        moverPeca(1, 0);
                    } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                        moverPeca(0, 1);
                    } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                        rotacionarPeca();
                    }
                }
            }
        });

        gerarPeca();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jogoAtivo) {
            moverPeca(0, 1);
        }
    }

    private void moverPeca(int deltaX, int deltaY) {
        if (verificarMovimento(pecaX + deltaX, pecaY + deltaY, pecaAtual)) {
            pecaX += deltaX;
            pecaY += deltaY;
            repaint();
        } else if (deltaY > 0) { // Se a peça atingir o fundo
            fixarPeca();
            gerarPeca();
        }
    }

    private void rotacionarPeca() {
        ArrayList<int[]> novaPeca = new ArrayList<>();
        for (int[] bloco : pecaAtual) {
            int[] novoBloco = {-bloco[1], bloco[0]};
            novaPeca.add(novoBloco);
        }
        if (verificarMovimento(pecaX, pecaY, novaPeca)) {
            pecaAtual = novaPeca;
            repaint();
        }
    }

    private void fixarPeca() {
        for (int[] bloco : pecaAtual) {
            tabuleiro[pecaX + bloco[0]][pecaY + bloco[1]] = 1;
        }
    }

    private boolean verificarMovimento(int x, int y, ArrayList<int[]> peca) {
        for (int[] bloco : peca) {
            int newX = x + bloco[0];
            int newY = y + bloco[1];
            if (newX < 0 || newX >= larguraTabuleiro || newY >= alturaTabuleiro || tabuleiro[newX][newY] != 0) {
                return false;
            }
        }
        return true;
    }

    private void gerarPeca() {
        pecaAtual.clear();
        int tipo = rand.nextInt(7);
        switch (tipo) {
            case 0: // I
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{0, -1});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{0, 2});
                break;
            case 1: // J
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{0, -1});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{1, 1});
                break;
            case 2: // L
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{0, -1});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{-1, 1});
                break;
            case 3: // O
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{1, 0});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{1, 1});
                break;
            case 4: // S
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{-1, 0});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{1, 1});
                break;
            case 5: // T
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{0, -1});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{-1, 0});
                break;
            case 6: // Z
                pecaAtual.add(new int[]{0, 0});
                pecaAtual.add(new int[]{1, 0});
                pecaAtual.add(new int[]{0, 1});
                pecaAtual.add(new int[]{-1, 1});
                break;
        }
        pecaX = larguraTabuleiro / 2;
        pecaY = 0;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int x = 0; x < larguraTabuleiro; x++) {
            for (int y = 0; y < alturaTabuleiro; y++) {
                if (tabuleiro[x][y] != 0) {
                    g.setColor(Color.BLUE);
                    g.fillRect(x * larguraBloco, y * alturaBloco, larguraBloco, alturaBloco);
                    g.setColor(Color.BLACK);
                    g.drawRect(x * larguraBloco, y * alturaBloco, larguraBloco, alturaBloco);
                }
            }
        }
        for (int[] bloco : pecaAtual) {
            g.setColor(Color.RED);
            g.fillRect((pecaX + bloco[0]) * larguraBloco, (pecaY + bloco[1]) * alturaBloco, larguraBloco, alturaBloco);
            g.setColor(Color.BLACK);
            g.drawRect((pecaX + bloco[0]) * larguraBloco, (pecaY + bloco[1]) * alturaBloco, larguraBloco, alturaBloco);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Tetris::new);
    }
}