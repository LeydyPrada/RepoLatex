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
    private Integer id_asamblea;
    private String resultado;

    public RegistroAsambleaDTO() {
    }

    public RegistroAsambleaDTO(Integer id) {
        this.id = id;
    }

    public RegistroAsambleaDTO(Integer id, String inmueble, Integer codigo, Integer verificado, Integer id_asamblea) {
        this.id = id;
        this.inmueble = inmueble;
        this.codigo = codigo;
        this.verificado = verificado;
        this.id_asamblea = id_asamblea;
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

    public Integer getId_asamblea() {
        return id_asamblea;
    }

    public void setId_asamblea(Integer id_asamblea) {
        this.id_asamblea = id_asamblea;
    }    

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
    
    
    
}
