/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.prueba9.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import inacap.webcomponent.prueba9.model.AlumnoModel;
import org.springframework.http.HttpStatus;
/**
 *
 * @author daniel
 */
@RestController
@RequestMapping("/alumno")
public class AlumnoController {
    
    @GetMapping()
    public List<AlumnoModel> listarTodos() {
        
        return AlumnoModel.alumnos;
        
    }

    
    @GetMapping("/{id}")
    public AlumnoModel muestraUnAlumno(@PathVariable String id) {
        AlumnoModel alumno = new AlumnoModel();
        
        return alumno.buscaAlumno(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<AlumnoModel> editaAlumno(@PathVariable String id, @RequestBody AlumnoModel alumnoEditar) {
        
        AlumnoModel alumno = new AlumnoModel();
        
        
        
        return new ResponseEntity<>(alumno.editarAlumno(Integer.parseInt(id), alumnoEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> agregarAlumno(@RequestBody AlumnoModel nuevoAlumno) {
        
        AlumnoModel alumno = new AlumnoModel();
        
        if (alumno.nuevoAlumno(nuevoAlumno)) {
            
            return new ResponseEntity<>(HttpStatus.CREATED);
            
        }else{
            
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        AlumnoModel alumno = new AlumnoModel();
        
        if (alumno.eliminarAlumno(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
        return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        
        
    }
    
}
