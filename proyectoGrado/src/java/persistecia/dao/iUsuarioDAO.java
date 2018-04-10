/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author jnieton
 */
public interface iUsuarioDAO {
    
        public boolean registrar(UsuarioDTO usuario);
        public UsuarioDTO consultarPorId(String id);
	public List<UsuarioDTO> consultarTodos();
	public boolean actualizar(UsuarioDTO usuario);
	public boolean borrar(String id);
        public List<UsuarioDTO> consultarUsuarioNombre(String nombre);
    
}
