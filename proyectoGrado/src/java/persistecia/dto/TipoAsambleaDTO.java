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
public class TipoAsambleaDTO {
    
    private Integer id;
    private String tipo;
    private Integer activo;

    public TipoAsambleaDTO() {
    }

    public TipoAsambleaDTO(Integer id) {
        this.id = id;
    }

    public TipoAsambleaDTO(Integer id, String tipo, Integer activo) {
        this.id = id;
        this.tipo = tipo;
        this.activo = activo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    
    
    
}
