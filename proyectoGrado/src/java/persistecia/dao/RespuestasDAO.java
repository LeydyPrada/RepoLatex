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
import persistecia.dto.PreguntasDTO;
import persistecia.dto.RespuestasDTO;

/**
 *
 * @author jnieton
 */
public class RespuestasDAO implements iRespuestasDAO{
    
    private static final String CREAR_SQL = "INSERT INTO respuestas (id, descripcion, id_pregunta) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE respuestas SET descripcion = ?, id_pregunta = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM respuestas WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM respuestas WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM respuestas";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(RespuestasDTO respuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, respuesta.getId());   
            ps.setString(2, respuesta.getDescripcion()); 
            ps.setInt(3, respuesta.getPregunta().getId());            
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(RespuestasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }  
        return false;
    }

    @Override
    public RespuestasDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        RespuestasDTO respuesta = new RespuestasDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                respuesta = new RespuestasDTO(rs.getInt(1), rs.getString(2), new PreguntasDTO(rs.getInt(4)));
            }  
            return respuesta;
        } catch (SQLException ex) {
            Logger.getLogger(RespuestasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return respuesta;
    }

    @Override
    public List<RespuestasDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<RespuestasDTO> respuestas = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               respuestas.add(new RespuestasDTO(rs.getInt(1), rs.getString(2), new PreguntasDTO(rs.getInt(4))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(RespuestasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return respuestas;
    }

    @Override
    public boolean actualizar(RespuestasDTO respuesta) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, respuesta.getDescripcion());
            ps.setInt(2, respuesta.getPregunta().getId());
                                    
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(RespuestasDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RespuestasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    
    
    
}
