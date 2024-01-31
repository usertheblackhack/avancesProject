/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.biometricvision.repository;

import com.example.biometricvision.models.Matriculacion;
import com.example.biometricvision.models.Periodo;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USUARIO
 */
public interface Iperiodo extends JpaRepository<Periodo,Serializable>
{
    public Periodo findByIdperiodo(Long id);
}
