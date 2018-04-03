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
import persistecia.dto.TipoAsambleaDTO;

/**
 *
 * @author jnieton
 */
public class TipoAsambleaDAO implements iTipoAsambleaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO tipo_asamblea (id, tipo, activo) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_asamblea SET tipo = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_asamblea WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_asamblea WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_asamblea";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(TipoAsambleaDTO tipoAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, tipoAsamblea.getId());   
            ps.setString(2, tipoAsamblea.getTipo()); 
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public TipoAsambleaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        TipoAsambleaDTO tipoAsamblea = new TipoAsambleaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoAsamblea = new TipoAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }  
            return tipoAsamblea;
        } catch (SQLException ex) {
            Logger.getLogger(TipoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoAsamblea;
    }

    @Override
    public List<TipoAsambleaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoAsambleaDTO> tiposAsamblea = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               tiposAsamblea.add(new TipoAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tiposAsamblea;
    }

    @Override
    public boolean actualizar(TipoAsambleaDTO tipoAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, tipoAsamblea.getTipo());
            ps.setInt(2, tipoAsamblea.getActivo());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(TipoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
