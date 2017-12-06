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
public class Entrega {
    
    private int id;
    private String fechaEntrega;
    private String comentario;
    private String archivo;
    private int id_Alumno;
    private int id_profe;
    private int id_asignacion;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(String fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_Alumno() {
        return id_Alumno;
    }

    public void setId_Alumno(int id_Alumno) {
        this.id_Alumno = id_Alumno;
    }

    public int getId_asignacion() {
        return id_asignacion;
    }

    public void setId_asignacion(int id_asignacion) {
        this.id_asignacion = id_asignacion;
    }

    public int getId_profe() {
        return id_profe;
    }

    public void setId_profe(int id_profe) {
        this.id_profe = id_profe;
    }
    
    
    public String getArchivo() {
        return archivo;
    }

    public void setArchivo(String archivo) {
        this.archivo = archivo;
    }
    
     /**
     * Metodo encargado de obtener todos los registros de una tabla de una base
     * de datos
     * @return Lista de Registros de una tabla
     */
    public List<Entrega> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Entrega> entregas = (List<Entrega>)sesion.createCriteria(Entrega.class).list();
        return entregas;
            
    }
    
     /**
     * Metodo encargado de guardar un registro en la base de datos
     * @param en
     */
    public void guardar(Entrega en){
    
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(en);
            transaction.commit();
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
    }
    
    public List<Entrega> obtenerEntregasPorIDProfesor(int id){
 
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = sesion.createCriteria(Entrega.class);
        cr.add(Restrictions.eq("id_profe", id));
        
        List results = cr.list();
        
        List<Entrega>entregas = results;
        
        return entregas;
    }
}