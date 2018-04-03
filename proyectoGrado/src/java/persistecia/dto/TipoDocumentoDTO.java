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
public class TipoDocumentoDTO {
    
    private Integer id;
    private String codigo;
    private String tipoDocumento;
    private Integer activo;
    List<UsuarioDTO> usuarios;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Integer id) {
        this.id = id;
    }

    public TipoDocumentoDTO(Integer id, String codigo, String tipoDocumento, Integer activo) {
        this.id = id;
        this.codigo = codigo;
        this.tipoDocumento = tipoDocumento;
        this.activo = activo;
    }    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public List<UsuarioDTO> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioDTO> usuarios) {
        this.usuarios = usuarios;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }
    
    
    
}
