package ar.unrn.tp3.bd;

import ar.unrn.tp3.modelo.Participante;
import ar.unrn.tp3.modelo.PersistenciaParticipante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class JdbcPersistencia implements PersistenciaParticipante {

    private final static JdbcConexion conexionJDBC = JdbcConexion.obtenerInstancia();
    @Override
    public void persistir(Participante participante) {
        try (
                Connection conexion = conexionJDBC.obtenerConexion();
                PreparedStatement st = conexion.prepareStatement(
                        "INSERT INTO PARTICIPANTS (NAME, PHONE, REGION) VALUES (?, ?, ?)"
                )
        ) {
            try {
                st.setString(1, participante.getNombre());
                st.setString(2, participante.getTelefono().getNumero());
                st.setString(3, participante.getRegion().getNombre());
                st.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException("Problemas");
            }

        } catch (SQLException e) {
            throw new RuntimeException("No se pudo registra al participante", e);
        }
    }


}

