/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.biometricvision.service;

import com.example.biometricvision.models.Usuario;
import com.example.biometricvision.repository.Iusuario;
import com.example.biometricvision.utils.encryptString;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class Susuario 
{
    @Autowired
    Iusuario iusuario;
    
    public Usuario guardar(Usuario usuario)
    {
        encryptString encriptar=new encryptString();
        usuario.setContrasenia(encriptar.encriptPassword(usuario.getContrasenia()));
        return iusuario.save(usuario);
    }
    
    
    public Usuario actualizar(Usuario usuario,Boolean contrasenia)
    {
        if(!contrasenia)
            return iusuario.save(usuario);
        else{
            encryptString encriptar=new encryptString();
            usuario.setContrasenia(encriptar.encriptPassword(usuario.getContrasenia()));
            return iusuario.save(usuario);
        }
    }
    
    public void eliminar(Long id)
    {
        iusuario.deleteById(id);
    }
    
    public Usuario buscar_id(Long id)
    {
        return iusuario.findByIdusuario(id);
    }
    
    public Usuario buscar_usuario(String usuario)
    {
        return iusuario.findByUsuario(usuario);
    }
    
    
    
    public List<Usuario> all()
    {
        return iusuario.findAll();
    }

}
