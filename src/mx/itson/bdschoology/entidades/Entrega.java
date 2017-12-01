/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.bdschoology.entidades;

import java.util.Date;

/**
 *
 * @author enriq_000
 */
public class Entrega {
    
    private int id;
    private Date fechaEntrega;
    private String comentario;
    private String comentarioProfe;
    private int id_Alumno;
    private int id_asignacion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentarioProfe() {
        return comentarioProfe;
    }

    public void setComentarioProfe(String comentarioProfe) {
        this.comentarioProfe = comentarioProfe;
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
    
    
}
