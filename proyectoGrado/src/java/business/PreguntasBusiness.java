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
import persistecia.dao.PreguntasDAO;
import persistecia.dto.AsambleaDTO;
import persistecia.dto.PreguntasDTO;

/**
 *
 * @author USUARIO
 */
public class PreguntasBusiness {
    
    PreguntasDAO preguntasDAO = new PreguntasDAO();
    AsambleaDAO asambleaDAO = new AsambleaDAO();

    /**
     * Metodo que consulta todos las encuesta registradas en el sistema
     *
     * @return preguntas
     */
    public List<PreguntasDTO> listarPreguntas() {
        List<PreguntasDTO> preguntas = new ArrayList<>();

        try {
            preguntas = preguntasDAO.consultarTodos();
            for (int i = 0; i < preguntas.size(); i++) {
                AsambleaDTO asam = asambleaDAO.consultarPorId(preguntas.get(i).getAsamblea().getId());
                preguntas.get(i).setAsamblea(asam);
            }
        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }

        return preguntas;
    }//listarPreguntas

    /**
     * Consulta la encuesta por descripción
     *
     * @param desc - descripción de encuesta a consultar
     * @return tipoEncuesta - lista de Encuestas que coincidan
     */
    public List<PreguntasDTO> consultarPreguntas(String desc) {
        List<PreguntasDTO> preguntas = new ArrayList<>();

        try {
            preguntas = preguntasDAO.consultarPorDesc(desc);
            for (int i = 0; i < preguntas.size(); i++) {
                AsambleaDTO enc = asambleaDAO.consultarPorId(preguntas.get(i).getAsamblea().getId());
                preguntas.get(i).setAsamblea(enc);
            }

        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }

        return preguntas;
    }//consultarPreguntas

    /**
     * Permite crear una pregunta
     *
     * @param pregunta
     */
    public void crearPreguntas(PreguntasDTO pregunta) {
        try {
            preguntasDAO.registrar(pregunta);

        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearPreguntas

    /**
     * Permite consulta una pregunta por id
     *
     * @param id - identificador de la encuesta
     * @return pre - Preguntas consultada
     */
    public PreguntasDTO consultarPrePorId(int id) {

        PreguntasDTO pre = new PreguntasDTO();
        try {
            pre = preguntasDAO.consultarPorId(id);

        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pre;
    }//consultarPrePorId

    /**
     * Permite actualizar una encuesta
     *
     * @param pre - pregunta a actualizar
     */
    public void actualizarPreguntas(PreguntasDTO pre) {
        try {
            preguntasDAO.actualizar(pre);

        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//actualizarPreguntas

    /**
     * permite cambiar el estado de una pregunta
     *
     * @param pre - pregunta a cambiar estado
     */
    public void cambiarEstadoPre(PreguntasDTO pre) {
        try {
            if (pre.getActivo() == 1) {
                pre.setActivo(0);
            } else {
                pre.setActivo(1);
            }
            preguntasDAO.actualizar(pre);

        } catch (Exception ex) {
            Logger.getLogger(PreguntasBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//cambiarEstadoTipoPre
    
}
