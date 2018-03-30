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
    private String tipoDocumento;
    List<UsuarioDTO> usuarios;

    public TipoDocumentoDTO() {
    }

    public TipoDocumentoDTO(Integer id) {
        this.id = id;
    }

    public TipoDocumentoDTO(Integer id, String tipoDocumento) {
        this.id = id;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
    
    
    
}
