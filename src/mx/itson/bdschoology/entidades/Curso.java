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
import mx.itson.bdschoology.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author enriq_000
 */

@Entity
public class Curso {
    
    private int id;
    private String nombre;
    private String descripcion;
    private String periodo;
    private int id_profesor;
    private String codigo;

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

     /**
     * Metodo encargado de obtener todos los registros de una tabla de una base
     * de datos
     * @return Lista de Registros de una tabla
     */
    public List<Curso> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<Curso> cursos = (List<Curso>)sesion.createCriteria(Curso.class).list();
        return cursos;
            
    }
    
     /**
     * Metodo encargado de guardar un registro en la base de datos
     * @param c
     */
    public void guardar(Curso c){
    
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(c);
            transaction.commit();
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
    }
    
    public List<Curso> obtenerCursosPorID(int id){
 
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = sesion.createCriteria(Curso.class);
        cr.add(Restrictions.eq("id", id));
        List results = cr.list();
        
        List<Curso>cursos = results;
        
        return cursos;
    }
    
    public List<Curso> obtenerCursosPorIDProfesor(int id){
 
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        Criteria cr = sesion.createCriteria(Curso.class);
        cr.add(Restrictions.eq("id_profesor", id));
        List results = cr.list();
        
        List<Curso>cursos = results;
        
        return cursos;
    }
    
    public int obtenerUltimoIDCurso(){
    
        int idCurso=0;

        
        for (int i = 0; i < this.obtenerTodos().size(); i++) {
            
            idCurso = this.obtenerTodos().get(i).getId();
        }
        
        return idCurso;
    }

    public List<Curso>obtenerCursosPorAlumno(int idAlumno){
    
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        Query query = sesion.createQuery("SELECT uc.id_curso FROM UsuarioCurso uc WHERE uc.id_usuario = "+idAlumno);
        
        List<Integer>idCursos = query.list();
        
        Criteria cr = sesion.createCriteria(Curso.class);
        
            List <Curso>results=null;
            
            Disjunction disjunction = Restrictions.disjunction();
            
                for (int i = 0; i < idCursos.size(); i++) {
                    
                    disjunction.add(Restrictions.eq("id", idCursos.get(i)));
                    
                }
            cr.add(disjunction);
            
            if(!idCursos.isEmpty()){
                
            results = cr.list();
            
            }
            
        String g = "";
        
        return results;
    }
    
    public List<Curso> obtenerCursoPorCodigo(String codigo){
  
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        
        Criteria cr = sesion.createCriteria(Curso.class);
        
        cr.add(Restrictions.eq("codigo", codigo));
        
        List results = cr.list();

        String g = "";
        
        return results;
        
    }
}