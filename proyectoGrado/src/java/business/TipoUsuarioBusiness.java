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
import persistecia.dao.TipoUsuarioDAO;
import persistecia.dto.TipoUsuarioDTO;

/**
 *
 * @author USUARIO
 */
public class TipoUsuarioBusiness {
    
     TipoUsuarioDAO tipoUsrDAO = new TipoUsuarioDAO();
 
 /* METODOS PARA EL TIPO DE USUARIO*/
    
    public List<TipoUsuarioDTO> listarTipoDeUsuarios(){
        List<TipoUsuarioDTO> tipoUsuarios = new ArrayList<>();
        
        try{            
            tipoUsuarios = tipoUsrDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return tipoUsuarios;
    }//listarTipoDeUsuarios
    
    public TipoUsuarioDTO consultarTipoUsrPorId(Integer id){
        TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
        
        try {
            tipoUsuario = tipoUsrDAO.consultarPorId(id);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return tipoUsuario;
    }//consultarTipoUsrPorId
    
    public void  crearTipoUsuario (TipoUsuarioDTO tipoUsr){
        
        try {            
            tipoUsrDAO.registrar(tipoUsr);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearTipoUsuario
    
    public void actualizarTipoUsuario(TipoUsuarioDTO tipoUsuario){
        
        try {
            tipoUsrDAO.actualizar(tipoUsuario);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarTipoUsuario
    
    public void cambiarEstadoTipoUsr(TipoUsuarioDTO tipoUsr){
       try{            
           if(tipoUsr.getActivo()==1)
               tipoUsr.setActivo(0);
           else
               tipoUsr.setActivo(1)
                       ;
            tipoUsrDAO.actualizar(tipoUsr);
            
        }catch(Exception ex){
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoTipoUsr
    
    public List<TipoUsuarioDTO> consultarTipoUsrPorTipo(String tipo){
         List<TipoUsuarioDTO> tiposUsuario = new ArrayList<>();
        
        try {
            tiposUsuario = tipoUsrDAO.consultarTipo(tipo);
            
        } catch (Exception ex) {
            Logger.getLogger(TipoUsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return tiposUsuario;
    }//consultarTipoUsrPorTipo
    
}
