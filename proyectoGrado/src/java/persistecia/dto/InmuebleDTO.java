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
public class InmuebleDTO {
    
    private Integer id;
    private String inmueble;
    private Integer area_total;
    private Integer area_construida;
    private Integer area_ponderar;
    private Integer coeficiente;
    private TipoInmuebleDTO tipoInmueble;
    private UsuarioDTO usuario;

    public InmuebleDTO() {
    }

    public InmuebleDTO(Integer id) {
        this.id = id;
    }

    public InmuebleDTO(Integer id, String inmueble, Integer area_total, Integer area_construida, Integer area_ponderar, Integer coeficiente, TipoInmuebleDTO tipoInmueble, UsuarioDTO usuario) {
        this.id = id;
        this.inmueble = inmueble;
        this.area_total = area_total;
        this.area_construida = area_construida;
        this.area_ponderar = area_ponderar;
        this.coeficiente = coeficiente;
        this.tipoInmueble = tipoInmueble;
        this.usuario = usuario;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInmueble() {
        return inmueble;
    }

    public void setInmueble(String inmueble) {
        this.inmueble = inmueble;
    }

    public Integer getArea_total() {
        return area_total;
    }

    public void setArea_total(Integer area_total) {
        this.area_total = area_total;
    }

    public Integer getArea_construida() {
        return area_construida;
    }

    public void setArea_construida(Integer area_construida) {
        this.area_construida = area_construida;
    }

    public Integer getArea_ponderar() {
        return area_ponderar;
    }

    public void setArea_ponderar(Integer area_ponderar) {
        this.area_ponderar = area_ponderar;
    }

    public Integer getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(Integer coeficiente) {
        this.coeficiente = coeficiente;
    }

    public TipoInmuebleDTO getTipoInmueble() {
        return tipoInmueble;
    }

    public void setTipoInmueble(TipoInmuebleDTO tipoInmueble) {
        this.tipoInmueble = tipoInmueble;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }
    
        
    
}
