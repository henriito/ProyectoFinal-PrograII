package datos;

import domain.ActoresDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActoresDaoJDBC implements ActoresDao{

    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_actor, nombre, apellido, edad FROM actor";
    private static final String SQL_INSERT = "INSERT INTO actor(nombre, apellido, edad) VALUES(?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE actor SET nombre=?, apellido=?, edad=? WHERE id_actor = ?";
    private static final String SQL_DELETE = "DELETE FROM actor WHERE id_actor=?";

    public ActoresDaoJDBC() {

    }

    public ActoresDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<ActoresDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ActoresDTO persona = null;
        List<ActoresDTO> personas = new ArrayList<ActoresDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_actor = rs.getInt("id_actor");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int edad = rs.getInt("edad");

                persona = new ActoresDTO();
                persona.setId_actor(id_actor);
                persona.setNombre(nombre);
                persona.setApellido(apellido);
                persona.setEdad(edad);

                personas.add(persona);
            }
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }

        }

        return personas;
    }

    public int insert(ActoresDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            
            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int update(ActoresDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setInt(3, persona.getEdad());
            stmt.setInt(4, persona.getId_actor());

            rows = stmt.executeUpdate();
            System.out.println("Registros actualizado:" + rows);

        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }

    public int delete(ActoresDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_actor());
            rows = stmt.executeUpdate();
            System.out.println("Registros eliminados:" + rows);
        } finally {
            Conexion.close(stmt);
            if (this.conexionTransaccional == null) {
                Conexion.close(conn);
            }
        }

        return rows;
    }
}
