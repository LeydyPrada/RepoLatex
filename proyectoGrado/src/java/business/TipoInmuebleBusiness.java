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
import persistecia.dao.TipoInmuebleDAO;
import persistecia.dto.TipoInmuebleDTO;

/**
 *
 * @author USUARIO
 */
public class TipoInmuebleBusiness {
    
     TipoInmuebleDAO tipoInmuebleDAO = new TipoInmuebleDAO();
 
 /* METODOS PARA EL TIPO DE USUARIO*/
    
    public List<TipoInmuebleDTO> listarTipoDeInmuebles(){
        List<TipoInmuebleDTO> tiposInmuebles = new ArrayList<>();
        
        try{            
            tiposInmuebles = tipoInmuebleDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tiposInmuebles;
    }//listarTipoDeInmuebles
    
    public TipoInmuebleDTO consultarTipoInmueblePorId(Integer id){
        TipoInmuebleDTO tipoInmueble = new TipoInmuebleDTO();
        
        try {
            tipoInmueble = tipoInmuebleDAO.consultarPorId(id);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return tipoInmueble;
    }//consultarTipoInmueblePorId
    
    public void  crearTipoInmueble (TipoInmuebleDTO tipoInmueble){
        
        try {            
            tipoInmuebleDAO.registrar(tipoInmueble);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearTipoInmueble
    
    public void actualizarTipoInmueble(TipoInmuebleDTO tipoInmueble){
        
        try {
            tipoInmuebleDAO.actualizar(tipoInmueble);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarTipoInmueble
    
    public void cambiarEstadoTipoInmueble(TipoInmuebleDTO tipoInmueble){
       try{            
           if(tipoInmueble.getActivo()==1)
               tipoInmueble.setActivo(0);
           else
               tipoInmueble.setActivo(1)
                       ;
            tipoInmuebleDAO.actualizar(tipoInmueble);
            
        }catch(Exception ex){
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoInmueble
    
    public List<TipoInmuebleDTO> consultarPorTipoInmueble(String tipo){
         List<TipoInmuebleDTO> tiposInmueble = new ArrayList<>();
        
        try {
            tiposInmueble = tipoInmuebleDAO.consultarPorTipo(tipo);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoInmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return tiposInmueble;
    }//consultarPorTipoInmueble
    
}
