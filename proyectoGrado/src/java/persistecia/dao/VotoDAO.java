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
import persistecia.dto.EncuestaDTO;
import persistecia.dto.PreguntasDTO;
import persistecia.dto.RespuestasDTO;
import persistecia.dto.VotoDTO;

/**
 *
 * @author jnieton
 */
public class VotoDAO implements iVotoDAO{
    
    private static final String CREAR_SQL = "INSERT INTO voto (id, id_encuesta, id_pregunta, id_asamblea, id_respuesta, inmueble) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE voto SET id_encuesta = ?, id_pregunta = ?, id_asamblea = ?, id_respuesta = ?, inmueble = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM voto WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM voto WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM voto";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(VotoDTO voto) {
        PreparedStatement ps;
        try {  
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, voto.getId());   
            ps.setInt(2, voto.getEncuesta().getId());
            ps.setInt(3, voto.getPreguntas().getId());
            ps.setInt(4, voto.getAsamblea().getId());
            ps.setInt(5, voto.getRespuestas().getId());
            ps.setString(6, voto.getInmueble());
                                               
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public VotoDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        VotoDTO voto = new VotoDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                voto = new VotoDTO(rs.getInt(1), new EncuestaDTO(rs.getInt(2)), new PreguntasDTO(rs.getInt(3)), new AsambleaDTO(rs.getInt(4)), new RespuestasDTO(rs.getInt(5)), rs.getString(6));
            }  
            return voto;
        } catch (SQLException ex) {
            Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return voto;
    }

    @Override
    public List<VotoDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<VotoDTO> voto = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               voto.add(new VotoDTO(rs.getInt(1), new EncuestaDTO(rs.getInt(2)), new PreguntasDTO(rs.getInt(3)), new AsambleaDTO(rs.getInt(4)), new RespuestasDTO(rs.getInt(5)), rs.getString(6)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return voto;
    }

    @Override
    public boolean actualizar(VotoDTO voto) {
        PreparedStatement ps;
        try {           
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setInt(1, voto.getId());   
            ps.setInt(2, voto.getEncuesta().getId());
            ps.setInt(3, voto.getPreguntas().getId());
            ps.setInt(4, voto.getAsamblea().getId());
            ps.setInt(5, voto.getRespuestas().getId());
            ps.setString(6, voto.getInmueble());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(VotoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    
}
