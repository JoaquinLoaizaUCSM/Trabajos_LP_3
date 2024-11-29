/*
package Trabajo_9.Ejercicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import org.jdatepicker.impl.*;

public class TicketBookingApp extends JFrame {
    private JTextField nameField, idField;
    private JComboBox<String> originComboBox, destinationComboBox;
    private JList<String> serviceList;
    private JCheckBox headphonesCheckBox, blanketCheckBox, magazineCheckBox;
    private JRadioButton firstFloorRadioButton, secondFloorRadioButton;
    private ButtonGroup floorGroup;
    private JButton resetButton, submitButton;
    private JDatePickerImpl datePicker;

    public TicketBookingApp() {
        super("Sistema de Compra de Pasajes");
        setLayout(new BorderLayout());

        JPanel inputPanel = createInputPanel();
        add(inputPanel, BorderLayout.CENTER);

        JPanel optionsPanel = createOptionsPanel();
        add(optionsPanel, BorderLayout.NORTH);

        JPanel buttonPanel = createButtonPanel();
        add(buttonPanel, BorderLayout.SOUTH);

        setSize(1000, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(6, 2, 10, 10));

        panel.add(new JLabel("Nombre:"));
        nameField = new JTextField();
        panel.add(nameField);

        panel.add(new JLabel("Documento de Identidad:"));
        idField = new JTextField();
        panel.add(idField);

        panel.add(new JLabel("Fecha de Viaje:"));
        datePicker = createDatePicker();
        panel.add(datePicker);

        panel.add(new JLabel("Lugar de Origen:"));
        originComboBox = new JComboBox<>(new String[] {"Lima", "Arequipa", "Cusco"});
        panel.add(originComboBox);

        panel.add(new JLabel("Lugar de Destino:"));
        destinationComboBox = new JComboBox<>(new String[] {"Lima", "Arequipa", "Cusco"});
        panel.add(destinationComboBox);

        panel.add(new JLabel("Calidad de Servicio:"));
        serviceList = new JList<>(new String[] {"Económico", "Standard", "VIP"});
        panel.add(new JScrollPane(serviceList));

        return panel;
    }

    private JPanel createOptionsPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setBorder(BorderFactory.createTitledBorder("Servicios Opcionales"));
        headphonesCheckBox = new JCheckBox("Audífonos");
        blanketCheckBox = new JCheckBox("Manta");
        magazineCheckBox = new JCheckBox("Revistas");
        checkBoxPanel.add(headphonesCheckBox);
        checkBoxPanel.add(blanketCheckBox);
        checkBoxPanel.add(magazineCheckBox);
        panel.add(checkBoxPanel);

        JPanel radioButtonPanel = new JPanel();
        radioButtonPanel.setBorder(BorderFactory.createTitledBorder("Piso del Autobús"));
        firstFloorRadioButton = new JRadioButton("1er Piso");
        secondFloorRadioButton = new JRadioButton("2do Piso");
        floorGroup = new ButtonGroup();
        floorGroup.add(firstFloorRadioButton);
        floorGroup.add(secondFloorRadioButton);
        radioButtonPanel.add(firstFloorRadioButton);
        radioButtonPanel.add(secondFloorRadioButton);
        panel.add(radioButtonPanel);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();

        resetButton = new JButton("Reiniciar");
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetForm();
            }
        });
        panel.add(resetButton);

        submitButton = new JButton("Enviar");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showSummaryDialog();
            }
        });
        panel.add(submitButton);

        return panel;
    }

    private JDatePickerImpl createDatePicker() {
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Hoy");
        p.put("text.month", "Mes");
        p.put("text.year", "Año");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        return new JDatePickerImpl(datePanel, new DateComponentFormatter());
    }

    private void resetForm() {
        nameField.setText("");
        idField.setText("");
        datePicker.getModel().setValue(null);
        originComboBox.setSelectedIndex(0);
        destinationComboBox.setSelectedIndex(0);
        serviceList.clearSelection();
        headphonesCheckBox.setSelected(false);
        blanketCheckBox.setSelected(false);
        magazineCheckBox.setSelected(false);
        floorGroup.clearSelection();
    }

    private void showSummaryDialog() {
        StringBuilder summary = new StringBuilder();
        summary.append("Nombre: ").append(nameField.getText()).append("\n");
        summary.append("Documento de Identidad: ").append(idField.getText()).append("\n");
        summary.append("Fecha de Viaje: ").append(datePicker.getJFormattedTextField().getText()).append("\n");
        summary.append("Lugar de Origen: ").append(originComboBox.getSelectedItem()).append("\n");
        summary.append("Lugar de Destino: ").append(destinationComboBox.getSelectedItem()).append("\n");
        summary.append("Calidad de Servicio: ").append(serviceList.getSelectedValue()).append("\n");
        summary.append("Servicios Opcionales: ");
        if (headphonesCheckBox.isSelected()) summary.append("Audífonos ");
        if (blanketCheckBox.isSelected()) summary.append("Manta ");
        if (magazineCheckBox.isSelected()) summary.append("Revistas ");
        summary.append("\nPiso del Autobús: ");
        summary.append(firstFloorRadioButton.isSelected() ? "1er Piso" : "2do Piso");

        JOptionPane.showMessageDialog(this, summary.toString(), "Resumen de Datos", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicketBookingApp().setVisible(true));
    }
}
*/
