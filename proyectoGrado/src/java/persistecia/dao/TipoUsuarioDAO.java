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
import persistecia.dto.TipoUsuarioDTO;

/**
 *
 * @author jnieton
 */
public class TipoUsuarioDAO implements iTipoUsuarioDAO{
    
    private static final String CREAR_SQL = "INSERT INTO tipo_usuario (tipo, activo) VALUES (?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_usuario SET tipo = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_usuario WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_usuario WHERE id = ?";
    private static final String CONSULTAR_TIPO_SQL = "SELECT * FROM tipo_usuario WHERE tipo LIKE ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_usuario";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(TipoUsuarioDTO tipoUsuario) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, tipoUsuario.getTipo());
            ps.setInt(2, tipoUsuario.getActivo());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false; 
    }

    @Override
    public TipoUsuarioDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        TipoUsuarioDTO tipoUsuario = new TipoUsuarioDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoUsuario = new TipoUsuarioDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }  
            return tipoUsuario;
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoUsuario;
    }

    @Override
    public List<TipoUsuarioDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoUsuarioDTO> tipoUsuario = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               tipoUsuario.add(new TipoUsuarioDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoUsuario;
    }

    @Override
    public boolean actualizar(TipoUsuarioDTO tipoUsuario) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, tipoUsuario.getTipo());
            ps.setInt(2, tipoUsuario.getActivo());
            ps.setInt(3, tipoUsuario.getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false; 
    }

    @Override
    public boolean borrar(Integer id) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(BORRAR_SQL);
            ps.setInt(1, id);
            
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }

    @Override
    public List<TipoUsuarioDTO> consultarTipo(String tipo) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoUsuarioDTO> tiposUsuario = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TIPO_SQL); 
            ps.setString(1, "%"+tipo+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
               tiposUsuario.add(new TipoUsuarioDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tiposUsuario;
    }
    
    
    
}
