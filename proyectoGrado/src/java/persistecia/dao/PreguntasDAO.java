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
import persistecia.dto.AsambleaDTO;
import persistecia.dto.PreguntasDTO;

/**
 *
 * @author jnieton
 */
public class PreguntasDAO implements iPreguntasDAO{
    
    private static final String CREAR_SQL = "INSERT INTO preguntas (descripcion, activo, id_asamblea) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE preguntas SET descripcion = ?, activo = ?, id_asamblea = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM preguntas WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM preguntas WHERE id = ?";
    private static final String CONSULTAR_DESC_SQL = "SELECT * FROM preguntas WHERE descripcion LIKE ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM preguntas";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(PreguntasDTO pregunta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);  
            ps.setString(1, pregunta.getDescripcion()); 
            ps.setInt(2, pregunta.getActivo()); 
            ps.setInt(3, pregunta.getAsamblea().getId());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public PreguntasDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        PreguntasDTO preguntas = new PreguntasDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                preguntas = new PreguntasDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), new AsambleaDTO(rs.getInt(4)));
            }  
            return preguntas;
        } catch (SQLException ex) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return preguntas;
    }

    @Override
    public List<PreguntasDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<PreguntasDTO> preguntas = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               preguntas.add(new PreguntasDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), new AsambleaDTO(rs.getInt(4))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return preguntas;
    }

    @Override
    public boolean actualizar(PreguntasDTO pregunta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, pregunta.getDescripcion());
            ps.setInt(2, pregunta.getActivo());
            ps.setInt(3, pregunta.getAsamblea().getId());
            ps.setInt(4, pregunta.getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    @Override
    public List<PreguntasDTO> consultarPorDesc(String desc){
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<PreguntasDTO> preguntas = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_DESC_SQL);  
            ps.setString(1, '%'+desc+'%');
            rs = ps.executeQuery();
            
            while(rs.next()){
               preguntas.add(new PreguntasDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), new AsambleaDTO(rs.getInt(4))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(PreguntasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return preguntas;
    }
    
}
