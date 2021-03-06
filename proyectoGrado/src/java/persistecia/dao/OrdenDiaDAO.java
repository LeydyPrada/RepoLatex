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
    private static final String ACTUALIZAR_SQL = "UPDATE orden_dia SET orden = ?, descripcion = ?, activo = ?, aprobado = ?, no_aprobado = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM orden_dia WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM orden_dia WHERE id = ?";
    private static final String CONSULTAR_ORDEN_SQL = "SELECT * FROM orden_dia WHERE orden LIKE ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM orden_dia";
    private static final String VOTACION_ORDEN_DIA = "INSERT INTO voto_orden_dia (id_orden_dia, aprobado, no_aprobado) VALUES(?, ?, ?)";
    private static final String VOTO_ORDEN_DIA_APROB = "SELECT count(*) FROM voto_orden_dia WHERE id_orden_dia = ? AND aprobado = ?";
    private static final String VOTO_ORDEN_DIA_TOTAL = "SELECT count(*) FROM voto_orden_dia WHERE id_orden_dia = ?";
    
    
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
                ordenDia = new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6));
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
               ordenDia.add(new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
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
            ps.setInt(4, ordenDia.getAprobado());
            ps.setInt(5, ordenDia.getNoAprobado());
            ps.setInt(6, ordenDia.getId());            
                        
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
               ordenDia.add(new OrdenDiaDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return ordenDia;
    }

    @Override
    public boolean votarOrdenDia(OrdenDiaDTO ordenDia) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(VOTACION_ORDEN_DIA);
            ps.setInt(1, ordenDia.getId()); 
            ps.setInt(2, ordenDia.getAprobado());
            ps.setInt(3, ordenDia.getNoAprobado());           
                                   
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
    public Integer contarVotoOrden(Integer idOrdenDia) {
        PreparedStatement ps;
        ResultSet rs;
        int totalAprobado = 0;
        
        try {           
            ps = con.getConn().prepareStatement(VOTO_ORDEN_DIA_APROB);
            ps.setInt(1, idOrdenDia);
            ps.setInt(2, 1);
            rs = ps.executeQuery();
            
            while(rs.next()){
              totalAprobado = rs.getInt(1);
            }  
            return totalAprobado;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return totalAprobado;        
    }
    
    @Override
    public Integer totalVotoOrden(Integer idOrdenDia) {
        PreparedStatement ps;
        ResultSet rs;
        int totalVotos = 0;
        
        try {           
            ps = con.getConn().prepareStatement(VOTO_ORDEN_DIA_TOTAL);
            ps.setInt(1, idOrdenDia);            
            rs = ps.executeQuery();
            
            while(rs.next()){
              totalVotos = rs.getInt(1);
            }  
            return totalVotos;
        } catch (SQLException ex) {
            Logger.getLogger(OrdenDiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return totalVotos;        
    }

   

 
    
    
    
}
