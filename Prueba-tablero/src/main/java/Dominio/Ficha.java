/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author favel
 */
public class Ficha implements Serializable {

    private Integer lado1;
    private Integer lado2;
 private String rutaImagen;
 
    public Ficha() {
    }

    public Ficha(Integer lado1, Integer lado2) {
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    public Ficha(Integer lado1, Integer lado2, String rutaImagen) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.rutaImagen = rutaImagen;
    }

    public Integer getLado1() {
        return lado1;
    }

    public void setLado1(Integer lado1) {
        this.lado1 = lado1;
    }

    public Integer getLado2() {
        return lado2;
    }

    public void setLado2(Integer lado2) {
        this.lado2 = lado2;
    }

    public boolean esMula() {
        return this.getLado1() == this.getLado2();
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public String toString() {
        return "Ficha{" + "lado1=" + lado1 + ", lado2=" + lado2 + ", rutaImagen=" + rutaImagen + '}';
    }
    
  

}
