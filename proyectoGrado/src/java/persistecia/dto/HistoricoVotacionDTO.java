/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dto;

import java.util.Date;

/**
 *
 * @author jnieton
 */
public class HistoricoVotacionDTO {
    
    private Integer id;
    private UsuarioDTO usuario;
    private Integer voto;
    private Date fecha;

    public HistoricoVotacionDTO() {
    }

    public HistoricoVotacionDTO(Integer id) {
        this.id = id;
    }

    public HistoricoVotacionDTO(Integer id, UsuarioDTO usuario, Integer voto, Date fecha) {
        this.id = id;
        this.usuario = usuario;
        this.voto = voto;
        this.fecha = fecha;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Integer getVoto() {
        return voto;
    }

    public void setVoto(Integer voto) {
        this.voto = voto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    
    
}
