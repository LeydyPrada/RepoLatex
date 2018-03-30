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
public class TipoInmuebleDTO {
    
    private Integer id;
    private String tipoInmueble;
    private List<InmuebleDTO> inmuebles;

    public TipoInmuebleDTO() {
    }

    public TipoInmuebleDTO(Integer id) {
        this.id = id;
    }

    public TipoInmuebleDTO(Integer id, String tipoInmueble) {
        this.id = id;
        this.tipoInmueble = tipoInmueble;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(String tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public List<InmuebleDTO> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<InmuebleDTO> inmuebles) {
        this.inmuebles = inmuebles;
    }
    
       
    
}
