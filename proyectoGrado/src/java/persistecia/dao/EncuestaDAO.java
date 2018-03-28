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
import persistecia.dto.EncuestaDTO;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author jnieton
 */
public class EncuestaDAO implements iEncuestaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO encuesta (id, descripcion, activo, id_tipo_encuesta) VALUES (?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE encuesta SET descripcion = ?, activo = ?, id_tipo_encuesta = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM encuesta WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM encuesta WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM encuesta";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(EncuestaDTO encuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, encuesta.getId());   
            ps.setString(2, encuesta.getDescripcion()); 
            ps.setInt(3, encuesta.getActivo()); 
            ps.setInt(4, encuesta.getTipoEncuesta().getId());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public EncuestaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        EncuestaDTO encuesta = new EncuestaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                encuesta = new EncuestaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), new TipoEncuestaDTO((Integer)rs.getObject(4)));
            }  
            return encuesta;
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return encuesta;
    }

    @Override
    public List<EncuestaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<EncuestaDTO> encuesta = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               encuesta.add(new EncuestaDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), new TipoEncuestaDTO((Integer)rs.getObject(4))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return encuesta;
    }

    @Override
    public boolean actualizar(EncuestaDTO encuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, encuesta.getDescripcion());
            ps.setInt(2, encuesta.getActivo());
            ps.setInt(3, encuesta.getTipoEncuesta().getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EncuestaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
