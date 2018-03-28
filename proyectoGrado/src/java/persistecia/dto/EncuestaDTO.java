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
public class EncuestaDTO {
    
    private Integer id;
    private String descripcion;
    private Integer activo;
    private TipoEncuestaDTO tipoEncuesta;

    public EncuestaDTO() {
    }

    public EncuestaDTO(Integer id) {
        this.id = id;
    }

    public EncuestaDTO(Integer id, String descripcion, Integer activo, TipoEncuestaDTO tipoEncuesta) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
        this.tipoEncuesta = tipoEncuesta;
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

    public TipoEncuestaDTO getTipoEncuesta() {
        return tipoEncuesta;
    }

    public void setTipoEncuesta(TipoEncuestaDTO tipoEncuesta) {
        this.tipoEncuesta = tipoEncuesta;
    }

               
    
}
