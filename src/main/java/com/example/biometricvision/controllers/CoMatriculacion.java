/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Asistencia;
import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Horario;
import com.example.biometricvision.models.Matriculacion;
import com.example.biometricvision.service.Sestudiantes;
import com.example.biometricvision.service.Shorario;
import com.example.biometricvision.service.Smatriculacion;
import com.example.biometricvision.utils.Messages;
import com.example.biometricvision.utils.dateCurrent;
import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/matriculacion")
public class CoMatriculacion 
{
    @Autowired
    Matriculacion  matriculacion;
    
    @Autowired
    Smatriculacion smatriculacion;
    
    @Autowired
    Sestudiantes sestudiante;
    
    @Autowired
    Shorario shorario;
    
    

    
    
    @PostMapping("/listareh")
    public ResponseEntity<?> listar_()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Estudiante> es=sestudiante.all();
            List<Horario> ho=shorario.all();
            Map<String,Object> recursos=new HashMap();
            recursos.put("estudiante", es);
            recursos.put("horario", ho);
            return new ResponseEntity<Map<String,Object>>(recursos,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    
    @PostMapping("/insertar")
    public ResponseEntity<?> asistencia(@RequestParam(name="ide") Long ide,@RequestParam(name="idh") Long idh)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(ide!=null && idh!=null)
            {
                Estudiante est=sestudiante.buscar_id(ide);
                Horario hor=shorario.buscar_id(idh);
                
                matriculacion.setIdestudiante(est);
                matriculacion.setIdhorario(hor);
               
                Matriculacion mat=smatriculacion.guardar_actualizar(matriculacion);
                return new ResponseEntity<Matriculacion>(mat,HttpStatus.OK);
            }else
            {
                response.put(Messages.ERROR_KEY, Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
}
