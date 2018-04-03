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
public class TipoAsambleaDTO {
    
    private Integer id;
    private String tipo;
    private Integer activo;
    private List<AsambleaDTO> asamblea;

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

    public List<AsambleaDTO> getAsamblea() {
        return asamblea;
    }

    public void setAsamblea(List<AsambleaDTO> asamblea) {
        this.asamblea = asamblea;
    }
    
    
    
}
