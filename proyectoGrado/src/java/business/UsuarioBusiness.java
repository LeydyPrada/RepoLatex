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
import persistecia.dao.TipoUsuarioDAO;
import persistecia.dao.UsuarioDAO;
import persistecia.dto.TipoDocumentoDTO;
import persistecia.dto.TipoUsuarioDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author USUARIO
 */
public class UsuarioBusiness {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    TipoUsuarioDAO tipoUsrDAO = new TipoUsuarioDAO();
    TipoDocumentoDAO tipoDocDAO = new TipoDocumentoDAO();
    
    
    /* METODOS PARA USUARIO*/
    
    public List<UsuarioDTO> listarUsuarios(){
        List<UsuarioDTO> usuarios = new ArrayList<>();
        TipoUsuarioDTO tipoUsuario;
        TipoDocumentoDTO tipoDocumento;
                
        try{            
            usuarios = usuarioDAO.consultarTodos();
                       
           for(int i = 0; i < usuarios.size(); i++) {
               tipoUsuario = tipoUsrDAO.consultarPorId(usuarios.get(i).getTipoUusario().getId());
               tipoDocumento = tipoDocDAO.consultarPorId(usuarios.get(i).getTipoDocumento().getId());
               usuarios.get(i).setTipoUusario(tipoUsuario);
               usuarios.get(i).setTipoDocumento(tipoDocumento);
            } 
           
        }catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuarios;
    }//listarUsuarios
    
    public UsuarioDTO consultarUsuarioPorId(String id){
        UsuarioDTO usuario = new UsuarioDTO();
        TipoUsuarioDTO tipoUsuario;
        TipoDocumentoDTO tipoDocumento;
        
        try {
            usuario = usuarioDAO.consultarPorId(id);
            tipoUsuario = tipoUsrDAO.consultarPorId(usuario.getTipoUusario().getId());
            tipoDocumento = tipoDocDAO.consultarPorId(usuario.getTipoDocumento().getId());
            usuario.setTipoUusario(tipoUsuario);
            usuario.setTipoDocumento(tipoDocumento);
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return usuario;
    }//consultarUsuarioPorId
    
    
    public void  crearUsuario (UsuarioDTO usuario){
        
        try {            
            usuarioDAO.registrar(usuario);
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearUsuario
    
    public void actualizarUsuario(UsuarioDTO usuario){
        
        try {
            usuarioDAO.actualizar(usuario);
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarUsuario
    
    public void cambiarEstadoUsuario(UsuarioDTO usuario){
       try{            
           if(usuario.getActivo()==1)
               usuario.setActivo(0);
           else
               usuario.setActivo(1)
                       ;
            usuarioDAO.actualizar(usuario);
            
        }catch(Exception ex){
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoUsuario
    
    public List<UsuarioDTO> consultarUsuarioNombre(String nombre){
         List<UsuarioDTO> usuarios = new ArrayList<>();
         TipoUsuarioDTO tipoUsuario;
         TipoDocumentoDTO tipoDocumento;
        
        try {
            usuarios = usuarioDAO.consultarUsuarioNombre(nombre);
            
            for(int i = 0; i < usuarios.size(); i++) {
               tipoUsuario = tipoUsrDAO.consultarPorId(usuarios.get(i).getTipoUusario().getId());
               tipoDocumento = tipoDocDAO.consultarPorId(usuarios.get(i).getTipoDocumento().getId());
               usuarios.get(i).setTipoUusario(tipoUsuario);
               usuarios.get(i).setTipoDocumento(tipoDocumento);
            } 
            
        } catch (Exception ex) {
            Logger.getLogger(UsuarioBusiness.class.getName()).log(Level.SEVERE, null, ex);            
        }
        return usuarios;
    }//consultarUsuarioNombre
    
}
