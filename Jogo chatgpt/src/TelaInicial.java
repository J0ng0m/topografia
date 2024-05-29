import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TelaInicial extends JFrame {
    
    public TelaInicial() {
        setTitle("Meu Jogo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null); // centralizar na tela
        
        JPanel painel = new JPanel();
        painel.setLayout(new BorderLayout());
        
        JLabel tituloLabel = new JLabel("Bem-vindo ao Meu Jogo");
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 20));
        tituloLabel.setHorizontalAlignment(SwingConstants.CENTER);
        painel.add(tituloLabel, BorderLayout.NORTH);
        
        JButton iniciarButton = new JButton("Iniciar Jogo");
        iniciarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aqui você pode iniciar o jogo
                JOptionPane.showMessageDialog(null, "Jogo iniciado!");
            }
        });
        painel.add(iniciarButton, BorderLayout.CENTER);
        
        add(painel);
        
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial();
            }
        });
    }
}