/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author jnieton
 */
public interface iTipoEncuestaDAO {
    
        public boolean registrar(TipoEncuestaDTO tipoEncuesta);
        public TipoEncuestaDTO consultarPorId(Integer id);
	public List<TipoEncuestaDTO> consultarTodos();
	public boolean actualizar(TipoEncuestaDTO tipoEncuesta);
	public boolean borrar(Integer id); 
        public List<TipoEncuestaDTO> consultarPorTipo(String tipo);
}
