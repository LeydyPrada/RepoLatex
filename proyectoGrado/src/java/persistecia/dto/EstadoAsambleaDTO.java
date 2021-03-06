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
public class EstadoAsambleaDTO {
    
    private Integer id;
    private String descripcion;
    private Integer activo;
    private List<AsambleaDTO> asambleas;

    public EstadoAsambleaDTO() {
    }

    public EstadoAsambleaDTO(Integer id) {
        this.id = id;
    }

    public EstadoAsambleaDTO(Integer id, String descripcion, Integer activo) {
        this.id = id;
        this.descripcion = descripcion;
        this.activo = activo;
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

    public List<AsambleaDTO> getAsambleas() {
        return asambleas;
    }

    public void setAsambleas(List<AsambleaDTO> asambleas) {
        this.asambleas = asambleas;
    }
    
    
    
}
