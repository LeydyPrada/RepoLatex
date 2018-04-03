/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.dao.TipoDocumentoDAO;
import persistecia.dto.TipoDocumentoDTO;

/**
 *
 * @author USUARIO
 */
public class ConfiguracionBusiness {
    
    TipoDocumentoDAO tipoDocDAO = new TipoDocumentoDAO();
    
    public List<TipoDocumentoDTO> listarTipoDeDocumentos(){
        List<TipoDocumentoDTO> tipoDocumento = new ArrayList<>();
        
        try{
            
            tipoDocumento = tipoDocDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(ConfiguracionBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoDocumento;
    }//listarTipoDeDocumentos
    
}
