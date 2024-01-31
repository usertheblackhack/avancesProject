/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Profesor;
import com.example.biometricvision.service.Sprofesor;
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
@RequestMapping("/api/profesor")
public class CoProfesor 
{
   @Autowired
   Sprofesor sprofesor;
    
    
    @PostMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Profesor> pr=sprofesor.all();
            return new ResponseEntity<List<Profesor>>(pr,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(Profesor pro)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(pro.getNombre()!="" && pro.getNumero_telefono()!="" && pro.getEdad()!=null
                && pro.getDireccion()!="" && pro.getCorreo()!="" && pro.getCedula()!="" 
                    && pro.getSexo()!=null)
            {
                pro.setFecha_creacion(dateCurrent.getDateCurrent());
                pro.setFecha_modificacion(dateCurrent.getDateCurrent());
                Profesor est=sprofesor.guardar_actualizar(pro);
                return new ResponseEntity<Profesor>(est,HttpStatus.OK);
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
                Profesor pr=sprofesor.buscar_id(id);
                pr.setEstado(false);
                sprofesor.guardar_actualizar(pr);
                response.put(Messages.ACCEPT, Messages.eliminado_correcto);
                return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
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
    
    
    @PostMapping("/actualizar")
    public ResponseEntity<?> actualizar(Profesor pro)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(pro.getIdprofesor()!=null && pro.getNombre()!="" && pro.getNumero_telefono()!="" && pro.getEdad()!=null
                && pro.getDireccion()!="" && pro.getCorreo()!="" && pro.getCedula()!="" 
                    && pro.getSexo()!=null && pro.getEstado()!=null)
            {
                Profesor est= sprofesor.buscar_id(pro.getIdprofesor());
                est.setSexo(pro.getSexo());
                est.setNumero_telefono(pro.getNumero_telefono());
                est.setNombre(pro.getNombre());
                est.setApellido(pro.getApellido());
                est.setCedula(pro.getCedula());
                est.setCorreo(pro.getCorreo());
                est.setEdad(pro.getEdad());
                est.setEstado(pro.getEstado());
                Profesor est_act=sprofesor.guardar_actualizar(est);
                return new ResponseEntity<Profesor>(est_act,HttpStatus.OK);
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
                Profesor est= sprofesor.buscar_cedula(cedula);
                return new ResponseEntity<Profesor>(est,HttpStatus.OK);
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
                Profesor est= sprofesor.buscar_id(id);
                return new ResponseEntity<Profesor>(est,HttpStatus.OK);
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
