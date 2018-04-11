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
import persistecia.dto.OrdenDiaDTO;
/**
 *
 * @author jnieton
 */
public class OrdenDiaDAO implements iOrdenDiaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO orden_dia (orden, descripcion, activo) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE orden_dia SET orden = ?, descripcion = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM orden_dia WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM orden_dia WHERE id = ?";
    private static final String CONSULTAR_ORDEN_SQL = "SELECT * FROM orden_dia WHERE orden LIKE ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM orden_dia";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(OrdenDiaDTO ordenDia) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, ordenDia.getOrden()); 
            ps.setString(2, ordenDia.getDescripcion());
            ps.setInt(3, ordenDia.getActivo());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public OrdenDiaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        OrdenDiaDTO ordenDia = new OrdenDiaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                ordenDia = new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
            }  
            return ordenDia;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ordenDia;
    }

    @Override
    public List<OrdenDiaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<OrdenDiaDTO> ordenDia = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               ordenDia.add(new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ordenDia;
    }

    @Override
    public boolean actualizar(OrdenDiaDTO ordenDia) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, ordenDia.getOrden());
            ps.setString(2, ordenDia.getDescripcion());
            ps.setInt(3, ordenDia.getActivo());
            ps.setInt(4, ordenDia.getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }

    @Override
    public List<OrdenDiaDTO> consultarPorOrden(String Orden) {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<OrdenDiaDTO> ordenDia = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_ORDEN_SQL);
            ps.setString(1, "%"+Orden+"%");            
            rs = ps.executeQuery();
            
            while(rs.next()){
               ordenDia.add(new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ordenDia;
    }

   

 
    
    
    
}
