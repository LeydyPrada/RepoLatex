/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.TipoAsambleaDTO;

/**
 *
 * @author jnieton
 */
public interface iTipoAsambleaDAO {
    
        public boolean registrar(TipoAsambleaDTO tipoAsamblea);
        public TipoAsambleaDTO consultarPorId(Integer id);
	public List<TipoAsambleaDTO> consultarTodos();
	public boolean actualizar(TipoAsambleaDTO tipoAsamblea);
	public boolean borrar(Integer id); 
    
}
