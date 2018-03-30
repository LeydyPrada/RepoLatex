/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.InmuebleDTO;

/**
 *
 * @author jnieton
 */
public interface iInmuebleDAO {
    
        public boolean registrar(InmuebleDTO inmueble);
        public InmuebleDTO consultarPorId(Integer id);
	public List<InmuebleDTO> consultarTodos();
	public boolean actualizar(InmuebleDTO inmueble);
	public boolean borrar(Integer id);
    
}
