/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.objetoaccesodatos.OAD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionPelicula {
    
    
    private GestionPeliculaVista gestionPeliculaVista;
    private OAD oad;
    public GestionPelicula() {
        gestionPeliculaVista=new GestionPeliculaVista();
        oad=new OAD();
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
        for(PeliculaVista pv:peliculasVistas){
            if(pv.getIdPelicula().getIdPelicula()==id){
                return true;
            }
        }
        return false;
    }
    
    public List<String> buscarPelicula(String nombre){
        List<String>lista=new ArrayList<>();
        
        if(oad.obtenerConexion()){
            Pelicula pelicula =new Pelicula();
            pelicula=oad.buscarPelicula(nombre);
            oad.cerrarConexion();
            lista.add(""+pelicula.getIdPelicula());
            lista.add(pelicula.getNombre());
            lista.add(pelicula.getDescripcion());
            return lista;        
        }
        return null;
    }
    
    public boolean eliminarPelicula(int id){
           if(oad.obtenerConexion()){
               oad.eliminarPelicula(id);
               oad.cerrarConexion();
               return true;
           }
        return false;
    }
    
    public List<String> getTodasPeliculas(){
        List<Pelicula>peliculas=new ArrayList<>();
        List<String>peliculasRetornar=new ArrayList<>();
        
        
        if (oad.obtenerConexion()) {
            peliculas = oad.listarPelicula();
            oad.cerrarConexion();
        }
        for(Pelicula p:peliculas){
            peliculasRetornar.add(""+p.getIdPelicula());
            peliculasRetornar.add(p.getNombre());
            peliculasRetornar.add(p.getDescripcion());
        }
        
        return peliculasRetornar;
    
        
    }
    public Pelicula convertirObjeto(List<String>pelicula){
        Pelicula p = new Pelicula();
        p.setIdPelicula(Integer.parseInt(pelicula.get(0)));
        p.setNombre(pelicula.get(1));
        p.setDescripcion(pelicula.get(2));
        return p;
    }
}
