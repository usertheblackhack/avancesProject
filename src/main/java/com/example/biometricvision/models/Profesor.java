/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author USUARIO
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="profesor")
public class Profesor implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idprofesor;
    
    @Column(name = "cedula", nullable = false, unique = true, length = 10)
    String cedula;
    
    @Column(name = "nombre", nullable = false, unique = false, length = 50)
    String nombre;
    
    @Column(name = "apellido", nullable = false, unique = false, length = 50)
    String apellido;
    
    @Column(name = "edad", nullable = false, unique = false)
    Integer edad;
    
    @Column(name = "correo", nullable = false, unique = true, length = 100)
    String correo;
    
    @Column(name = "direccion", nullable = false, unique = false, length = 300)
    String direccion;
    
    @Column(name = "sexo", nullable = false, unique = false)
    Boolean sexo;
    
    @Column(name = "numero_telefono", nullable = false, unique = true, length = 10)
    String numero_telefono;
    
    @Value("true")
    @Column(name = "estado", nullable = false, unique = false)
    Boolean estado;
    
    
    @Column(name = "fecha_creacion", nullable = false, unique = false)
    LocalDateTime  fecha_creacion;
    
    
    @Column(name = "fecha_modificacion", nullable = false, unique = false)
    LocalDateTime fecha_modificacion;
    
    
    @OneToMany(mappedBy = "idprofesor")
    private List<Horario> lstHorario;
    
    
    
    @PrePersist 
    public  void  onPrePersist () { 
        this.fecha_creacion=LocalDateTime.now(); 
        this.fecha_modificacion=LocalDateTime.now(); 
    } 

    @PreUpdate 
    public  void  onPreUpdate () { 
        this.fecha_modificacion=LocalDateTime.now(); 
    } 
    

}
