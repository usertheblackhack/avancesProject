/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Matriculacion;
import com.example.biometricvision.repository.Imatriculacion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Smatriculacion 
{
    @Autowired
    Imatriculacion imatriculacion;
    
    public Matriculacion guardar_actualizar(Matriculacion matriculacion)
    {
        return imatriculacion.save(matriculacion);
    }
    
    public void eliminar(Long id)
    {
        imatriculacion.deleteById(id);
    }
    
    public Matriculacion buscar_id(Long id)
    {
        return imatriculacion.findByIdmatriculacion(id);
    }
    

    public List<Matriculacion> all()
    {
        return imatriculacion.findAll();
    }

}
