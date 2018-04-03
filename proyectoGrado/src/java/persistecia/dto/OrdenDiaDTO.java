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
public class OrdenDiaDTO {
    
    private Integer id;
    private String orden;
    private String descripcion;
    private Integer activo;

    public OrdenDiaDTO() {
    }

    public OrdenDiaDTO(Integer id) {
        this.id = id;
    }

    public OrdenDiaDTO(Integer id, String orden, String descripcion, Integer activo) {
        this.id = id;
        this.orden = orden;
        this.descripcion = descripcion;
        this.activo = activo;
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

    
        
    
}
