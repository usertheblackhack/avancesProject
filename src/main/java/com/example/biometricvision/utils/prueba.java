/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.example.biometricvision.utils;

import java.text.ParseException;

/**
 *
 * @author USUARIO
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        System.out.println(dateCurrent.getDateCurrent()+" fecha actual");
        System.out.println(dateCurrent.getHourCurrent()+" hora actual");
        encryptString jj=new encryptString();
        System.out.println(jj.encriptPassword("Jhon Leturne")+" forma principal");
        System.out.println(jj.textEncryptor("Jhon Leturne")+" forma secundaria encriptado"); //fArPLCnTZc0PxdAAZT0iqQ==
        System.out.println(jj.textDecryptor("fArPLCnTZc0PxdAAZT0iqQ==")+" forma secundaria descencriptado");
    }
    
}
