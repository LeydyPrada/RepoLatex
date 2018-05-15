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
public class OrdenDiaDTO {
    
    private Integer id;
    private String orden;
    private String descripcion;
    private Integer activo;
    private Integer aprobado;
    private Integer noAprobado;
    private List<AsambleaDTO> asamblea;

    public OrdenDiaDTO() {
    }

    public OrdenDiaDTO(Integer id) {
        this.id = id;
    }

    public OrdenDiaDTO(Integer id, String orden, String descripcion, Integer activo, Integer aprobado, Integer noAprobado) {
        this.id = id;
        this.orden = orden;
        this.descripcion = descripcion;
        this.activo = activo;
        this.aprobado = aprobado;
        this.noAprobado = noAprobado;
    }   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrden() {
        return orden;
    }

    public void setOrden(String orden) {
        this.orden = orden;
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

    public Integer getAprobado() {
        return aprobado;
    }

    public void setAprobado(Integer aprobado) {
        this.aprobado = aprobado;
    }

    public Integer getNoAprobado() {
        return noAprobado;
    }

    public void setNoAprobado(Integer noAprobado) {
        this.noAprobado = noAprobado;
    }    
    
    public List<AsambleaDTO> getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(List<AsambleaDTO> asamblea) {
        this.asamblea = asamblea;
    }

    
        
    
}
