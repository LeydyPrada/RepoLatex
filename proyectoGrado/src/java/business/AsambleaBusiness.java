/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.dao.AsambleaDAO;
import persistecia.dao.EstadoAsambleaDAO;
import persistecia.dao.OrdenDiaDAO;
import persistecia.dao.TipoAsambleaDAO;
import persistecia.dto.AsambleaDTO;
import persistecia.dto.EstadoAsambleaDTO;
import persistecia.dto.OrdenDiaDTO;
import persistecia.dto.TipoAsambleaDTO;

/**
 *
 * @author USUARIO
 */
public class AsambleaBusiness {

    AsambleaDAO asambleaDAO = new AsambleaDAO();
    TipoAsambleaDAO tipoAsamDAO = new TipoAsambleaDAO();
    OrdenDiaDAO ordenDAO = new OrdenDiaDAO();
    EstadoAsambleaDAO estadoDAO = new EstadoAsambleaDAO();

    /**
     * Consulta las asambleas
     *
     * @return lista de asambleas
     */
    public List<AsambleaDTO> listarAsambleas() {
        List<AsambleaDTO> asambleas = new ArrayList<>();
        try {
            asambleas = asambleaDAO.consultarTodos();
            for (int i = 0; i < asambleas.size(); i++) {
                TipoAsambleaDTO tipo = tipoAsamDAO.consultarPorId(asambleas.get(i).getIdTipoAsamblea().getId());
                asambleas.get(i).setIdTipoAsamblea(tipo);

                OrdenDiaDTO orden = ordenDAO.consultarPorId(asambleas.get(i).getIdOrdenDia().getId());
                asambleas.get(i).setIdOrdenDia(orden);

                EstadoAsambleaDTO estado = estadoDAO.consultarPorId(asambleas.get(i).getIdEstadoAsamblea().getId());
                asambleas.get(i).setIdEstadoAsamblea(estado);
            }
        } catch (Exception ex) {
            Logger.getLogger(AsambleaBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return asambleas;

    }//listarAsambleas

    /**
     * Consulta las asambleas por descipcion
     *
     * @param desc - descripción a consultar
     * @return lista de asambleas
     */
    public List<AsambleaDTO> consultarPorDesc(String desc) {
        List<AsambleaDTO> asambleas = new ArrayList<>();
        try {
            asambleas = asambleaDAO.consultarPorDesc(desc);
            for (int i = 0; i < asambleas.size(); i++) {
                TipoAsambleaDTO tipo = tipoAsamDAO.consultarPorId(asambleas.get(i).getIdTipoAsamblea().getId());
                asambleas.get(i).setIdTipoAsamblea(tipo);

                OrdenDiaDTO orden = ordenDAO.consultarPorId(asambleas.get(i).getIdOrdenDia().getId());
                asambleas.get(i).setIdOrdenDia(orden);

                EstadoAsambleaDTO estado = estadoDAO.consultarPorId(asambleas.get(i).getIdEstadoAsamblea().getId());
                asambleas.get(i).setIdEstadoAsamblea(estado);
            }
        } catch (Exception ex) {
            Logger.getLogger(AsambleaBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
        return asambleas;

    }//consultarPorDesc

    /**
     * Premite la creación de la asamblea
     * @param asamblea - asamblea a crear
     */
    public void crearAsamblea(AsambleaDTO asamblea) {
        try {
            asambleaDAO.registrar(asamblea);

        } catch (Exception ex) {
            Logger.getLogger(AsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearAsamblea    
    
    /**
     * Consultar asamblea por Id
     * @param id - id de asamblea a consultar
     * @return asamblea que coincide con el dato
     */
    public AsambleaDTO consultarAsambleaPorId(int id) {

        AsambleaDTO asamblea = new AsambleaDTO();
        try {
            asamblea = asambleaDAO.consultarPorId(id);

        } catch (Exception ex) {
            Logger.getLogger(AsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asamblea;
    }//consultarAsambleaPorId
    
    /**
     * Permite actualizar una asamblea
     * @param asamblea - asamblea con los campos a actualizar
     */
    public void actualizarAsamblea(AsambleaDTO asamblea) {
        try {
            asambleaDAO.actualizar(asamblea);

        } catch (Exception ex) {
            Logger.getLogger(AsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarAsamblea

}
