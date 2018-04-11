/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.dao.OrdenDiaDAO;
import persistecia.dto.OrdenDiaDTO;

/**
 *
 * @author USUARIO
 */
public class OrdenDiaBusiness {
    
    /* METODOS PARA EL TIPO DE DOCUMENTO */
    
    OrdenDiaDAO ordenDiaDAO = new OrdenDiaDAO();
    
    public List<OrdenDiaDTO> listarOrdenesDeDia(){
        List<OrdenDiaDTO> ordenesDia = new ArrayList<>();
        
        try{            
            ordenesDia = ordenDiaDAO.consultarTodos();
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordenesDia;
    }//listarOrdenesDeDia
    
    public List<OrdenDiaDTO> consultarPorOrdenDia(String Orden){
        List<OrdenDiaDTO> ordenesDia = new ArrayList<>();
        
        try{            
            ordenesDia = ordenDiaDAO.consultarPorOrden(Orden);
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ordenesDia;
    } //consultarPorOrdenDia
    
    public void crearOrdenDia(OrdenDiaDTO ordenDia){
        try{            
            ordenDiaDAO.registrar(ordenDia);
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//crearOrdenDia
    
    public OrdenDiaDTO consultarOrdenDiaPorId(int id){
        
        OrdenDiaDTO ordenDia = new OrdenDiaDTO();
       try{            
            ordenDia = ordenDiaDAO.consultarPorId(id);
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ordenDia;
    }//consultarOrdenDiaPorId
    
    public void actualizarOrdenDia(OrdenDiaDTO ordenDia){
       try{            
            ordenDiaDAO.actualizar(ordenDia);
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//actualizarOrdenDia
    
    public void cambiarEstadoOrdenDia(OrdenDiaDTO ordenDia){
       try{            
           if(ordenDia.getActivo()==1)
               ordenDia.setActivo(0);
           else
               ordenDia.setActivo(1)
                       ;
            ordenDiaDAO.actualizar(ordenDia);
            
        }catch(Exception ex){
            Logger.getLogger(OrdenDiaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//cambiarEstadoOrdenDia
    
}
