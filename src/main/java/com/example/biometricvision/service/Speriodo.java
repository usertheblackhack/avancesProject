/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Horario;
import com.example.biometricvision.models.Periodo;
import com.example.biometricvision.repository.Ihorario;
import com.example.biometricvision.repository.Iperiodo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Speriodo 
{
    @Autowired
    Iperiodo iperiodo;
    
    public Periodo guardar_actualizar(Periodo periodo)
    {
        return iperiodo.save(periodo);
    }
    
    public void eliminar(Long id)
    {
        iperiodo.deleteById(id);
    }
    
    public Periodo buscar_id(Long id)
    {
        return iperiodo.findByIdperiodo(id);
    }
    
    public List<Periodo> all()
    {
        return iperiodo.findAll();
    }
}
