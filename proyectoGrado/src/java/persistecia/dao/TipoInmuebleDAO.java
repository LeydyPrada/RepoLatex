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
import persistecia.dto.TipoInmuebleDTO;

/**
 *
 * @author jnieton
 */
public class TipoInmuebleDAO implements iTipoInmuebleDAO{
    
    private static final String CREAR_SQL = "INSERT INTO tipo_inmueble (tipo_inmueble, activo) VALUES (?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_inmueble SET tipo_inmueble = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_inmueble WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_inmueble WHERE id = ?";
    private static final String CONSULTAR_TIPO_SQL = "SELECT * FROM tipo_inmueble WHERE tipo_inmueble LIKE ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_inmueble";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(TipoInmuebleDTO tipoInmueble) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, tipoInmueble.getTipoInmueble());
            ps.setInt(2, tipoInmueble.getActivo());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoInmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public TipoInmuebleDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        TipoInmuebleDTO tipoInmueble = new TipoInmuebleDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoInmueble = new TipoInmuebleDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }  
            return tipoInmueble;
        } catch (SQLException ex) {
            Logger.getLogger(TipoInmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoInmueble;  
    }

    @Override
    public List<TipoInmuebleDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoInmuebleDTO> tipoInmueble = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               tipoInmueble.add(new TipoInmuebleDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoInmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoInmueble;
    }

    @Override
    public boolean actualizar(TipoInmuebleDTO tipoInmueble) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, tipoInmueble.getTipoInmueble());
            ps.setInt(2, tipoInmueble.getActivo());
            ps.setInt(3, tipoInmueble.getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(TipoInmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoInmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }

    @Override
    public List<TipoInmuebleDTO> consultarPorTipo(String tipo) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoInmuebleDTO> tiposInmueble = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TIPO_SQL); 
            ps.setString(1, "%"+tipo+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
               tiposInmueble.add(new TipoInmuebleDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoUsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tiposInmueble;
    }
    
    
}
