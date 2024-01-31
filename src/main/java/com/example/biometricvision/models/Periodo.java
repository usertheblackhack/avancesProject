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
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
@Table(name="periodo")
public class Periodo implements Serializable
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    Long idperiodo;
    
    
    @Column(name = "fecha_inicio", nullable = false, unique = false)
    LocalDateTime fecha_inicio;
    
    
    @Column(name = "fecha_fin", nullable = false, unique = false)
    LocalDateTime fecha_fin;
    
    
    
    @Column(name = "fecha_creacion", nullable = false, unique = false)
    LocalDateTime  fecha_creacion;
    
    
    @Column(name = "fecha_modificacion", nullable = false, unique = false)
    LocalDateTime fecha_modificacion;
    
    
    @Value("true")
    @Column(name = "estado", nullable = false, unique = false)
    Boolean estado;
    
    
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
