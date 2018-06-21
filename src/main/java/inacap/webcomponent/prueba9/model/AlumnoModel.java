/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.model;

import java.util.ArrayList;

/**
 *
 * @author daniel
 */
public class AlumnoModel {
 
    private int idAlumno;
    
    private String nombreAlumno;
    
    private String apellidoAlumno;
    
    public static ArrayList<AlumnoModel> alumnos = new ArrayList<>();

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }

    public String getApellidoAlumno() {
        return apellidoAlumno;
    }

    public void setApellidoAlumno(String apellidoAlumno) {
        this.apellidoAlumno = apellidoAlumno;
    }

    public AlumnoModel() {
    }

    public AlumnoModel(String nombreAlumno, String apellidoAlumno) {
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
    }

    private AlumnoModel(int idAlumno, String nombreAlumno, String apellidoAlumno) {
        this.idAlumno = idAlumno;
        this.nombreAlumno = nombreAlumno;
        this.apellidoAlumno = apellidoAlumno;
    }
    
    public boolean nuevoAlumno(AlumnoModel nuevoAlumno){
    
        int id = 0;
        
        if (!alumnos.isEmpty()) {
            
            for (AlumnoModel alumno : alumnos) {
                if (alumno.getIdAlumno() > id) {
                    id = alumno.getIdAlumno();
                }
            }
            
        }
        
        id++;
        
        alumnos.add(new AlumnoModel(id, nuevoAlumno.getNombreAlumno(), nuevoAlumno.getApellidoAlumno()));
         
        return true;
    }
    
    public AlumnoModel buscaAlumno(int idAlumnoBuscado){
    
        AlumnoModel alumnoEncontrado = null;
        
        if(!alumnos.isEmpty()){
            for (AlumnoModel alumno : alumnos) {
                if (alumno.getIdAlumno() == idAlumnoBuscado) {
                    alumnoEncontrado = alumno;
                }
            }
        }
        
        return alumnoEncontrado;
        
    }
    
    public AlumnoModel editarAlumno(int idAlumno, AlumnoModel alumnoEditar){
    
        AlumnoModel alumnoEditado = null;
        
        if(!alumnos.isEmpty()){
            for (AlumnoModel alumno : alumnos) {
                if (alumno.getIdAlumno() == idAlumno) {
                    alumno.setNombreAlumno(alumnoEditar.getNombreAlumno());
                    alumno.setApellidoAlumno(alumnoEditar.getApellidoAlumno());
                    
                    alumnoEditado = alumno;
                }
            }
        }
        
        return alumnoEditado;
        
    }
    
    public boolean eliminarAlumno(int id){
        AlumnoModel alumnoEliminado = null;
        
        if(!alumnos.isEmpty()){
            for (AlumnoModel alumno : alumnos) {
                if (alumno.getIdAlumno() == idAlumno) {
                   alumnoEliminado = alumno;
                }
            }
        }
        
        alumnos.remove(alumnoEliminado);
        
        
        return true;
    }
    
    
    
    
}
