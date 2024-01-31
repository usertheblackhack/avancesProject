/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.repository;

import com.example.biometricvision.models.Estudiante;
import com.example.biometricvision.models.Profesor;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public interface Iprofesor extends JpaRepository<Profesor,Serializable>
{
   public Profesor findByIdprofesor(Long id);
   public Profesor findByCedula(String cedula);
}
