/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.controllers;

import com.example.biometricvision.models.Carrera;
import com.example.biometricvision.models.Periodo;
import com.example.biometricvision.service.Scarrera;
import com.example.biometricvision.service.Speriodo;
import com.example.biometricvision.utils.Messages;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/periodo")
public class CoPeriodo 
{
    @Autowired
    Speriodo speriodo;
    
    @PostMapping("/listar")
    public ResponseEntity<?> listar()
    {
        Map<String,Object> response=new HashMap();
        try
        {
            List<Periodo> le=speriodo.all();
            return new ResponseEntity<List<Periodo>>(le,HttpStatus.OK);
        }
        catch(Exception ex)
        {
            response.put(Messages.ERROR_KEY, ex.getMessage());
            return new ResponseEntity<Map<String,Object>>(response,HttpStatus.NOT_FOUND);
        }
    }
}
