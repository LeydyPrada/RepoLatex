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
    private AsambleaDTO asamblea;
    private List<VotoDTO> votos;

    public PreguntasDTO() {
    }

    public PreguntasDTO(Integer id) {
        this.id = id;
    }

    public PreguntasDTO(Integer id, String descripcion, Integer activo, AsambleaDTO encuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
        this.asamblea = encuesta;
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

    public AsambleaDTO getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(AsambleaDTO asamblea) {
        this.asamblea = asamblea;
    }

    public List<VotoDTO> getVotos() {
        return votos;
    }

    public void setVotos(List<VotoDTO> votos) {
        this.votos = votos;
    }
    
    
    
}
