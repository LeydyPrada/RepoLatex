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
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author jnieton
 */
public class TipoEncuestaDAO implements iTipoEncuestaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO tipo_encuesta (tipo, activo) VALUES (?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_encuesta SET tipo = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_encuesta WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_encuesta WHERE id = ?";
    private static final String CONSULTAR_TIPO_SQL = "SELECT * FROM tipo_encuesta WHERE tipo like ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_encuesta";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(TipoEncuestaDTO tipoEncuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, tipoEncuesta.getTipo());
            ps.setInt(2, tipoEncuesta.getActivo());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false; 
    }

    @Override
    public TipoEncuestaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        TipoEncuestaDTO tipoEncuesta = new TipoEncuestaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoEncuesta = new TipoEncuestaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }  
            return tipoEncuesta;
        } catch (SQLException ex) {
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoEncuesta;
    }

    @Override
    public List<TipoEncuestaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoEncuestaDTO> tipoEncuesta = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               tipoEncuesta.add(new TipoEncuestaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoEncuesta;
    }

    @Override
    public boolean actualizar(TipoEncuestaDTO tipoEncuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setInt(1, tipoEncuesta.getId());
            ps.setString(2, tipoEncuesta.getTipo());
            ps.setInt(3, tipoEncuesta.getActivo());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    @Override
    public List<TipoEncuestaDTO> consultarPorTipo(String tipo) {
        PreparedStatement ps;
        ResultSet rs;
        List<TipoEncuestaDTO> tipoEncuesta = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TIPO_SQL);
            ps.setString(1, "%"+tipo+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoEncuesta.add(new TipoEncuestaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }  
            return tipoEncuesta;
        } catch (SQLException ex) {
            Logger.getLogger(TipoEncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoEncuesta;
    }
    
}
