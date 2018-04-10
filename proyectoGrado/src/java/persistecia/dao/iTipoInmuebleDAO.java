/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.TipoInmuebleDTO;

/**
 *
 * @author jnieton
 */
public interface iTipoInmuebleDAO {
    
        public boolean registrar(TipoInmuebleDTO tipoInmueble);
        public TipoInmuebleDTO consultarPorId(Integer id);
	public List<TipoInmuebleDTO> consultarTodos();
	public boolean actualizar(TipoInmuebleDTO tipoInmueble);
	public boolean borrar(Integer id);
        public List<TipoInmuebleDTO> consultarPorTipo(String tipo);
    
}
