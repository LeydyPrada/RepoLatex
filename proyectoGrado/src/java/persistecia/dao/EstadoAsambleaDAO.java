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
import persistecia.dto.EstadoAsambleaDTO;

/**
 *
 * @author jnieton
 */
public class EstadoAsambleaDAO implements iEstadoAsambleaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO estados_asamblea (id, descripcion, activo) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE estados_asamblea SET descripcion = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM estados_asamblea WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM estados_asamblea WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM estados_asamblea";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(EstadoAsambleaDTO estadoAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, estadoAsamblea.getId());   
            ps.setString(2, estadoAsamblea.getDescripcion());
            ps.setInt(3, estadoAsamblea.getActivo());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(EstadoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public EstadoAsambleaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        EstadoAsambleaDTO estadoAsamblea = new EstadoAsambleaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                estadoAsamblea = new EstadoAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3));
            }  
            return estadoAsamblea;
        } catch (SQLException ex) {
            Logger.getLogger(EstadoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return estadoAsamblea;
    }

    @Override
    public List<EstadoAsambleaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<EstadoAsambleaDTO> estadoAsamblea = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               estadoAsamblea.add(new EstadoAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(EstadoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return estadoAsamblea;
    }

    @Override
    public boolean actualizar(EstadoAsambleaDTO estadoAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, estadoAsamblea.getDescripcion());
            ps.setInt(2, estadoAsamblea.getActivo());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(EstadoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EstadoAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
