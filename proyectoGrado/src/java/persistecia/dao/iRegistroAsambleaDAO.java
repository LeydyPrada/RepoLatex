/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.RegistroAsambleaDTO;

/**
 *
 * @author jnieton
 */
public interface iRegistroAsambleaDAO {
    
        public boolean registrar(RegistroAsambleaDTO registroAsamblea);
        public RegistroAsambleaDTO consultarPorId(Integer id);
	public List<RegistroAsambleaDTO> consultarTodos();
	public boolean actualizar(RegistroAsambleaDTO registroAsamblea);
	public boolean borrar(Integer id);
        public List<RegistroAsambleaDTO> consultarPorInmueble(String inmueble);
    
}
