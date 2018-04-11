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
import persistecia.dao.InmuebleDAO;
import persistecia.dao.TipoInmuebleDAO;
import persistecia.dao.UsuarioDAO;
import persistecia.dto.InmuebleDTO;
import persistecia.dto.TipoInmuebleDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
public class InmuebleBusiness {
    
     InmuebleDAO inmuebleDAO = new InmuebleDAO();
     TipoInmuebleDAO tipoInmuebleDAO = new TipoInmuebleDAO();
     UsuarioDAO usuarioDAO = new UsuarioDAO();
     
 
 /* METODOS PARA EL TIPO DE USUARIO*/
    
    public List<InmuebleDTO> listarInmuebles(){
        List<InmuebleDTO> inmuebles = new ArrayList<>();
        TipoInmuebleDTO tipoInmueble;
        UsuarioDTO usuario;
        
        try{            
            inmuebles = inmuebleDAO.consultarTodos();
            
            for(int i = 0; i < inmuebles.size(); i++) {
                tipoInmueble = tipoInmuebleDAO.consultarPorId(inmuebles.get(i).getTipoInmueble().getId());
                usuario = usuarioDAO.consultarPorId(inmuebles.get(i).getUsuario().getId());
                inmuebles.get(i).setTipoInmueble(tipoInmueble);                
                inmuebles.get(i).setUsuario(usuario);
            }
            
        }catch(Exception ex){
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return inmuebles;
    }//listarInmuebles
    
    public InmuebleDTO consultarInmueblePorId(Integer id){
        InmuebleDTO inmueble = new InmuebleDTO();
        UsuarioDTO usuario;
        TipoInmuebleDTO tipoInmueble;
                
        try {
            inmueble = inmuebleDAO.consultarPorId(id);
            tipoInmueble = tipoInmuebleDAO.consultarPorId(inmueble.getTipoInmueble().getId());
            inmueble.setTipoInmueble(tipoInmueble);  
            
            usuario = usuarioDAO.consultarPorId(inmueble.getUsuario().getId());
            inmueble.setUsuario(usuario);
            
        } catch (Exception ex) {
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return inmueble;
    }//consultarInmueblePorId
    
    public void  crearInmueble (InmuebleDTO inmueble){
        
        try {            
            inmuebleDAO.registrar(inmueble);
            
        } catch (Exception ex) {
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearInmueble
    
    public void actualizarInmueble(InmuebleDTO inmueble){
        
        try {
            inmuebleDAO.actualizar(inmueble);
            
        } catch (Exception ex) {
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarInmueble
    
    public void cambiarEstadoInmueble(InmuebleDTO inmueble){
       try{            
           if(inmueble.getActivo()==1)
               inmueble.setActivo(0);
           else
               inmueble.setActivo(1)
                       ;
            inmuebleDAO.actualizar(inmueble);
            
        }catch(Exception ex){
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoInmueble
    
    public List<InmuebleDTO> consultarPorInmueble(String inmueble){
         List<InmuebleDTO> inmuebles = new ArrayList<>();
         TipoInmuebleDTO tipoInmueble;
         UsuarioDTO usuario;
        
        try {
            inmuebles = inmuebleDAO.consultarPorInmueble(inmueble);
            
             for(int i = 0; i < inmuebles.size(); i++) {
                tipoInmueble = tipoInmuebleDAO.consultarPorId(inmuebles.get(i).getTipoInmueble().getId());
                usuario = usuarioDAO.consultarPorId(inmuebles.get(i).getUsuario().getId());
                inmuebles.get(i).setTipoInmueble(tipoInmueble);
                inmuebles.get(i).setUsuario(usuario);
            }
            
        } catch (Exception ex) {
            Logger.getLogger(InmuebleBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return inmuebles;
    }//consultarPorInmueble
    
}
