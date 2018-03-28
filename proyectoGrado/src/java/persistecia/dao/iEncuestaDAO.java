/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.EncuestaDTO;

/**
 *
 * @author jnieton
 */
public interface iEncuestaDAO {
    
        public boolean registrar(EncuestaDTO encuesta);
        public EncuestaDTO consultarPorId(Integer id);
	public List<EncuestaDTO> consultarTodos();
	public boolean actualizar(EncuestaDTO encuesta);
	public boolean borrar(Integer id);
    
}
