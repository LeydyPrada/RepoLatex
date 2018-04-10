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
import persistecia.dao.EncuestaDAO;
import persistecia.dao.TipoEncuestaDAO;
import persistecia.dto.EncuestaDTO;
import persistecia.dto.TipoEncuestaDTO;

/**
 *
 * @author USUARIO
 */
public class EncuestaBusiness {

    EncuestaDAO encuestaDAO = new EncuestaDAO();
    TipoEncuestaDAO tipoEncDAO = new TipoEncuestaDAO();

    /**
     * Metodo que consulta todos las encuesta registradas en el sistema
     *
     * @return tipoEncuesta
     */
    public List<EncuestaDTO> listarEncuestas() {
        List<EncuestaDTO> encuesta = new ArrayList<>();

        try {
            encuesta = encuestaDAO.consultarTodos();
            for (int i = 0; i < encuesta.size(); i++) {
                TipoEncuestaDTO tipo = tipoEncDAO.consultarPorId(encuesta.get(i).getTipoEncuesta().getId());
                encuesta.get(i).setTipoEncuesta(tipo);
            }
        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

        return encuesta;
    }//listarEncuestas

    /**
     * Consulta la encuesta por descripción
     *
     * @param desc - descripción de encuesta a consultar
     * @return tipoEncuesta - lista de Encuestas que coincidan
     */
    public List<EncuestaDTO> consultarEncuesta(String desc) {
        List<EncuestaDTO> encuesta = new ArrayList<>();

        try {
            encuesta = encuestaDAO.consultarPorDescripcion(desc);
            for (int i = 0; i < encuesta.size(); i++) {
                TipoEncuestaDTO tipo = tipoEncDAO.consultarPorId(encuesta.get(i).getTipoEncuesta().getId());
                encuesta.get(i).setTipoEncuesta(tipo);
            }

        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }

        return encuesta;
    }//consultarEncuesta

    /**
     * Permite crear una encuesta
     *
     * @param tipoEnc
     */
    public void crearEncuesta(EncuestaDTO tipoEnc) {
        try {
            encuestaDAO.registrar(tipoEnc);

        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearEncuesta

    /**
     * Permite consulta una encuesta por id
     *
     * @param id - identificador de la encuesta
     * @return tipoEnc - Encuesta consultada
     */
    public EncuestaDTO consultarEncPorId(int id) {

        EncuestaDTO encue = new EncuestaDTO();
        try {
            encue = encuestaDAO.consultarPorId(id);

        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return encue;
    }//consultarEncPorId

    /**
     * Permite actualizar una encuesta
     *
     * @param encu - encuesta a actualizar
     */
    public void actualizarEncuesta(EncuestaDTO encu) {
        try {
            encuestaDAO.actualizar(encu);

        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarEncuesta

    /**
     * permite cambiar el estado de una encuesta
     *
     * @param enc - encuesta a cambiar estado
     */
    public void cambiarEstadoEnc(EncuestaDTO enc) {
        try {
            if (enc.getActivo() == 1) {
                enc.setActivo(0);
            } else {
                enc.setActivo(1);
            }
            encuestaDAO.actualizar(enc);

        } catch (Exception ex) {
            Logger.getLogger(EncuestaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cambiarEstadoTipoEnc

}
