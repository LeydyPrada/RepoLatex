/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.OrdenDiaDTO;

/**
 *
 * @author jnieton
 */
public interface iOrdenDiaDAO {
        public boolean registrar(OrdenDiaDTO ordenDia);
        public OrdenDiaDTO consultarPorId(Integer id);
	public List<OrdenDiaDTO> consultarTodos();
	public boolean actualizar(OrdenDiaDTO ordenDia);
	public boolean borrar(Integer id); 
    
}
