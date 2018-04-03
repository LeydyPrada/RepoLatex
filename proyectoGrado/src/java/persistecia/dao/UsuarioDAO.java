/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.config.Conexion;
import persistecia.dto.TipoDocumentoDTO;
import persistecia.dto.TipoUsuarioDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author jnieton
 */
public class UsuarioDAO implements iUsuarioDAO{
    
    private static final String CREAR_SQL = "INSERT INTO usuario (id, nombre, apellido, direccion, telefono, genero, email, usuario_login, contraseña, activo, id_tipo_documento, id_tipo_usuario) "
                                             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE usuario SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, genero = ?, email = ?"
                                             + "usuario_login = ?, contraseña = ?, activo = ?, id_tipo_documento = ?, id_tipo_usuario = ?  WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM usuario WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM usuario WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM usuario";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(UsuarioDTO usuario) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, usuario.getId());   
            ps.setString(2, usuario.getNombre()); 
            ps.setString(3, usuario.getApellido());
            ps.setString(4, usuario.getDireccion());
            ps.setString(5, usuario.getTelefono());
            ps.setString(6, usuario.getGenero());
            ps.setString(7, usuario.getEmail());
            ps.setString(8, usuario.getUsuarioLogin());
            ps.setString(9, usuario.getContraseña());
            ps.setInt(10, usuario.getActivo());
            ps.setInt(11, usuario.getTipoDocumento().getId());
            ps.setInt(12, usuario.getTipoUusario().getId());                        
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public UsuarioDTO consultarPorId(String id) {
        PreparedStatement ps;
        ResultSet rs;
        UsuarioDTO usuario = new UsuarioDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setString(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                usuario = new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                                           rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
                                           new TipoDocumentoDTO(rs.getInt(11)), new TipoUsuarioDTO(rs.getInt(12)));
            }  
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return usuario;
    }

    @Override
    public List<UsuarioDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<UsuarioDTO> usuario = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               usuario.add(new UsuarioDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
                                           rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getInt(10),
                                           new TipoDocumentoDTO(rs.getInt(11)), new TipoUsuarioDTO(rs.getInt(12))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return usuario;
    }

    @Override
    public boolean actualizar(UsuarioDTO usuario) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, usuario.getNombre()); 
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getDireccion());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getGenero());
            ps.setString(6, usuario.getEmail());
            ps.setString(7, usuario.getUsuarioLogin());
            ps.setString(8, usuario.getContraseña());
            ps.setInt(10, usuario.getActivo());
            ps.setInt(9, usuario.getTipoDocumento().getId());
            ps.setInt(10, usuario.getTipoUusario().getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false; 
    }

    @Override
    public boolean borrar(String id) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(BORRAR_SQL);
            ps.setString(1, id);
            
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
