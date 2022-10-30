/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import domain.PeliculasDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public class PeliculasDaoJDBC {
    
    private Connection conexionTransaccional;

    private static final String SQL_SELECT = "SELECT id_pelicula, titulo, estreno, genero, valoracion FROM pelicula";
    private static final String SQL_INSERT = "INSERT INTO pelicula(titulo, estreno, genero, valoracion) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE pelicula SET titulo=?, estreno=?, genero=?, valoracion=? WHERE id_pelicula = ?";
    private static final String SQL_DELETE = "DELETE FROM pelicula WHERE id_pelicula=?";

    public PeliculasDaoJDBC() {

    }

    public PeliculasDaoJDBC(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PeliculasDTO> select() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PeliculasDTO persona = null;
        List<PeliculasDTO> personas = new ArrayList<PeliculasDTO>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_pelicula = rs.getInt("id_pelicula");
                String titulo = rs.getString("titulo");
                int estreno = rs.getInt("estreno");
                String genero = rs.getString("genero");
                float valoracion = rs.getFloat("valoracion");

                persona = new PeliculasDTO();
                persona.setId_pelicula(id_pelicula);
                persona.setTitulo(titulo);
                persona.setEstreno(estreno);
                persona.setGenero(genero);
                persona.setValoracion(valoracion);

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

    public int insert(PeliculasDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getTitulo());
            stmt.setInt(2, persona.getEstreno());
            stmt.setString(3, persona.getGenero());
            stmt.setFloat(4, persona.getValoracion());
            
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

    public int update(PeliculasDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("ejecutando query: " + SQL_UPDATE);
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getTitulo());
            stmt.setInt(2, persona.getEstreno());
            stmt.setString(3, persona.getGenero());
            stmt.setFloat(4, persona.getValoracion());
            
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

    public int delete(PeliculasDTO persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
            System.out.println("Ejecutando query:" + SQL_DELETE);
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getId_pelicula());
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
