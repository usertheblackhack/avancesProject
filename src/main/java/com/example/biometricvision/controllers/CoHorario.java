/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Curso;
import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Horario;
import com.example.biometricvision.models.Materia;
import com.example.biometricvision.models.Profesor;
import com.example.biometricvision.service.Scurso;
import com.example.biometricvision.service.Shorario;
import com.example.biometricvision.service.Smateria;
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
@RequestMapping("/api/horario")
public class CoHorario 
{
    @Autowired
    Shorario shorario;
    
    @Autowired
    Smateria smateria;
    
    @Autowired
    Sprofesor sprofesor;
    
    @Autowired
    Scurso scurso;
    
    
    @PostMapping("/listarcmp")
    public ResponseEntity<?> listar_()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Curso> cu=scurso.all();
            List<Materia> ma=smateria.all();
            List<Profesor> pro=sprofesor.all();
            Map<String,Object> recursos=new HashMap();
            recursos.put("curso", cu);
            recursos.put("materia", ma);
            recursos.put("profesor", pro);
            return new ResponseEntity<Map<String,Object>>(recursos,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
    
    
    @PostMapping("/insertar")
    public ResponseEntity<?> insertar(Horario horario, @RequestParam(name="idc") Long idc, 
            @RequestParam(name="idm") Long idm, @RequestParam(name="idp") Long idp)
    {
        Map<String,Object> response=new HashMap();
        try
        {
            if(horario.getDia()!=null && horario.getHora()!=null && idc!=null && idm!=null && idp!=null)
            {
                try
                {
                    Curso curso=scurso.buscar_id(idc);
                    Materia materia=smateria.buscar_id(idm);
                    Profesor profesor=sprofesor.buscar_id(idp);

                    horario.setIdcurso(curso);
                    horario.setIdmateria(materia);
                    horario.setIdprofesor(profesor);
                   
                    Horario est=shorario.guardar_actualizar(horario);
                    return new ResponseEntity<Horario>(est,HttpStatus.OK);
                }
                catch(Exception ex)
                {
                    response.put(Messages.ERROR_KEY, ex.getMessage());
                    return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_ACCEPTABLE); 
                } 
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
    
    
    @PostMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Horario> le=shorario.all();
            return new ResponseEntity<List<Horario>>(le,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
   
}
