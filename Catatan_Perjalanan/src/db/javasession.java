/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author crYptONE
 */
public class javasession {
    
    private static String nik;
    private static String nama;
    
    public static String get_Nik(){
        return nik;
    }
    public static void set_Nik(String nik){
        javasession.nik = nik;
    }
    
    public static String get_Nama(){
        return nama;
    }
    public static void set_Nama(String nama){
        javasession.nama = nama;
    }
    
}
