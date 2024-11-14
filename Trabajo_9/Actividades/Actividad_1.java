package Trabajo_9.Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad_1 extends JFrame {
    public Actividad_1() {
        super("FlowLayout Example");
        setLayout(new FlowLayout());

        JButton rojoButton = new JButton("Rojo");
        JButton verdeButton = new JButton("Verde");
        JButton azulButton = new JButton("Azul");

        rojoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.RED);
            }
        });

        verdeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.GREEN);
            }
        });

        azulButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getContentPane().setBackground(Color.BLUE);
            }
        });

        add(rojoButton);
        add(verdeButton);
        add(azulButton);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Actividad_1();
    }
}