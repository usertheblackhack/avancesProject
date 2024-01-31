/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.service.Sestudiantes;
import com.example.biometricvision.utils.Messages;
import com.example.biometricvision.utils.dateCurrent;
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
@RequestMapping("/api/estudiantes")
public class CoEstudiante 
{
    @Autowired
    Sestudiantes sestudiante;
    
    
    @PostMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Estudiante> le=sestudiante.all();
            return new ResponseEntity<List<Estudiante>>(le,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(Estudiante estudiante)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(estudiante.getNombre()!="" && estudiante.getNumero_telefono()!="" && estudiante.getEdad()!=null
                && estudiante.getDireccion()!="" && estudiante.getCorreo()!="" && estudiante.getCedula()!="" 
                    && estudiante.getSexo()!=null)
            {
                Estudiante est=sestudiante.guardar_actualizar(estudiante);
                return new ResponseEntity<Estudiante>(est,HttpStatus.OK);
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
    
    
    
    @PostMapping("/eliminar")
    public ResponseEntity<?> eliminar(@RequestParam(name="id") Long id)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(id!=null)
            {
                Estudiante es=sestudiante.buscar_id(id);
                es.setEstado(false);
                sestudiante.guardar_actualizar(es);
                response.put(Messages.ACCEPT, Messages.eliminado_correcto);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
            }else
            {
                response.put("error", Messages.error_datos_incompletos);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
            }  
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(Estudiante estudiante)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(estudiante.getIdestudiante()!=null && estudiante.getNombre()!="" && estudiante.getNumero_telefono()!="" && estudiante.getEdad()!=null
                && estudiante.getDireccion()!="" && estudiante.getCorreo()!="" && estudiante.getCedula()!="" 
                    && estudiante.getSexo()!=null && estudiante.getEstado()!=null)
            {
                Estudiante est= sestudiante.buscar_id(estudiante.getIdestudiante());
                est.setSexo(estudiante.getSexo());
                est.setNumero_telefono(estudiante.getNumero_telefono());
                est.setNombre(estudiante.getNombre());
                est.setApellido(estudiante.getApellido());
                est.setCedula(estudiante.getCedula());
                est.setCorreo(estudiante.getCorreo());
                est.setEdad(estudiante.getEdad());
                est.setEstado(estudiante.getEstado());
                Estudiante est_act=sestudiante.guardar_actualizar(est);
                return new ResponseEntity<Estudiante>(est_act,HttpStatus.OK);
            }
            else
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
    
    
    @PostMapping("/buscarcedula")
    public ResponseEntity<?> buscar_cedula(@RequestParam(name="cedula") String cedula)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(cedula!="")
            {
                Estudiante est= sestudiante.buscar_cedula(cedula);
                return new ResponseEntity<Estudiante>(est,HttpStatus.OK);
            }
            else
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
    
    
    @PostMapping("/buscarid")
    public ResponseEntity<?> buscar_id(@RequestParam(name="id") Long id)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(id!=null)
            {
                Estudiante est= sestudiante.buscar_id(id);
                return new ResponseEntity<Estudiante>(est,HttpStatus.OK);
            }
            else
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
