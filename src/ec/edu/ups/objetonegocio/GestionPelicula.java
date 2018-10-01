/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.entidades.PeliculaVista;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionPelicula {

    private GestionPeliculaVista gestionPeliculaVista;
    
    public GestionPelicula() {
        gestionPeliculaVista=new GestionPeliculaVista();
    }
     
    public boolean agregarPelicula(List<String> pelicula){
        
        return false;
    }
    public boolean modificarPelicula(List<String> pelicula){
        
        return false;
    }
    //Uso un metodo del otro ODN
    public boolean validarPelicula(int id){
        List<PeliculaVista>peliculasVistas=gestionPeliculaVista.getTodasPeliculasVista();
        return false;
    }
    
    public Pelicula buscarPelicula(int id){
        return null;
    }
    
    public boolean eliminarPelicula(int id){
        return false;
    }
    
    public boolean validarDatosNulos(List<String>u){
        for(String s:u){
            if(s.equals(null)){
                return false;
            }
        }
        return true;
    }
    public Pelicula convertirObjeto(List<String>pelicula){
        Pelicula p = new Pelicula();
        p.setIdPelicula(Integer.parseInt(pelicula.get(0)));
        p.setNombre(pelicula.get(1));
        p.setDescripcion(pelicula.get(2));
        return p;
    }
}
