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

/**
 *
 * @author jnieton
 */
public class TipoDocumentoDAO implements iTipoDocumentoDAO{
    
    private static final String CREAR_SQL = "INSERT INTO tipo_documento (id, tipo_documento) VALUES (?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_documento SET tipo_documento = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_documento WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_documento WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_documento";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(TipoDocumentoDTO tipoDocumento) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, tipoDocumento.getId());   
            ps.setString(2, tipoDocumento.getTipoDocumento()); 
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false; 
    }

    @Override
    public TipoDocumentoDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        TipoDocumentoDTO tipoDocumento = new TipoDocumentoDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                tipoDocumento = new TipoDocumentoDTO(rs.getInt(1), rs.getString(2));
            }  
            return tipoDocumento;
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoDocumento;
    }

    @Override
    public List<TipoDocumentoDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<TipoDocumentoDTO> tipoDocumento = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               tipoDocumento.add(new TipoDocumentoDTO(rs.getInt(1), rs.getString(2)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return tipoDocumento;
    }

    @Override
    public boolean actualizar(TipoDocumentoDTO tipoDocumento) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, tipoDocumento.getTipoDocumento());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(TipoDocumentoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
