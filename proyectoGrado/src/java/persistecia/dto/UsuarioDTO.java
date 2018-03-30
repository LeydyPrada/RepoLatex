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
public class UsuarioDTO {
    
    private String id;
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;
    private String genero;
    private String email;
    private String usuarioLogin;
    private String contraseña;
    private Integer activo;
    private TipoDocumentoDTO tipoDocumento;
    private TipoUsuarioDTO tipoUusario;
    private List<InmuebleDTO> inmuebles;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String id) {
        this.id = id;
    }

    public UsuarioDTO(String id, String nombre, String apellido, String direccion, String telefono, String genero, String email, String usuarioLogin, String contraseña, Integer activo, TipoDocumentoDTO tipoDocumento, TipoUsuarioDTO tipoUusario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.genero = genero;
        this.email = email;
        this.usuarioLogin = usuarioLogin;
        this.contraseña = contraseña;
        this.activo = activo;
        this.tipoDocumento = tipoDocumento;
        this.tipoUusario = tipoUusario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsuarioLogin() {
        return usuarioLogin;
    }

    public void setUsuarioLogin(String usuarioLogin) {
        this.usuarioLogin = usuarioLogin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    public TipoDocumentoDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumentoDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public TipoUsuarioDTO getTipoUusario() {
        return tipoUusario;
    }

    public void setTipoUusario(TipoUsuarioDTO tipoUusario) {
        this.tipoUusario = tipoUusario;
    }

    public List<InmuebleDTO> getInmuebles() {
        return inmuebles;
    }

    public void setInmuebles(List<InmuebleDTO> inmuebles) {
        this.inmuebles = inmuebles;
    }
    
                           
                                 
                
    
    
    
}
