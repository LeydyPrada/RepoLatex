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
import persistecia.dto.AsambleaDTO;

/**
 *
 * @author jnieton
 */
public class AsambleaDAO implements iAsambleaDAO{
    
    private static final String CREAR_SQL = "INSERT INTO asamblea (id, id_tipo_asamblea, descripcion, fecha_ejecucion, hora_inicio, hora_fin, id_orden_dia, id_estado_asamblea) "
                                            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE asamblea SET id_tipo_asamblea = ?, descripcion = ?, fecha_ejecucion = ?, hora_inicio = ?, hora_fin = ?, id_orden_dia = ?, id_estado_asamblea = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM asamblea WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM asamblea WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM asamblea";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(AsambleaDTO asamblea) {
        PreparedStatement ps;
        Date date;
        try {  
            date = new Date(asamblea.getFechaEjecucion().getTime());
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, asamblea.getId());   
            ps.setInt(2, asamblea.getIdTipoAsamblea());
            ps.setString(3, asamblea.getDescripcion());
            ps.setDate(4, date);
            ps.setTime(5, asamblea.getHoraInicio());
            ps.setTime(6, asamblea.getHoraFin());
            ps.setInt(7, asamblea.getIdOrdenDia());
            ps.setInt(8, asamblea.getIdEstadoAsamblea());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(AsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public AsambleaDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        AsambleaDTO asamblea = new AsambleaDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                asamblea = new AsambleaDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getTime(6), rs.getInt(7), rs.getInt(8));
            }  
            return asamblea;
        } catch (SQLException ex) {
            Logger.getLogger(AsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return asamblea;
    }

    @Override
    public List<AsambleaDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<AsambleaDTO> asamblea = new ArrayList();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               asamblea.add(new AsambleaDTO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDate(4), rs.getTime(5), rs.getTime(6), rs.getInt(7), rs.getInt(8)));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(AsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return asamblea;
    }

    @Override
    public boolean actualizar(AsambleaDTO asamblea) {
        PreparedStatement ps;
        Date date;
        try {           
            date = new Date(asamblea.getFechaEjecucion().getTime());
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setInt(1, asamblea.getIdTipoAsamblea());
            ps.setString(2, asamblea.getDescripcion());
            ps.setDate(3, date);
            ps.setTime(4, asamblea.getHoraInicio());
            ps.setTime(5, asamblea.getHoraFin());
            ps.setInt(6, asamblea.getIdOrdenDia());
            ps.setInt(7, asamblea.getIdEstadoAsamblea());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(AsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AsambleaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
}
