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

    private final JLabel etiqueta = new JLabel("Escolha sua opção");
    private final JLabel computador = new JLabel("Jogada da máquina: ");
    private final JRadioButton pedra = new JRadioButton("Pedra", true);
    private final JRadioButton papel = new JRadioButton("Papel", false);
    private final JRadioButton tesoura = new JRadioButton("Tesoura", false);
    private final JButton jogar = new JButton("Jogar");

    private int vitorias = 0;
    private int derrotas = 0;
    private int empates = 0;
    private int rodadas = 0;

    public Janela() throws HeadlessException {
        super("Pedra-Papel-Tesoura");
        setLayout(new FlowLayout(FlowLayout.CENTER));

        add(etiqueta);
        add(pedra);
        add(papel);
        add(tesoura);
        add(jogar);
        add(computador);

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
        }

    }
}
