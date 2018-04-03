/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dto;

/**
 *
 * @author jnieton
 */
public class RespuestasDTO {
    
    private Integer id;
    private String descripcion;
    private PreguntasDTO pregunta;

    public RespuestasDTO() {
    }

    public RespuestasDTO(Integer id) {
        this.id = id;
    }

    public RespuestasDTO(Integer id, String descripcion, PreguntasDTO pregunta) {
        this.id = id;
        this.descripcion = descripcion;
        this.pregunta = pregunta;
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

    public PreguntasDTO getPregunta() {
        return pregunta;
    }

    public void setPregunta(PreguntasDTO pregunta) {
        this.pregunta = pregunta;
    }
    
    
    
}
