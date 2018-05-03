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
public class RegistroAsambleaDTO {
    private Integer id;
    private String inmueble;
    private Integer codigo;
    private Integer verificado;

    public RegistroAsambleaDTO() {
    }

    public RegistroAsambleaDTO(Integer id) {
        this.id = id;
    }

    public RegistroAsambleaDTO(Integer id, String inmueble, Integer codigo, Integer verificado) {
        this.id = id;
        this.inmueble = inmueble;
        this.codigo = codigo;
        this.verificado = verificado;
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

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getVerificado() {
        return verificado;
    }

    public void setVerificado(Integer verificado) {
        this.verificado = verificado;
    }
    
    
    
}
