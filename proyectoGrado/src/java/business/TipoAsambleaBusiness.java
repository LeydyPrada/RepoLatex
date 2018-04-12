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
import persistecia.dao.TipoAsambleaDAO;
import persistecia.dto.TipoAsambleaDTO;

/**
 *
 * @author USUARIO
 */
public class TipoAsambleaBusiness {
    
    TipoAsambleaDAO tipoAsambleaDAO = new TipoAsambleaDAO();
    
    /**
     * Metodo que consulta todos los tipos de encuesta registrados en el sistema
     * @return tipoEncuesta
     */
    public List<TipoAsambleaDTO> listarTiposAsamblea(){
        List<TipoAsambleaDTO> tiposAsamblea = new ArrayList<>();
        
        try{            
            tiposAsamblea = tipoAsambleaDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
        return tiposAsamblea;
    }//listarTiposAsamblea
    
    /**
     * Consulta el tipo de encuesta por tipo
     * @param tipo - tipo de encuesta a consultar
     * @return tipoEncuesta - lista de tipoEncuestas que coincidan
     */
    public List<TipoAsambleaDTO> consultarTipoAsamblea(String tipo){
        List<TipoAsambleaDTO> tipoAsamblea = new ArrayList<>();
        
        try{            
            tipoAsamblea = tipoAsambleaDAO.consultarPorTipo(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoAsamblea;
    }//consultarTipoAsamblea
    
    /**
     * Permite crear un tipo de encuesta
     * @param tipoAsamblea 
     */
    public void crearTipoAsamblea(TipoAsambleaDTO tipoAsamblea){
        try{            
            tipoAsambleaDAO.registrar(tipoAsamblea);
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearTipoAsamblea
    
    /**
     * Permite consulta un tipo de encuesta por id
     * @param id - identificador del tipo de encuesta
     * @return  tipoEnc - tipo de Encuesta consultado
     */
    public TipoAsambleaDTO consultarTipoAsamPorId(int id){
        
        TipoAsambleaDTO tipoAsamblea = new TipoAsambleaDTO();
       try{            
            tipoAsamblea = tipoAsambleaDAO.consultarPorId(id);
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoAsamblea;
    }//consultarTipoEncPorId
    
    /**
     * Permite actualizar un tipo de encuesta
     * @param tipo - tipo de encuesta a actualizar
     */
    public void actualizarTipoAsamblea(TipoAsambleaDTO tipo){
       try{            
            tipoAsambleaDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//actualizarTipoAsamblea
    
    /**
     * permite cambiar el estado de un tipo de encuesta
     * @param tipo - tipo de encuesta a cambiar estado
     */
    public void cambiarEstadoTipoEnc(TipoAsambleaDTO tipo){
       try{            
           if(tipo.getActivo()==1)
               tipo.setActivo(0);
           else
               tipo.setActivo(1)
                       ;
            tipoAsambleaDAO.actualizar(tipo);
            
        }catch(Exception ex){
            Logger.getLogger(TipoAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoEnc
    
}
