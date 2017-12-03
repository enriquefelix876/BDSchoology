/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bdschoology.gui;

import java.awt.List;
import java.util.ArrayList;
import mx.itson.bdschoology.entidades.TipoCuenta;
import mx.itson.bdschoology.entidades.Usuario;

/**
 *
 * @author enriq_000
 */
public class Main {

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        // TODO code application logic here
        
        Usuario user = new Usuario();
        
        user.setNombre("Christian Alberto Velasquez Covarrubias");
        user.setCorreo("chino7.com");
        user.setPass("12345678");
        user.setTipoCuenta("Estudiante");
        
        user.guardar(user);
    }
    
}