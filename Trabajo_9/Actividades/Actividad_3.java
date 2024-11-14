package Trabajo_9.Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad_3 extends JFrame {
    public Actividad_3() {
        super("GridLayout");
        setLayout(new GridLayout(2, 3)); // 2 filas y 3 columnas

        for (int i = 1; i <= 6; i++) {
            JButton button = new JButton("Botón " + i);
            button.addActionListener(new ButtonAction(i));
            add(button);
        }

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private static class ButtonAction implements ActionListener {
        private int buttonNumber;

        public ButtonAction(int buttonNumber) {
            this.buttonNumber = buttonNumber;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (buttonNumber) {
                case 1:
                    JOptionPane.showMessageDialog(null, "Botón 1 presionado");
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, "Botón 2 presionado");
                    break;
                case 3:
                    JOptionPane.showMessageDialog(null, "Botón 3 presionado");
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Botón 4 presionado");
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "Botón 5 presionado");
                    break;
                case 6:
                    JOptionPane.showMessageDialog(null, "Botón 6 presionado");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Botón desconocido presionado");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new Actividad_3();
    }
}