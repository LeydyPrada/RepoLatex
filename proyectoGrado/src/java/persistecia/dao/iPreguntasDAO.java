/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.PreguntasDTO;


/**
 *
 * @author jnieton
 */
public interface iPreguntasDAO {
    
        public boolean registrar(PreguntasDTO pregunta);
        public PreguntasDTO consultarPorId(Integer id);
	public List<PreguntasDTO> consultarTodos();
	public boolean actualizar(PreguntasDTO pregunta);
	public boolean borrar(Integer id);        
    
}
