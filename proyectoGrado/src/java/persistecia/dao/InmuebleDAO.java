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
import persistecia.dto.InmuebleDTO;
import persistecia.dto.TipoInmuebleDTO;
import persistecia.dto.UsuarioDTO;

/**
 *
 * @author jnieton
 */
public class InmuebleDAO implements iInmuebleDAO{
    
    private static final String CREAR_SQL = "INSERT INTO inmueble (id, inmueble, area_total, area_construida, area_ponderar, coeficiente, id_tipo_inmueble, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE inmueble SET inmueble = ?, area_total = ?, area_construida = ?, area_ponderar = ?, coeficiente = ?, id_tipo_inmueble = ?, id_usuario = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM inmueble WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM inmueble WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM inmueble";
    
    private static final Conexion con = Conexion.obtener();

    @Override
    public boolean registrar(InmuebleDTO inmueble) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(CREAR_SQL);
            ps.setInt(1, inmueble.getId());   
            ps.setString(2, inmueble.getInmueble());
            ps.setInt(3, inmueble.getArea_total());
            ps.setInt(4, inmueble.getArea_construida());
            ps.setInt(5, inmueble.getArea_ponderar());
            ps.setInt(6, inmueble.getCoeficiente());
            ps.setInt(7, inmueble.getTipoInmueble().getId());
            ps.setString(8, inmueble.getUsuario().getId());
                                   
            if (ps.executeUpdate() > 0){
                return true;
            }           
        } catch (SQLException ex) {
            Logger.getLogger(InmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }        
        return false;
    }

    @Override
    public InmuebleDTO consultarPorId(Integer id) {
        PreparedStatement ps;
        ResultSet rs;
        InmuebleDTO inmueble = new InmuebleDTO();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            
            while(rs.next()){
                inmueble = new InmuebleDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), new TipoInmuebleDTO(rs.getInt(7)), new UsuarioDTO(rs.getString(8)));
            }  
            return inmueble;
        } catch (SQLException ex) {
            Logger.getLogger(InmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return inmueble;
    }

    @Override
    public List<InmuebleDTO> consultarTodos() {
        PreparedStatement ps;
        ResultSet rs;
        ArrayList<InmuebleDTO> inmueble = new ArrayList<>();
        
        try {           
            ps = con.getConn().prepareStatement(CONSULTAR_TODOS_SQL);            
            rs = ps.executeQuery();
            
            while(rs.next()){
               inmueble.add(new InmuebleDTO(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), new TipoInmuebleDTO(rs.getInt(7)), new UsuarioDTO(rs.getString(8))));
            }            
        } catch (SQLException ex) {
            Logger.getLogger(InmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return inmueble;
    }

    @Override
    public boolean actualizar(InmuebleDTO inmueble) {
        PreparedStatement ps;
        try {            
            ps = con.getConn().prepareStatement(ACTUALIZAR_SQL);
            ps.setString(1, inmueble.getInmueble());
            ps.setInt(2, inmueble.getArea_total());
            ps.setInt(3, inmueble.getArea_construida());
            ps.setInt(4, inmueble.getArea_ponderar());
            ps.setInt(5, inmueble.getCoeficiente());
            ps.setInt(6, inmueble.getTipoInmueble().getId());
            ps.setString(7, inmueble.getUsuario().getId());
                        
            if (ps.executeUpdate() > 0){
                return true;
            }             
        } catch (SQLException ex) {
            Logger.getLogger(InmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InmuebleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            con.cerrar();
        }
        return false;
    }
    
    
    
    
}
