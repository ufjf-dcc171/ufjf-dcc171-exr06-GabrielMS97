package br.ufjf.dcc171;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

class Janela extends JFrame {

    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int rodadas = 0;
    
    private final JLabel etiqueta = new JLabel("Escolha sua opção");
    private final JLabel computador = new JLabel("Jogada da máquina: ");
    private final JLabel mensagem = new JLabel("");
    private final JLabel rodada = new JLabel("Rodada atual: " + rodadas);
    private final JLabel vitoria = new JLabel("Vitórias " + vitorias);
    private final JLabel empate = new JLabel("Empates: " + empates);
    private final JLabel derrota = new JLabel("Derrotas " + derrotas);
    private final JRadioButton pedra = new JRadioButton("Pedra", true);
    private final JRadioButton papel = new JRadioButton("Papel", false);
    private final JRadioButton tesoura = new JRadioButton("Tesoura", false);
    private final JButton jogar = new JButton("Jogar");

    public Janela() throws HeadlessException {
        super("Pedra-Papel-Tesoura");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(etiqueta);
        add(pedra);
        add(papel);
        add(tesoura);
        add(jogar);
        add(computador);
        add(rodada);
        add(vitoria);
        add(empate);
        add(derrota);
        add(mensagem);

        ButtonGroup opcoes = new ButtonGroup();

        opcoes.add(pedra);
        opcoes.add(papel);
        opcoes.add(tesoura);

        jogar.addActionListener(new Jogar());
    }

    private class Jogar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Random rnd = new Random();
            int saida = rnd.nextInt(3);
            System.out.println(saida);
            rodadas++;

            if (saida == 0) {
                computador.setText("Jogada da máquina: " + "Pedra");
            } else if (saida == 1) {
                computador.setText("Jogada da máquina: " + "Papel");
            } else if (saida == 2) {
                computador.setText("Jogada da máquina: " + "Tesoura");
            }

            int jogada = 0;

            if (pedra.isSelected()) {
                jogada = 0;
            } else if (papel.isSelected()) {
                jogada = 1;
            } else if (tesoura.isSelected()) {
                jogada = 2;
            }

            //JOptionPane.showMessageDialog(null, "Saída: " + jogada, "A", JOptionPane.INFORMATION_MESSAGE);
            if (jogada == saida) {
                empates++;
                mensagem.setText("Empate!!");
            } else if (saida == jogada - 1) {
                vitorias++;
                mensagem.setText("Vitória!!");
            } else if (saida == jogada + 1) {
                derrotas++;
                mensagem.setText("Derrota :(");
            } else if (jogada == 0 && saida == 2) {
                vitorias++;
                mensagem.setText("Vitória!!");
            } else if (jogada == 2 && saida == 0) {
                derrotas++;
                mensagem.setText("Derrota :(");
            }
            
            //System.out.println("vitórias: " + vitorias);
            //System.out.println("derrotas: " + derrotas);
            //System.out.println("empates: " + empates);
            //System.out.println("rodadas: "+ rodadas);
            
            rodada.setText("Rodada atual: " + rodadas);
            vitoria.setText("Vitórias " + vitorias);
            derrota.setText("Derrotas " + derrotas);
            empate.setText("Empates: " + empates);
            
            if(rodadas == 7)
            {
                if(vitorias > derrotas)
                {
                    JOptionPane.showMessageDialog(null, "Você venceu a rodada!!", "Vitória!!!!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(derrotas > vitorias)
                {
                    JOptionPane.showMessageDialog(null, "Você perdeu a rodada", "Derrota!", JOptionPane.INFORMATION_MESSAGE);
                }
                else if(derrotas == vitorias)
                {
                    JOptionPane.showMessageDialog(null, "A rodada terminou empatada", "Empate!", JOptionPane.INFORMATION_MESSAGE);
                }
                rodadas = 0;
                vitorias = 0;
                derrotas = 0;
                empates = 0;
            }
        }

    }
}
