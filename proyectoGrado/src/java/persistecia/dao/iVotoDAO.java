/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.VotoDTO;

/**
 *
 * @author jnieton
 */
public interface iVotoDAO {
    
        public boolean registrar(VotoDTO voto);
        public VotoDTO consultarPorId(Integer id);
	public List<VotoDTO> consultarTodos();
	public boolean actualizar(VotoDTO voto);
	public boolean borrar(Integer id);
    
}
