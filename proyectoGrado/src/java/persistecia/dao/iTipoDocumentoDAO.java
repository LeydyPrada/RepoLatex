/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.util.List;
import persistecia.dto.TipoDocumentoDTO;

/**
 *
 * @author jnieton
 */
public interface iTipoDocumentoDAO {
    
        public boolean registrar(TipoDocumentoDTO tipoDocumento);
        public TipoDocumentoDTO consultarPorId(Integer id);
	public List<TipoDocumentoDTO> consultarTodos();
	public boolean actualizar(TipoDocumentoDTO tipoDocumento);
	public boolean borrar(Integer id);
        public List<TipoDocumentoDTO> consultarPorCodigo(String codigo);
    
}
