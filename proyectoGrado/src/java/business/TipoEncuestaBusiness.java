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
import persistecia.dao.TipoEncuestaDAO;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author USUARIO
 */
public class TipoEncuestaBusiness {
    
    TipoEncuestaDAO tipoEncDAO = new TipoEncuestaDAO();
    
    /**
     * Metodo que consulta todos los tipos de encuesta registrados en el sistema
     * @return tipoEncuesta
     */
    public List<TipoEncuestaDTO> listarTipoEncuestas(){
        List<TipoEncuestaDTO> tipoEncuesta = new ArrayList<>();
        
        try{            
            tipoEncuesta = tipoEncDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
        return tipoEncuesta;
    }//listarTipoEncuestas
    
    /**
     * Consulta el tipo de encuesta por tipo
     * @param tipo - tipo de encuesta a consultar
     * @return tipoEncuesta - lista de tipoEncuestas que coincidan
     */
    public List<TipoEncuestaDTO> consultarTipoEncuesta(String tipo){
        List<TipoEncuestaDTO> tipoEncuesta = new ArrayList<>();
        
        try{            
            tipoEncuesta = tipoEncDAO.consultarPorTipo(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoEncuesta;
    }//consultarTipoEncuesta
    
    /**
     * Permite crear un tipo de encuesta
     * @param tipoEnc 
     */
    public void crearTipoEncuesta(TipoEncuestaDTO tipoEnc){
        try{            
            tipoEncDAO.registrar(tipoEnc);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearTipoEncuesta
    
    /**
     * Permite consulta un tipo de encuesta por id
     * @param id - identificador del tipo de encuesta
     * @return  tipoEnc - tipo de Encuesta consultado
     */
    public TipoEncuestaDTO consultarTipoEncPorId(int id){
        
        TipoEncuestaDTO tipoEnc = new TipoEncuestaDTO();
       try{            
            tipoEnc = tipoEncDAO.consultarPorId(id);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoEnc;
    }//consultarTipoEncPorId
    
    /**
     * Permite actualizar un tipo de encuesta
     * @param tipo - tipo de encuesta a actualizar
     */
    public void actualizarTipoEncuesta(TipoEncuestaDTO tipo){
       try{            
            tipoEncDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//actualizarTipoEncuesta
    
    /**
     * permite cambiar el estado de un tipo de encuesta
     * @param tipo - tipo de encuesta a cambiar estado
     */
    public void cambiarEstadoTipoEnc(TipoEncuestaDTO tipo){
       try{            
           if(tipo.getActivo()==1)
               tipo.setActivo(0);
           else
               tipo.setActivo(1)
                       ;
            tipoEncDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoDocumentoBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoEnc
    
}
