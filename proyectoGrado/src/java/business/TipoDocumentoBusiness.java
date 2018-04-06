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
public class TipoDocumentoBusiness {
    
    /* METODOS PARA EL TIPO DE DOCUMENTO */
    
    TipoDocumentoDAO tipoDocDAO = new TipoDocumentoDAO();
    
    public List<TipoDocumentoDTO> listarTipoDeDocumentos(){
        List<TipoDocumentoDTO> tipoDocumento = new ArrayList<>();
        
        try{            
            tipoDocumento = tipoDocDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoDocumento;
    }//listarTipoDeDocumentos
    
    public List<TipoDocumentoDTO> consultarTipoDoc(String codigo){
        List<TipoDocumentoDTO> tipoDocumento = new ArrayList<>();
        
        try{            
            tipoDocumento = tipoDocDAO.consultarPorCodigo(codigo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoDocumento;
    }
    
    public void crearTipoDocumento(TipoDocumentoDTO tipoDoc){
        try{            
            tipoDocDAO.registrar(tipoDoc);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearTipoDocumento
    
    public TipoDocumentoDTO consultarTipoDocPorId(int id){
        
        TipoDocumentoDTO tipoDoc = new TipoDocumentoDTO();
       try{            
            tipoDoc = tipoDocDAO.consultarPorId(id);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoDoc;
    }//consultarTipoDocPorId
    
    public void actualizarTipoDocumento(TipoDocumentoDTO tipo){
       try{            
            tipoDocDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//actualizarTipoDocumento
    
    public void cambiarEstadoTipoDoc(TipoDocumentoDTO tipo){
       try{            
           if(tipo.getActivo()==1)
               tipo.setActivo(0);
           else
               tipo.setActivo(1)
                       ;
            tipoDocDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoDoc
    
}
