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
    private PreguntasDTO preguntas;
    private AsambleaDTO asamblea;
    private String inmueble;

    public VotoDTO() {
    }

    public VotoDTO(Integer id) {
        this.id = id;
    }

    public VotoDTO(Integer id, PreguntasDTO preguntas, AsambleaDTO asamblea, String inmueble) {
        this.id = id;
        this.preguntas = preguntas;
        this.asamblea = asamblea;
        this.inmueble = inmueble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }
    
    
    
    
    
}
