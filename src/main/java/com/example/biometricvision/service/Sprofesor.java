/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Profesor;
import com.example.biometricvision.repository.Iprofesor;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Sprofesor 
{
    @Autowired
    Iprofesor iprofesor;
    
    
    public Profesor guardar_actualizar(Profesor profesor)
    {
        return iprofesor.save(profesor);
    }
    
    public void eliminar(Long id)
    {
        iprofesor.deleteById(id);
    }
    
    public Profesor buscar_id(Long id)
    {
        return iprofesor.findByIdprofesor(id);
    }
    
    public Profesor buscar_cedula(String cedula)
    {
        return iprofesor.findByCedula(cedula);
    }
    
    public List<Profesor> all()
    {
        return iprofesor.findAll();
    }

}
