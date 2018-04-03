/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dto;

import java.sql.Time;
import java.util.Date;
import java.util.List;


/**
 *
 * @author jnieton
 */
public class AsambleaDTO {
    
    private Integer id;
    private Integer idTipoAsamblea;
    private String descripcion;
    private Date fechaEjecucion;
    private Time horaInicio;
    private Time horaFin;
    private Integer idOrdenDia;
    private Integer idEstadoAsamblea;
    private List<VotoDTO> votos;

    public AsambleaDTO() {
    }

    public AsambleaDTO(Integer id) {
        this.id = id;
    }

    public AsambleaDTO(Integer id, Integer idTipoAsamblea, String descripcion, Date fechaEjecucion, Time horaInicio, Time horaFin, Integer idOrdenDia, Integer idEstadoAsamblea) {
        this.id = id;
        this.idTipoAsamblea = idTipoAsamblea;
        this.descripcion = descripcion;
        this.fechaEjecucion = fechaEjecucion;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.idOrdenDia = idOrdenDia;
        this.idEstadoAsamblea = idEstadoAsamblea;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdTipoAsamblea() {
        return idTipoAsamblea;
    }

    public void setIdTipoAsamblea(Integer idTipoAsamblea) {
        this.idTipoAsamblea = idTipoAsamblea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public Integer getIdOrdenDia() {
        return idOrdenDia;
    }

    public void setIdOrdenDia(Integer idOrdenDia) {
        this.idOrdenDia = idOrdenDia;
    }

    public Integer getIdEstadoAsamblea() {
        return idEstadoAsamblea;
    }

    public void setIdEstadoAsamblea(Integer idEstadoAsamblea) {
        this.idEstadoAsamblea = idEstadoAsamblea;
    }

    public List<VotoDTO> getVotos() {
        return votos;
    }

    public void setVotos(List<VotoDTO> votos) {
        this.votos = votos;
    }
    
      
    
    
}
