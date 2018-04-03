/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.HistoricoVotacionDTO;

/**
 *
 * @author jnieton
 */
public interface iHistoricoVotacionDAO {
    
        public boolean registrar(HistoricoVotacionDTO histVotacion);
        public HistoricoVotacionDTO consultarPorId(Integer id);
	public List<HistoricoVotacionDTO> consultarTodos();
	public boolean actualizar(HistoricoVotacionDTO histVotacion);
	public boolean borrar(Integer id);
    
}
