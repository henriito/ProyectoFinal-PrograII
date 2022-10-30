/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package datos;

import domain.PeliculasDTO;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Windows 10
 */
public interface PeliculasDao {
    public List<PeliculasDTO> select() throws SQLException;
    
    public int insert(PeliculasDTO peli) throws SQLException;
    
    public int update(PeliculasDTO peli) throws SQLException;
    
    public int delete(PeliculasDTO peli) throws SQLException;
}
