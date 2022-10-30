package datos;

import domain.ActoresDTO;
import java.sql.SQLException;
import java.util.List;

//diseño de la interface persona.
public interface ActoresDao {
    
    public List<ActoresDTO> select() throws SQLException;
    
    public int insert(ActoresDTO persona) throws SQLException;
    
    public int update(ActoresDTO persona) throws SQLException;
    
    public int delete(ActoresDTO persona) throws SQLException;
}
