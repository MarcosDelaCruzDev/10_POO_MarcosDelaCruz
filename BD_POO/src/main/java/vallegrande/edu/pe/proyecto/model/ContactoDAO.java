package vallegrande.edu.pe.proyecto.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContactoDAO {

    // SELECT: lista todos los contactos (sirve también para refrescar la TableView)
    public List<Contacto> listar() {
        List<Contacto> lista = new ArrayList<>();
        String sql = "SELECT id, nombre, apellido, telefono, correo, mensaje FROM contactos";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                lista.add(new Contacto(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("mensaje")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // INSERT: registra un contacto nuevo
    public boolean insertar(Contacto contacto) {
        String sql = "INSERT INTO contactos (nombre, apellido, telefono, correo, mensaje) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido());
            stmt.setString(3, contacto.getTelefono());
            stmt.setString(4, contacto.getCorreo());
            stmt.setString(5, contacto.getMensaje());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // UPDATE: persiste los cambios del contacto seleccionado
    public boolean actualizar(Contacto contacto) {
        String sql = "UPDATE contactos SET nombre = ?, apellido = ?, telefono = ?, correo = ?, mensaje = ? WHERE id = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, contacto.getNombre());
            stmt.setString(2, contacto.getApellido());
            stmt.setString(3, contacto.getTelefono());
            stmt.setString(4, contacto.getCorreo());
            stmt.setString(5, contacto.getMensaje());
            stmt.setInt(6, contacto.getId());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // DELETE: elimina el contacto por id
    public boolean eliminar(int id) {
        String sql = "DELETE FROM contactos WHERE id = ?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}