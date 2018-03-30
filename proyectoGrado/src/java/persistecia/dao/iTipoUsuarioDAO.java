/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.TipoUsuarioDTO;

/**
 *
 * @author jnieton
 */
public interface iTipoUsuarioDAO {
    
        public boolean registrar(TipoUsuarioDTO tipoUsuario);
        public TipoUsuarioDTO consultarPorId(Integer id);
	public List<TipoUsuarioDTO> consultarTodos();
	public boolean actualizar(TipoUsuarioDTO tipoUsuario);
	public boolean borrar(Integer id);    
}
