/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistecia.dao;

import persistecia.config.Conexion;

/**
 *
 * @author jnieton
 */
public class EstadoAsambleaDAO {
    
    private static final String CREAR_SQL = "INSERT INTO tipo_inmueble (id, tipo_inmueble, activo) VALUES (?, ?, ?)";
    private static final String ACTUALIZAR_SQL = "UPDATE tipo_inmueble SET tipo_inmueble = ?, activo = ? WHERE id = ?";
    private static final String BORRAR_SQL = "DELETE FROM tipo_inmueble WHERE id = ?";
    private static final String CONSULTAR_SQL = "SELECT * FROM tipo_inmueble WHERE id = ?";
    private static final String CONSULTAR_TODOS_SQL = "SELECT * FROM tipo_inmueble";
    
    private static final Conexion con = Conexion.obtener();
    
}
