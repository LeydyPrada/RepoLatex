/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.RespuestasDTO;

/**
 *
 * @author jnieton
 */
public interface iRespuestasDAO {
    
        public boolean registrar(RespuestasDTO respuesta);
        public RespuestasDTO consultarPorId(Integer id);
	public List<RespuestasDTO> consultarTodos();
	public boolean actualizar(RespuestasDTO respuesta);
	public boolean borrar(Integer id); 
    
}
