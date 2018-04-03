/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dto;

import java.util.List;

/**
 *
 * @author jnieton
 */
public class PreguntasDTO {
    
    private Integer id;
    private String descripcion;
    private Integer activo;
    private EncuestaDTO encuesta;
    private List<RespuestasDTO> respuestas;

    public PreguntasDTO() {
    }

    public PreguntasDTO(Integer id) {
        this.id = id;
    }

    public PreguntasDTO(Integer id, String descripcion, Integer activo, EncuestaDTO encuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
        this.encuesta = encuesta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public EncuestaDTO getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaDTO encuesta) {
        this.encuesta = encuesta;
    }

    public List<RespuestasDTO> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<RespuestasDTO> respuestas) {
        this.respuestas = respuestas;
    }
    
    
    
}
