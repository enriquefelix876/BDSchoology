/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bdschoology.entidades;

import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import mx.itson.bdschoology.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author enriq_000
 */

@Entity
public class Asignacion {
    
    private int id;
    private String titulo;
    private String descripcion;
    private String plazo_final;
    private int id_curso;
    private int id_profe;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }
 
    public String getPlazo_final() {
        return plazo_final;
    }

    public void setPlazo_final(String plazo_final) {
        this.plazo_final = plazo_final;
    }
    
     /**
     * Metodo encargado de obtener todos los registros de una tabla de una base
     * de datos
     * @return Lista de Registros de una tabla
     */
    public List<Asignacion> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Asignacion> asignaciones = (List<Asignacion>)sesion.createCriteria(Asignacion.class).list();
        return asignaciones;
            
    }
    
     /**
     * Metodo encargado de guardar un registro en la base de datos
     * @param a
     */
    public void guardar(Asignacion a){
    
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(a);
            transaction.commit();
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
    }
    
    public List<Asignacion>obtenerAsignacionesPorIDCurso(int id){
 
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = sesion.createCriteria(Asignacion.class);
        cr.add(Restrictions.eq("id_curso", id));
        List results = cr.list();
        
        List<Asignacion>asignaciones = results;
        
        return asignaciones;
    }

        public List<Asignacion> obtenerAsignacionesPorID(int id){
 
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = sesion.createCriteria(Asignacion.class);
        cr.add(Restrictions.eq("id", id));
        List results = cr.list();
        
        List<Asignacion>asignaciones = results;
        
        return asignaciones;
    }
}
