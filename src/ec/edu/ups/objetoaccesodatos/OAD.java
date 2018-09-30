/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetoaccesodatos;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class OAD {

    public OAD() {
    }
    
    public boolean insertarUsuario(Usuario u){
        
        return false;
    }
    
    public boolean modificarUsuario(Usuario u){
        
        return false;
    }
    
    public boolean eliminarUsuario(int id){
        
        return false;
    }
    
    public Usuario buscarUsuario(int cedula){
        
        return null;
    }
    
    public List<Usuario>listarUsuarios(){
        
        return null;
    }
    
    public boolean insertarPelicula(Pelicula p){
        return false;
    }
    
    
    public boolean modificarPelicula(Pelicula p){
        return false;
    }
    
    
    public boolean eliminarPelicula(int id){
        return false;
    }
    
    
    public Pelicula buscarPelicula(String nombre){
        return null;
    }
    
    public List<Pelicula>listarPelicula(){
        return null;
    }
    
    public boolean insertarPeliculaVista(PeliculaVista pv){
        return false;
    }
 
    public boolean modificarPeliculaVista(PeliculaVista pv){
        return false;
    }
    public boolean eliminarPeliculaVista(int id){
        return false;
    }
    
    public List<PeliculaVista> listarPeliculaVista(){
        return null;
    }
    
    
}
