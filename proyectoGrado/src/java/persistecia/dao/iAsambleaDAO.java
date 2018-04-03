/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.AsambleaDTO;

/**
 *
 * @author jnieton
 */
public interface iAsambleaDAO {
    
        public boolean registrar(AsambleaDTO asamblea);
        public AsambleaDTO consultarPorId(Integer id);
	public List<AsambleaDTO> consultarTodos();
	public boolean actualizar(AsambleaDTO asamblea);
	public boolean borrar(Integer id);
    
}
