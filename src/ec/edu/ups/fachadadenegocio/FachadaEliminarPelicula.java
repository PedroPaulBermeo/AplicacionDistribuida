/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.fachadadenegocio;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.objetonegocio.GestionPelicula;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class FachadaEliminarPelicula {
    GestionPelicula gestionPelicula;
    
    public FachadaEliminarPelicula() {
        gestionPelicula= new GestionPelicula();
    }
    public boolean eliminarPelicula(String nombre){
        List<String>  pe = gestionPelicula.buscarPelicula(nombre);
        Pelicula p =gestionPelicula.convertirObjeto(pe);
        if(gestionPelicula.validarPelicula(p.getIdPelicula())==false){
            gestionPelicula.eliminarPelicula(p.getIdPelicula());
            return true;
        }
        return false;
    }
    
    
}
