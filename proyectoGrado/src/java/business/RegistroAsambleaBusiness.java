/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistecia.dao.InmuebleDAO;
import persistecia.dao.RegistroAsambleaDAO;
import persistecia.dto.InmuebleDTO;
import persistecia.dto.RegistroAsambleaDTO;

/**
 *
 * @author jnieton
 */
public class RegistroAsambleaBusiness {
    
    InmuebleDAO inmuebleDAO = new InmuebleDAO();
    RegistroAsambleaDAO registroAsambleaDAO = new RegistroAsambleaDAO();
    
    
     public void crearRegistroAsamblea(){
      List<InmuebleDTO> totalInmuebles; 
      RegistroAsambleaDTO registroAsamblea = new RegistroAsambleaDTO();
      Random rnd = new Random();      
      Set<Integer> codigosUsados = new HashSet<>();
       try{             
           totalInmuebles = inmuebleDAO.consultarTodos();
           
           if(totalInmuebles !=null){
           
        //codigos aleatorios entre rango especifico;                
           for(int i=1; i<=totalInmuebles.size(); i++){               
              int randomNum = 100 + rnd.nextInt((2000 - 100) + 1);  

              if (!codigosUsados.contains(randomNum)){
                  registroAsamblea.setCodigo(randomNum);
                  registroAsamblea.setInmueble(totalInmuebles.get(i).getInmueble());
                  registroAsamblea.setVerificado(0);
                  registroAsambleaDAO.registrar(registroAsamblea);                 
                  codigosUsados.add(randomNum);
                }
            }
           }
            
        }catch(Exception ex){
            Logger.getLogger(RegistroAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public RegistroAsambleaDTO validarRegistroAsamblea(String idUsuario, int codigo){
        List<InmuebleDTO> inmuebles;
        RegistroAsambleaDTO registro = new RegistroAsambleaDTO();
        
        try{
            inmuebles = inmuebleDAO.consultarPorUsuario(idUsuario);
            
            if(inmuebles != null){
                for(InmuebleDTO inmueble: inmuebles ){                
                registro=registroAsambleaDAO.consultarPorInmuebleCodigo(codigo, inmueble.getInmueble());                
                }          
            }           
        }catch(Exception ex){
            Logger.getLogger(RegistroAsambleaBusiness.class.getName()).log(Level.SEVERE, null, ex);
        }
        return registro;       
     }
    
}
