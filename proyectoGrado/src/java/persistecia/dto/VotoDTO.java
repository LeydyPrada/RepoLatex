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
public class VotoDTO {
    
    private Integer id;
    private EncuestaDTO encuesta;
    private PreguntasDTO preguntas;
    private AsambleaDTO asamblea;
    private RespuestasDTO respuestas;
    private String inmueble;

    public VotoDTO() {
    }

    public VotoDTO(Integer id) {
        this.id = id;
    }

    public VotoDTO(Integer id, EncuestaDTO encuesta, PreguntasDTO preguntas, AsambleaDTO asamblea, RespuestasDTO respuestas, String inmueble) {
        this.id = id;
        this.encuesta = encuesta;
        this.preguntas = preguntas;
        this.asamblea = asamblea;
        this.respuestas = respuestas;
        this.inmueble = inmueble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public EncuestaDTO getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(EncuestaDTO encuesta) {
        this.encuesta = encuesta;
    }

    public PreguntasDTO getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(PreguntasDTO preguntas) {
        this.preguntas = preguntas;
    }

    public AsambleaDTO getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(AsambleaDTO asamblea) {
        this.asamblea = asamblea;
    }

    public RespuestasDTO getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(RespuestasDTO respuestas) {
        this.respuestas = respuestas;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }
    
    
    
    
    
}
