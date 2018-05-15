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
import persistecia.dto.RegistroAsambleaDTO;

/**
 *
 * @author jnieton
 */
public class RegistroAsambleaDAO implements iRegistroAsambleaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO registro_asamblea (inmueble, codigo, verificado, id_asamblea) VALUES (?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE registro_asamblea SET inmueble = ?, codigo = ?, verificado=? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM registro_asamblea WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM registro_asamblea WHERE id = ?";
    private static final String CONSULTAR_INMUEBLE_SQL = "SELECT * FROM registro_asamblea WHERE inmueble LIKE ?";
    private static final String CONSUL_INMUEBLE_CODIGO = "SELECT * FROM registro_asamblea WHERE inmueble = ? AND codigo = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM registro_asamblea";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(RegistroAsambleaDTO registroAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setString(1, registroAsamblea.getInmueble());   
            ps.setInt(2, registroAsamblea.getCodigo());
            ps.setInt(3, registroAsamblea.getVerificado());
            ps.setInt(4, registroAsamblea.getId_asamblea());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public RegistroAsambleaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        RegistroAsambleaDTO registroAsamblea = new RegistroAsambleaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                registroAsamblea = new RegistroAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }  
            return registroAsamblea;
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return registroAsamblea;
    }

    @Override
    public List<RegistroAsambleaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<RegistroAsambleaDTO> registrosAsamblea = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               registrosAsamblea.add(new RegistroAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return registrosAsamblea;
    }

    @Override
    public boolean actualizar(RegistroAsambleaDTO registroAsamblea) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, registroAsamblea.getInmueble());
            ps.setInt(2, registroAsamblea.getCodigo());
            ps.setInt(3, registroAsamblea.getVerificado());
            ps.setInt(4, registroAsamblea.getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }

    @Override
    public List<RegistroAsambleaDTO> consultarPorInmueble(String inmueble) {
        PreparedStatement ps;
        ResultSet rs;
        List<RegistroAsambleaDTO> registroAsamblea = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_INMUEBLE_SQL);
            ps.setString(1, "%"+inmueble+"%");
            rs = ps.executeQuery();
            
            while(rs.next()){
                registroAsamblea.add(new RegistroAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5)));
            }  
         } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return registroAsamblea;
    }

    @Override
    public RegistroAsambleaDTO consultarPorInmuebleCodigo(int codigo, String inmueble) {
        PreparedStatement ps;
        ResultSet rs;
        RegistroAsambleaDTO registroAsamblea = new RegistroAsambleaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSUL_INMUEBLE_CODIGO);            
            ps.setString(1, inmueble);
            ps.setInt(2, codigo);
            rs = ps.executeQuery();
            
            while(rs.next()){
                registroAsamblea = new RegistroAsambleaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5));
            }  
         } catch (SQLException ex) {
            Logger.getLogger(RegistroAsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return registroAsamblea;
    }

    

      
    
}
