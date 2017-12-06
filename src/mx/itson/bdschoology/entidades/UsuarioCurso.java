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
public class UsuarioCurso {
    
    private int id;
    private int id_usuario;
    private int id_curso;

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }
    
     /**
     * Metodo encargado de obtener todos los registros de una tabla de una base
     * de datos
     * @return Lista de Registros de una tabla
     */
    public List<UsuarioCurso> obtenerTodos(){
        Session sesion = HibernateUtil.getSessionFactory().openSession();
        List<UsuarioCurso> cursos = (List<UsuarioCurso>)sesion.createCriteria(UsuarioCurso.class).list();
        return cursos;
            
    }
    
     /**
     * Metodo encargado de guardar un registro en la base de datos
     * @param uc
     */
    public void guardar(UsuarioCurso uc){
    
        try{
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Transaction transaction = sesion.beginTransaction();
            sesion.save(uc);
            transaction.commit();
        }catch(Exception e){
        
            System.out.println(e.getMessage());
        }
    }
    
    public List<Usuario> obtenerAlumnosPorCurso(int idCurso){
    
            Session sesion = HibernateUtil.getSessionFactory().openSession();
            Query query = sesion.createQuery("SELECT uc.id_usuario FROM UsuarioCurso uc WHERE uc.id_curso = "+idCurso);

            List<Integer>idAlumnos = query.list();
            
            Criteria cr = sesion.createCriteria(Usuario.class);
            List <Usuario>results=null;
            Disjunction disjunction = Restrictions.disjunction();
            
                for (int i = 0; i < idAlumnos.size(); i++) {
                    
                    disjunction.add(Restrictions.eq("id", idAlumnos.get(i)));
                    
                }
            cr.add(disjunction);

            if(!idAlumnos.isEmpty()){
                
            results = cr.list();
            
            }
            
            String g = "";
            
 
        return results;
        
    }
    
}
