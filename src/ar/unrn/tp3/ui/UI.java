package ar.unrn.tp3.ui;

import ar.unrn.tp3.bd.JdbcPersistencia;
import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.Region;
import ar.unrn.tp3.modelo.Telefono;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {
    private JTextField campoNombre;
    private JTextField campoTelefono;
    private JTextField campoRegion;

    private final JdbcPersistencia jdbcPersistencia;

    public UI(JdbcPersistencia jdbcPersistenciaParametro) {
        this.jdbcPersistencia = jdbcPersistenciaParametro;
        setupUIComponents();
    }


    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        this.campoNombre = new JTextField(10);
        this.campoRegion = new JTextField(10);
        this.campoTelefono = new JTextField(10);
        this.campoNombre.setText("");
        this.campoTelefono.setText("");
        this.campoRegion.setText("");
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(campoNombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(campoTelefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(campoRegion);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBotonCargar();
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);
    }

    private void onBotonCargar() {

        try {
            Telefono telefono = new Telefono(campoTelefono.getText());
            Region region = new Region(campoRegion.getText());
            Participante participante = new Participante(campoNombre.getText(), telefono, region);
            jdbcPersistencia.persistir(participante);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error " + e.getMessage(), "Se encontro un problea", JOptionPane.ERROR_MESSAGE);
        }


    }


}
