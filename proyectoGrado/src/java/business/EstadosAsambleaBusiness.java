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
import persistecia.dao.EstadoAsambleaDAO;
import persistecia.dto.EstadoAsambleaDTO;

/**
 *
 * @author USUARIO
 */
public class EstadosAsambleaBusiness {
    
    EstadoAsambleaDAO estadoAsambleaDAO = new EstadoAsambleaDAO();
    
    /**
     * Metodo que consulta todos los tipos de encuesta registrados en el sistema
     * @return tipoEncuesta
     */
    public List<EstadoAsambleaDTO> listarEstadosAsamblea(){
        List<EstadoAsambleaDTO> estadosAsamblea = new ArrayList<>();
        
        try{            
            estadosAsamblea = estadoAsambleaDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        
        return estadosAsamblea;
    }//listarEstadosAsamblea
    
    /**
     * Consulta el tipo de encuesta por tipo
     * @param desc - tipo de encuesta a consultar
     * @return tipoEncuesta - lista de tipoEncuestas que coincidan
     */
    public List<EstadoAsambleaDTO> consultarEstadosAsamblea(String desc){
        List<EstadoAsambleaDTO> estadosAsamblea = new ArrayList<>();
        
        try{            
            estadosAsamblea = estadoAsambleaDAO.consultarPorDescrip(desc);
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return estadosAsamblea;
    }//consultarEstadosAsamblea
    
    /**
     * Permite crear un tipo de encuesta
     * @param estadoAsamblea 
     */
    public void crearEstadoAsamblea(EstadoAsambleaDTO estadoAsamblea){
        try{            
            estadoAsambleaDAO.registrar(estadoAsamblea);
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearEstadoAsamblea
    
    /**
     * Permite consulta un tipo de encuesta por id
     * @param id - identificador del tipo de encuesta
     * @return  tipoEnc - tipo de Encuesta consultado
     */
    public EstadoAsambleaDTO consultarEstadoAsamPorId(int id){
        
        EstadoAsambleaDTO estadoAsamblea = new EstadoAsambleaDTO();
       try{            
            estadoAsamblea = estadoAsambleaDAO.consultarPorId(id);
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estadoAsamblea;
    }//consultarEstadoAsamPorId
    
    /**
     * Permite actualizar un tipo de encuesta
     * @param estadoAsam - tipo de encuesta a actualizar
     */
    public void actualizarEstadoAsamblea(EstadoAsambleaDTO estadoAsam){
       try{            
            estadoAsambleaDAO.actualizar(estadoAsam);
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//actualizarTipoAsamblea
    
    /**
     * permite cambiar el estado de un tipo de encuesta
     * @param tipo - tipo de encuesta a cambiar estado
     */
    public void cambiarEstadoEstadoAsam(EstadoAsambleaDTO estAsamblea){
       try{            
           if(estAsamblea.getActivo()==1)
               estAsamblea.setActivo(0);
           else
               estAsamblea.setActivo(1)
                       ;
            estadoAsambleaDAO.actualizar(estAsamblea);
            
        }catch(Exception ex){
            Logger.getLogger(EstadosAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoEnc
    
}
