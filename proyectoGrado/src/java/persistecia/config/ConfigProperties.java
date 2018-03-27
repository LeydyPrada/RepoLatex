
package persistecia.config;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jeimmy Nieto
 * Clase que permite obtener leer el archivo de .properties y obtener sus datos
 */
public class ConfigProperties {
    
    public Properties getProperties() {
        try {
            //se crea una instancia a la clase Properties
            Properties propiedades = new Properties();
            //se lee el archivo properties
            propiedades.load( getClass().getResourceAsStream("config.properties"));
            //si el archivo de propiedades NO esta vacio retornan las propiedes leidas
            if (!propiedades.isEmpty()) {                
                return propiedades;
            } else {//sino  retornara NULL
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(Properties.class.getName()).log(Level.SEVERE, null, ex);
            return null;            
        }
    }
    
}
