/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */ 
package mx.itson.bdschoology.entidades;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.JOptionPane;
import mx.itson.bdschoology.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author enriq_000
 */

@Entity
public class Usuario {
    
    private int id;
    private String nombre;
    private String correo;
    private String pass;
    private String tipoCuenta;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
    
     /**
     * Metodo encargado de obtener todos los registros de una tabla de una base
     * de datos
     * @return Lista de Registros de una tabla
     */
    public List<Usuario> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> usuarios = (List<Usuario>)sesion.createCriteria(Usuario.class).list();
        return usuarios;
            
    }
    
     /**
     * Metodo encargado de guardar un registro en la base de datos
     * @param u
     */
    public void guardar(Usuario u){
    
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(u);
            transaction.commit();
            JOptionPane.showMessageDialog(null, "El Usuario se ha registrado con éxito");
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
    }
}
