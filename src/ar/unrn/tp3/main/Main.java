package ar.unrn.tp3.main;

import ar.unrn.tp3.bd.JdbcPersistencia;
import ar.unrn.tp3.ui.UI;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        UI ui = new UI(new JdbcPersistencia());
        ui.setVisible(true);
    }
}
