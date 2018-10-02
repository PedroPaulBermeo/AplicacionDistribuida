/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.objetonegocio;

import ec.edu.ups.entidades.Pelicula;
import ec.edu.ups.entidades.PeliculaVista;
import ec.edu.ups.objetoaccesodatos.OAD;
import java.util.List;

/**
 *
 * @author Pedro Bermeo
 */
public class GestionPelicula {

    private GestionPeliculaVista gestionPeliculaVista;
    private OAD oad;

    public GestionPelicula() {
        gestionPeliculaVista = new GestionPeliculaVista();
        oad = new OAD();
    }

    public boolean agregarPelicula(List<String> pelicula) {

        if (validarDatosNulos(pelicula)) {
            Pelicula peli = convertirObjeto(pelicula);
            Pelicula p = buscarPelicula(peli.getNombre());
            if (p != null) {
                System.out.println("La pelicula ya existe");
                return false;
            } else {
                if (oad.obtenerConexion()) {
                    oad.insertarPelicula(peli);
                    oad.cerrarConexion();
                    return true;

                }
            }
        }

        return false;
    }

    public boolean modificarPelicula(List<String> pelicula) {

        if (validarDatosNulos(pelicula)) {
            Pelicula peli = convertirObjeto(pelicula);
            Pelicula p = buscarPelicula(peli.getNombre());

            if (p != null) {
                if (oad.obtenerConexion()) {
                    oad.modificarPelicula(peli);
                    oad.cerrarConexion();
                    return true;
                } else {
                    System.out.println("La pelicula no existe");
                    return false;
                }
            }
        }

        return false;
    }

    //Uso un metodo del otro ODN
    public boolean validarPelicula(int id) {
        List<PeliculaVista> peliculasVistas = gestionPeliculaVista.getTodasPeliculasVista();
        for (PeliculaVista pv : peliculasVistas) {
            if (pv.getIdPeliculaVista() == id) {
                return true;
            }
        }
        return false;
    }

    public Pelicula buscarPelicula(String nombre) {
        if (oad.obtenerConexion()) {
            Pelicula pelicula = new Pelicula();
            pelicula = oad.buscarPelicula(nombre);
            oad.cerrarConexion();
            return pelicula;

        }
        return null;
    }

    public boolean eliminarPelicula(int id) {
        if (oad.obtenerConexion()) {
            oad.eliminarPelicula(id);
            oad.cerrarConexion();
            return true;
        }
        return false;
    }

    public boolean validarDatosNulos(List<String> u) {
        for (String s : u) {
            if (s.equals(null)) {
                return false;
            }
        }
        return true;
    }

    public Pelicula convertirObjeto(List<String> pelicula) {
        Pelicula p = new Pelicula();
        p.setIdPelicula(Integer.parseInt(pelicula.get(0)));
        p.setNombre(pelicula.get(1));
        p.setDescripcion(pelicula.get(2));
        return p;
    }
}
