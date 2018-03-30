/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.historicoVotacionDTO;

/**
 *
 * @author jnieton
 */
public interface iHistoricoVotacion {
    
        public boolean registrar(historicoVotacionDTO histVotacion);
        public historicoVotacionDTO consultarPorId(Integer id);
	public List<historicoVotacionDTO> consultarTodos();
	public boolean actualizar(historicoVotacionDTO histVotacion);
	public boolean borrar(Integer id);
    
}
