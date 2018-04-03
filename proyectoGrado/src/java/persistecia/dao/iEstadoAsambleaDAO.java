/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.EstadoAsambleaDTO;

/**
 *
 * @author jnieton
 */
public interface iEstadoAsambleaDAO {
    
        public boolean registrar(EstadoAsambleaDTO estadoAsamblea);
        public EstadoAsambleaDTO consultarPorId(Integer id);
	public List<EstadoAsambleaDTO> consultarTodos();
	public boolean actualizar(EstadoAsambleaDTO estadoAsamblea);
	public boolean borrar(Integer id);
    
}
