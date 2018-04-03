/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.config.Conexion;
import persistecia.dto.UsuarioDTO;
import persistecia.dto.HistoricoVotacionDTO;

/**
 *
 * @author jnieton
 */
public class HistoricoVotacionDAO implements iHistoricoVotacionDAO{
    
    private static final String CREAR_SQL = "INSERT INTO historico_votacion (id, id_usuario, voto, fecha) VALUES (?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE historico_votacion SET id_usuario = ?, voto = ?, fecha = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM historico_votacion WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM historico_votacion WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM historico_votacion";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(HistoricoVotacionDTO histVotacion) {
        PreparedStatement ps;
        Date date;
        try {          
            date = new Date(histVotacion.getFecha().getTime());
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, histVotacion.getId());   
            ps.setString(2, histVotacion.getUsuario().getId());
            ps.setInt(3, histVotacion.getVoto());
            ps.setDate(4, date);
                                               
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public HistoricoVotacionDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        HistoricoVotacionDTO histVotacion = new HistoricoVotacionDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                histVotacion = new HistoricoVotacionDTO(rs.getInt(1), new UsuarioDTO(rs.getString(2)), rs.getInt(3), rs.getDate(4));
            }  
            return histVotacion;
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return histVotacion;
    }

    @Override
    public List<HistoricoVotacionDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<HistoricoVotacionDTO> histVotacion = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               histVotacion.add(new HistoricoVotacionDTO(rs.getInt(1), new UsuarioDTO(rs.getString(2)), rs.getInt(3), rs.getDate(4)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return histVotacion;
    }

    @Override
    public boolean actualizar(HistoricoVotacionDTO histVotacion) {
        PreparedStatement ps;
        Date date;
        try {     
            date = new Date(histVotacion.getFecha().getTime());
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);        
            ps.setString(1, histVotacion.getUsuario().getId());
            ps.setInt(2, histVotacion.getVoto());
            ps.setDate(3, date);
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HistoricoVotacionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    
    
    
}
