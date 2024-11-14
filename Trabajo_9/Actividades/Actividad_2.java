package Trabajo_9.Actividades;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Actividad_2 extends JFrame {
    public Actividad_2() {
        super("BorderLayout Example");
        setLayout(new BorderLayout());

        JButton norteButton = new JButton("NORTE");
        JButton surButton = new JButton("SUR");
        JButton esteButton = new JButton("ESTE");
        JButton oesteButton = new JButton("OESTE");
        JButton centroButton = new JButton("CENTRO");

        norteButton.addActionListener(new ResizeAction());
        surButton.addActionListener(new ResizeAction());
        esteButton.addActionListener(new ResizeAction());
        oesteButton.addActionListener(new ResizeAction());
        centroButton.addActionListener(new ResizeAction());

        add(norteButton, BorderLayout.NORTH);
        add(surButton, BorderLayout.SOUTH);
        add(esteButton, BorderLayout.EAST);
        add(oesteButton, BorderLayout.WEST);
        add(centroButton, BorderLayout.CENTER);

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ResizeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Dimension size = getSize();
            setSize(size.width + 50, size.height + 50);
        }
    }

    public static void main(String[] args) {
        new Actividad_2();
    }
}