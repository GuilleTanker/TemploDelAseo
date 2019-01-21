/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Formulario;

/**
 *
 * @author Administrador
 */
public class listaclientes {

   private String codigo;
   private String nombres;
   private String tienda; 
   private String barrio;
   private String telefono;

    public listaclientes(String codigo, String nombres, String tienda, String barrio, String telefono) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.tienda = tienda;
        this.barrio = barrio;
        this.telefono = telefono;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
    }
